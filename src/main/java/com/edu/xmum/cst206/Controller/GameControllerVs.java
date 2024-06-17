package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Config;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.V1.FailView;
import com.edu.xmum.cst206.View.Interface.IGameView;

/*
需要双人控制的模型
 */

public class GameControllerVs implements IGameController {
    private IGameService gameService;
    private IGameView gameView;

    public GameControllerVs(IGameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public void startGame() {
        gameService.resetGame();
        showRunView();
    }

    @Override
    public void resetGame() {
        gameService.resetGame();
        gameView.getRunView().adjustLayout();
    }

    @Override
    public void setDifficulty(String difficulty) {
        switch (difficulty.toUpperCase()) {
            case "EASY":
                Config.diff = Difficulty.EASY;
                break;
            case "MEDIUM":
                Config.diff = Difficulty.MEDIUM;
                break;
            case "HARD":
                Config.diff = Difficulty.HARD;
                break;
            default:
                throw new IllegalArgumentException("Unknown difficulty: " + Config.diff);
        }
        gameService.setDifficulty(Config.diff);
        showPrepareView();
    }

    public String getDiffculty() {
        switch (Config.diff) {
            case EASY:
                return "Easy";
            case MEDIUM:
                return "Medium";
            case HARD:
                return "Hard";
        }
        return null;
    }

    private void adjustCellSize() {
        double cellWidth = Config.SCENE_WIDTH / gameService.getMazeService().getMaze().getCols();
        double cellLength = Config.SCENE_HEIGHT / gameService.getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellLength, cellWidth);
        gameView.getRunView().getPlayerView().setCellSize(cellSize);
        gameView.getRunView().getSecondPlayerView().setCellSize(cellSize);
        gameView.getRunView().getMazeView().setCellSize(cellSize);
    }

    @Override
    public void handleKeyPress(String key) {
        Direction direction = null;
        Direction secondPlayerDirection = null;
        boolean isPlayerOne = true;

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
            case "I":
                secondPlayerDirection = Direction.UP;
                isPlayerOne = false;
                break;
            case "J":
                secondPlayerDirection = Direction.LEFT;
                isPlayerOne = false;
                break;
            case "K":
                secondPlayerDirection = Direction.DOWN;
                isPlayerOne = false;
                break;
            case "L":
                secondPlayerDirection = Direction.RIGHT;
                isPlayerOne = false;
                break;
            default:
                throw new IllegalArgumentException("Unknown key: " + key);
        }

        if (isPlayerOne) {
            boolean reachedGoal = movePlayer(direction);
            gameView.getRunView().getPlayerView().setDirection(direction);
            if (reachedGoal) {
                showVictoryView("Player 1 ");
            }
        } else {
            boolean reachedGoal = moveSecondPlayer(secondPlayerDirection);
            gameView.getRunView().getSecondPlayerView().setDirection(secondPlayerDirection);
            if (reachedGoal) {
                showVictoryView("Player 2 ");
            }
        }
    }

    private boolean movePlayer(Direction direction) {
        boolean hasWon = gameService.movePlayer(direction);
        gameView.getRunView().getPlayerView().draw();
        return hasWon;
    }

    private boolean moveSecondPlayer(Direction direction) {
        boolean hasWon = gameService.moveSecondPlayer(direction);
        gameView.getRunView().getSecondPlayerView().draw();
        return hasWon;
    }

    @Override
    public void showSelectionView() {
        gameView.setSelectionView(FactoryProducer.getFactory("Select").getSelectionView(Config.skin));
        gameView.getSelectionView().getEasyButton().setOnAction(event -> setDifficulty("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> setDifficulty("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> setDifficulty("Hard"));
        gameView.showSelectionView();
    }

    @Override
    public void showPrepareView() {
        gameView.setPrepareView(FactoryProducer.getFactory("Prepare").getPrepareView(Config.skin));
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startGame());
        gameView.showPrepareView();
    }

    @Override
    public void showRunView() {
        gameView.setRunView(FactoryProducer.getFactory("Run").getRunView(Config.skin, this));
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
    public void showVictoryView(String winner) {
        gameView.setVictoryView(FactoryProducer.getFactory("Victory").getVictoryView(Config.skin));
        gameView.getVictoryView().setWinner(winner);
        gameView.getVictoryView().getBackButton().setOnAction(e -> {
            showSelectionView();
        });
        gameView.showVictoryView();
    }

    @Override
    public void showHint() {
        gameView.getRunView().showHint(gameService.getHint());
    }

    @Override
    public void setGameView(IGameView gameView) {
        this.gameView = gameView;
        getGameView().setWelcomeView(FactoryProducer.getFactory("Welcome").getWelcomeView(Config.skin));
        gameView.getWelcomeView().getStartButton().setOnAction(actionEvent1 -> {
            showSelectionView();
        });
        getGameView().showWelcomeView();
    }
    //Vs版本不需要
    @Override
    public void startAiMovement() {

    }
    @Override
    public void showFailureView() {
        gameView.setFailView(new FailView()); // 这里可以改成用抽象工厂来选择皮肤，暂时不需要
        gameView.getFailView().getBackButton().setOnAction(e -> showSelectionView()); // 跳转
        gameView.showFailView();
    }

    public IGameService getGameService() {
        return gameService;
    }

    public IGameView getGameView() {
        return gameView;
    }
}
