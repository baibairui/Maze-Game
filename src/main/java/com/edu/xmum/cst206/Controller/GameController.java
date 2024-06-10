package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Config;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.PrepareView;
import com.edu.xmum.cst206.View.Entity.RunView;
import com.edu.xmum.cst206.View.Entity.SelectionView;
import com.edu.xmum.cst206.View.Entity.VictoryView;
import com.edu.xmum.cst206.View.Interface.IGameView;

import static com.edu.xmum.cst206.Model.Difficulty.MEDIUM;


public class GameController implements IGameController {
    private IGameService gameService;
    private IGameView gameView;
    private Difficulty diff;
    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }
    /*
    改用setter注入，
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
            handleKeyPress(event.getText());
        });
    }
     */
    /*
    private void handleVictory() {
        System.out.println("Victory!");
        gameView.showVictoryView();
    }
    */
    @Override
    public void startGame() {
        gameService.resetGame();
        showRunView();
    }

    @Override
    public void resetGame() {
        // 重置玩家和迷宫的状态
        gameService.resetGame();
        //调整尺寸并重新绘图
        gameView.getRunView().adjustLayout();
    }

    @Override
    public void setDifficulty(String difficulty) {
        switch (difficulty.toUpperCase()) {
            case "EASY":
                diff = Difficulty.EASY;
                break;
            case "MEDIUM":
                diff = MEDIUM;
                break;
            case "HARD":
                diff = Difficulty.HARD;
                break;
            default:
                throw new IllegalArgumentException("Unknown difficulty: " + difficulty);
        }
        //调整尺寸，设计定难度
        gameService.setDifficulty(diff);
        showPrepareView();
    }
    public String getDiffculty(){
        switch (diff){
            case EASY -> {
                return "Easy";
            }
            case MEDIUM -> {
                return "Medium";
            }
            case HARD -> {
                return "HARD";
            }
        }
        return null;
    }
    private void adjustCellSize() {
        double cellWidth = Config.SCENE_WIDTH / gameService.getMazeService().getMaze().getCols();
        double cellLength = Config.SCENE_HEIGHT / gameService.getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellLength, cellWidth);
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
        boolean reachedGoal = movePlayer(direction);
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
        gameView.setSelectionView(new SelectionView());
        gameView.getSelectionView().getEasyButton().setOnAction(event -> setDifficulty("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> setDifficulty("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> setDifficulty("Hard"));
        gameView.showSelectionView();
    }

    @Override
    public void showPrepareView() {
        gameView.setPrepareView(new PrepareView());
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startGame());
        gameView.showPrepareView();
    }

    @Override
    public void showRunView() {
        gameView.setRunView(new RunView(this));
        adjustCellSize();
        gameView.getRunView().reSetView();
        gameView.getRunView().getResetButton().setOnAction(event -> resetGame());
        gameView.getRunView().getHintButton().setOnAction(event -> showHint());
        gameView.getRunView().getNode().setOnKeyPressed(event -> {
            handleKeyPress(event.getText());
        });
        gameView.showRunView();
    }

    @Override
    public void showVictoryView() {
        gameView.setVictoryView(new VictoryView());
        gameView.showVictoryView();
    }

    @Override
    public void showHint() {
        // 提示功能可以在这里实现
        gameView.getRunView().showHint(gameService.getHint());
    }

    @Override
    public void setGameView(IGameView gameView) {
        this.gameView = gameView;
        gameView.getWelcomeView().getStartButton().setOnAction(event -> showSelectionView());
        //setupEventHandlers();
    }

    public IGameService getGameService() {
        return gameService;
    }

    public IGameView getGameView() {
        return gameView;
    }
}
