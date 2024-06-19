package com.edu.xmum.cst206.Controller;

import Constant.Config;
import Constant.Difficulty;
import Constant.Direction;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.V1.FailView;
import com.edu.xmum.cst206.View.Interface.IGameView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import static Constant.Config.AI_SPEED;

/**
 * This class implements the main interface of the Controller layer for a single-player game.
 * It is responsible for receiving requests from the View layer and interacting with the Service layer.
 */
public class GameController implements IGameController {
    private final IGameService gameService;
    private IGameView gameView;
    private Timeline aiTimeline;
    private boolean isAiEnabled;

    /**
     * Constructor to initialize the game service.
     *
     * @param gameService The game service to be used for game logic.
     */
    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        // Reset the game state
        gameService.resetGame();
        isAiEnabled = Config.skin.getSkin().equals("V1");
        if (isAiEnabled) {
            startAiMovement(); // Start AI movement
        }
        showRunView(); // Display the run view
    }

    @Override
    public void resetGame() {
        // Reset the game state
        gameService.resetGame();
        isAiEnabled = Config.skin.getSkin().equals("V1");
        if (isAiEnabled) {
            startAiMovement(); // Start AI movement
        }

        gameView.getRunView().adjustLayout(); // Adjust the layout
    }

    @Override
    public String getDifficulty() {
        // Get the current difficulty level
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

    @Override
    public void setDifficulty(String difficulty) {
        // Set the game difficulty
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
                throw new IllegalArgumentException("Unknown difficulty: " + difficulty);
        }
        gameService.setDifficulty(Config.diff); // Apply the difficulty setting to the game service
        showPrepareView(); // Show the prepare view
    }

    private void adjustCellSize() {
        // Adjust the cell size based on scene dimensions
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
        // Handle key press events to move the player
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
        boolean reachedGoal = movePlayer(direction); // Move the player in the specified direction
        gameView.getRunView().getPlayerView().setDirection(direction); // Update the player's direction
        if (reachedGoal) {
            showVictoryView("Player "); // Show victory view if the goal is reached
        }
    }

    private boolean movePlayer(Direction direction) {
        // Move the player in the specified direction
        boolean hasWon = gameService.movePlayer(direction);
        gameView.getRunView().getPlayerView().draw(); // Redraw the player view
        return hasWon;
    }

    @Override
    public void showSelectionView() {
        // Show the selection view for choosing game settings
        gameView.setSelectionView(FactoryProducer.getFactory("GameView").getSelectionView(Config.skin));
        gameView.getSelectionView().getEasyButton().setOnAction(event -> setDifficulty("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> setDifficulty("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> setDifficulty("Hard"));
        gameView.showSelectionView();
    }

    @Override
    public void showPrepareView() {
        // Show the preparation view before starting the game
        gameView.setPrepareView(FactoryProducer.getFactory("GameView").getPrepareView(Config.skin));
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startGame());
        gameView.showPrepareView();
    }

    @Override
    public void showRunView() {
        // Show the run view where the game is played
        gameView.setRunView(FactoryProducer.getFactory("GameView").getRunView(Config.skin, this));
        adjustCellSize(); // Adjust cell size for the game view
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
        // Show the victory view when the player wins
        gameView.setVictoryView(FactoryProducer.getFactory("GameView").getVictoryView(Config.skin));
        gameView.getVictoryView().setWinner(winner);
        gameView.getVictoryView().getBackButton().setOnAction(e -> {
            showSelectionView();
        });
        gameView.showVictoryView();
    }

    @Override
    public void showHint() {
        // Show a hint for the player
        gameView.getRunView().showHint(gameService.getHint());
    }

    @Override
    public void startAiMovement() {
        // Start the AI movement logic
        if (aiTimeline != null) {
            aiTimeline.stop();
        }

        aiTimeline = new Timeline(new KeyFrame(Duration.seconds(AI_SPEED), event -> {
            gameService.getAiService().moveAi(); // Move the AI
            gameView.getRunView().getAiView().draw(); // Redraw the AI view
            gameView.getRunView().getPlayerView().draw(); // Redraw the player view

            if (gameService.getAiService().isPlayerCaught()) {
                System.out.println("Player caught by AI!");
                aiTimeline.stop();
                showFailureView(); // Show the failure view if the player is caught by AI
            }
        }));
        aiTimeline.setCycleCount(Timeline.INDEFINITE);
        aiTimeline.play();
    }

    @Override
    public void showFailureView() {
        // Show the failure view when the player loses
        gameView.setFailView(new FailView()); // Here you can instead use an abstract factory to select the skin
        gameView.getFailView().getBackButton().setOnAction(e -> showSelectionView()); // Navigate back to selection view
        gameView.showFailView();
    }

    public IGameService getGameService() {
        return gameService;
    }

    public IGameView getGameView() {
        return gameView;
    }

    @Override
    public void setGameView(IGameView gameView) {
        // Set the game view
        this.gameView = gameView;
        getGameView().setWelcomeView(FactoryProducer.getFactory("GameView").getWelcomeView(Config.skin));
        gameView.getWelcomeView().getStartButton().setOnAction(actionEvent1 -> {
            showSelectionView();
        });
        getGameView().showWelcomeView();
    }
}
