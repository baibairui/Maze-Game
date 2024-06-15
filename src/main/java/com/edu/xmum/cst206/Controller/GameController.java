package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Config;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.V1.FailView;
import com.edu.xmum.cst206.View.Interface.IGameView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameController implements IGameController {
    private IGameService gameService;
    private IGameView gameView;
    private Difficulty diff;
    private String SkinVision;
    private Timeline aiTimeline;
    private boolean isAiEnabled;

    public String getSkinVision() {
        return SkinVision;
    }

    public void setSkinVision(String skinVision) {
        SkinVision = skinVision;
        // 根据皮肤设置是否启用AI
        isAiEnabled = skinVision.equals("V1");
    }

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        gameService.resetGame();
        if (isAiEnabled) {
            startAiMovement();
        }
        showRunView();
    }

    @Override
    public void resetGame() {
        gameService.resetGame();
        if (isAiEnabled) {
            startAiMovement();
        }
        gameView.getRunView().adjustLayout();
    }

    @Override
    public void setDifficulty(String difficulty) {
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
        gameService.setDifficulty(diff);
        showPrepareView();
    }

    public String getDiffculty() {
        switch (diff) {
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
        gameView.getRunView().getMazeView().setCellSize(cellSize);
        if (isAiEnabled) {
            gameView.getRunView().getAiView().setCellSize(cellSize);
        }
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
        gameView.getRunView().getPlayerView().setDirection(direction);
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
        gameView.setSelectionView(FactoryProducer.getFactory("Select").getSelectionView(SkinVision));
        gameView.getSelectionView().getEasyButton().setOnAction(event -> setDifficulty("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> setDifficulty("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> setDifficulty("Hard"));
        gameView.showSelectionView();
    }

    @Override
    public void showPrepareView() {
        gameView.setPrepareView(FactoryProducer.getFactory("Prepare").getPrepareView(SkinVision));
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startGame());
        gameView.showPrepareView();
    }

    @Override
    public void showRunView() {
        gameView.setRunView(FactoryProducer.getFactory("Run").getRunView(SkinVision, this));
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
        gameView.setVictoryView(FactoryProducer.getFactory("Victory").getVictoryView(SkinVision));
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
        ArrayList<Button> buttons = gameView.getSkinSelectionView().getButtons();
        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnAction(actionEvent -> {
                setSkinVision("V" + (finalI + 1));
                getGameView().setWelcomeView(FactoryProducer.getFactory("Welcome").getWelcomeView(SkinVision));
                gameView.getWelcomeView().getStartButton().setOnAction(actionEvent1 -> {
                    showSelectionView();
                });
                getGameView().showWelcomeView();
            });
        }
    }

    private void startAiMovement() {
        if (aiTimeline != null) {
            aiTimeline.stop();
        }

        aiTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            gameService.getAiService().moveAi();
            gameView.getRunView().getAiView().draw(); // 重新绘制 AI 视图
            gameView.getRunView().getPlayerView().draw();

            if (gameService.getAiService().isPlayerCaught()) {
                System.out.println("Player caught by AI!");
                aiTimeline.stop();
                showFailureView();
            }
        }));
        aiTimeline.setCycleCount(Timeline.INDEFINITE);
        aiTimeline.play();
    }

    private void showFailureView() {
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
