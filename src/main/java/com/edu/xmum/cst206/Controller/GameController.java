package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Config;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Interface.IGameView;


public class GameController implements IGameController {
    private IGameService gameService;
    private IGameView gameView;

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }
    //通过setter注入view

    private void setupEventHandlers() {
        if (gameView == null) {
            throw new NullPointerException("gameView is null in setupEventHandlers");
        }
        gameView.getWelcomeView().getStartButton().setOnAction(event -> showSelectionView());
        gameView.getSelectionView().getEasyButton().setOnAction(event -> setDifficulty("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> setDifficulty("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> setDifficulty("Hard"));
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startGame());
        gameView.getRunView().getResetButton().setOnAction(event -> resetGame());
        gameView.getRunView().getHintButton().setOnAction(event -> showHint());

        gameView.getRunView().getNode().setOnKeyPressed(event -> {
            boolean hasWon = false;
            switch (event.getCode()) {
                case W -> hasWon = movePlayer(Direction.UP);
                case A -> hasWon = movePlayer(Direction.LEFT);
                case S -> hasWon = movePlayer(Direction.DOWN);
                case D -> hasWon = movePlayer(Direction.RIGHT);
            }
            gameView.getRunView().getPlayerView().draw();
            if (hasWon) {
                handleVictory();
            }
        });
    }

    private void handleVictory() {
        System.out.println("Victory!");
        gameView.showVictoryView();
    }

    @Override
    public void startGame() {
        gameService.resetGame();
        showRunView();
    }

    @Override
    public void resetGame() {
        gameService.resetGame();
        showRunView();
    }

    @Override
    public void setDifficulty(String difficulty) {
        Difficulty diff;
        switch (difficulty.toUpperCase()) {
            case "EASY":
                diff = Difficulty.EASY;
                break;
            case "MEDIUM":
                diff = Difficulty.MEDIUM;
                break;
            case "HARD":
                diff = Difficulty.HARD;
                break;
            default:
                throw new IllegalArgumentException("Unknown difficulty: " + difficulty);
        }
        //设置难度
        gameService.setDifficulty(diff);
        //根据难度设计cellSize
        adjustCellSize();
        //重绘页面
        gameView.getRunView().reSetView();
        showPrepareView();
    }
    //根据难度调整方块大小
    private void adjustCellSize(){
        double cellWidth= Config.SCENE_WIDTH/gameService.getMazeService().getMaze().getCols();
        double cellLength= Config.SCENE_LENGTH/gameService.getMazeService().getMaze().getRows();
        int cellSize=(int)Math.min(cellLength,cellWidth);
        gameView.getRunView().getPlayerView().setCellSize(cellSize);
        gameView.getRunView().getMazeView().setCellSize(cellSize);
    }
    @Override
    public void handleKeyPress(String key) {
        Direction direction;
        switch (key.toUpperCase()) {
            case "W":
                direction = Direction.UP;
                break;
            case "A":
                direction = Direction.LEFT;
                break;
            case "S":
                direction = Direction.DOWN;
                break;
            case "D":
                direction = Direction.RIGHT;
                break;
            default:
                throw new IllegalArgumentException("Unknown key: " + key);
        }
        boolean reachedGoal = gameService.movePlayer(direction);
        if (reachedGoal) {
            showVictoryView();
        }
    }

    private boolean movePlayer(Direction direction) {
        boolean hasWon = gameService.movePlayer(direction);
        gameView.getRunView().getPlayerView().draw();
        return hasWon;
    }

    @Override
    public void showSelectionView() {
        gameView.showSelectionView();
    }

    @Override
    public void showPrepareView() {
        gameView.showPrepareView();
    }

    @Override
    public void showRunView() {
        gameView.showRunView();
    }

    @Override
    public void showVictoryView() {
        gameView.showVictoryView();
    }

    @Override
    public void showHint() {

    }

    @Override
    public void setGameView(IGameView gameView) {
        this.gameView=gameView;
        setupEventHandlers();
    }

    public IGameService getGameService() {
        return gameService;
    }

    public IGameView getGameView() {
        return gameView;
    }
}
