package com.edu.xmum.CST210.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.CST210.Controller.IGameController;
import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.View.Interface.IMazeView;
import com.edu.xmum.CST210.View.Interface.IPlayerView;
import com.edu.xmum.CST210.View.Interface.IRunView;
import com.edu.xmum.CST210.View.Styler.RunViewStyler;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the run view for version 2.
 * This class is responsible for displaying the main game interface, including the maze,
 * player views, and handling interactions such as reset and hint buttons.
 */
public class RunViewV2 extends BorderPane implements IRunView {
    private final IPlayerView playerView;
    private final IMazeView mazeView;
    private final Label currentDifficulty;
    private final Button resetButton;
    private final Button hintButton;
    private final IGameController gameController;
    private Timeline hintTimeline = new Timeline();

    /**
     * Constructor to initialize the RunViewV2 components.
     *
     * @param gameController The game controller to manage game logic.
     */
    public RunViewV2(IGameController gameController) {
        // Initializing components
        this.gameController = gameController;
        currentDifficulty = new Label("Difficulty: " + gameController.getDifficulty());
        mazeView = FactoryProducer.getFactory("GameView").getMazeView(Skin.V2, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.V2, gameController.getGameService().getPlayerService().getPlayer());
        resetButton = new Button("Restart");
        hintButton = new Button("Tips");

        // Setting the button style
        RunViewStyler.resetButtonStyle(Skin.V2, resetButton);
        RunViewStyler.hintButtonStyle(Skin.V2, hintButton);
        // Setting fonts and colors
        RunViewStyler.difficultyTitleStyle(Skin.V2, currentDifficulty);

        // Setting the prompt message style
        HBox infoBox = new HBox(20, currentDifficulty);
        RunViewStyler.infoBoxStyle(Skin.V2, infoBox);

        // Setting the control panel style
        HBox controlBox = new HBox(20, resetButton, hintButton);
        RunViewStyler.controlBoxStyle(Skin.V2, controlBox);

        // Setting the game panel style
        StackPane gamePane = new StackPane();
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode());
        RunViewStyler.gameBoxStyle(Skin.V2, gamePane);

        // Ensure that the game panel can gain focus
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());

        // Adding a listener to resize a component
        gamePane.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout());
        gamePane.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout());

        // Adjustments to the overall page
        // Controlling typography
        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);
        RunViewStyler.BoxStyle(Skin.V2, this);
    }

    /**
     * Gets the reset button in the RunView.
     *
     * @return The reset button.
     */
    @Override
    public Button getResetButton() {
        return resetButton;
    }

    /**
     * Gets the hint button in the RunView.
     *
     * @return The hint button.
     */
    @Override
    public Button getHintButton() {
        return hintButton;
    }

    /**
     * Gets the root node of the RunView.
     *
     * @return The BorderPane root node.
     */
    @Override
    public BorderPane getNode() {
        return this;
    }

    /**
     * Gets the player view in the RunView.
     *
     * @return The player view.
     */
    @Override
    public IPlayerView getPlayerView() {
        return playerView;
    }

    /**
     * Gets the maze view in the RunView.
     *
     * @return The maze view.
     */
    @Override
    public IMazeView getMazeView() {
        return mazeView;
    }

    /**
     * Gets the AI view in the RunView.
     * Not required for V2.
     *
     * @return null.
     */
    @Override
    public IPlayerView getAiView() {
        return null;
    }

    /**
     * Gets the second player view in the RunView.
     * Not required for V2.
     *
     * @return null.
     */
    @Override
    public IPlayerView getSecondPlayerView() {
        return null;
    }

    /**
     * Resets and redraws the player and maze views.
     */
    @Override
    public void reSetView() {
        playerView.reDraw();
        mazeView.reDraw();
        hintTimeline.stop();
    }

    /**
     * Adjusts the layout of the game elements based on the current window size.
     */
    @Override
    public void adjustLayout() {
        double cellWidth = getWidth() / gameController.getGameService().getMazeService().getMaze().getCols();
        double cellHeight = (getHeight() - getTop().getLayoutBounds().getHeight() - getBottom().getLayoutBounds().getHeight()) /
                gameController.getGameService().getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellWidth, cellHeight);
        playerView.setCellSize(cellSize);
        mazeView.setCellSize(cellSize);
        reSetView();
        // Center the maze and player views
        double mazeWidth = cellSize * gameController.getGameService().getMazeService().getMaze().getCols();
        double mazeHeight = cellSize * gameController.getGameService().getMazeService().getMaze().getRows();
        double offsetX = (getWidth() - mazeWidth) / 2;
        double offsetY = (getHeight() - ((HBox) getTop()).getHeight() - ((HBox) getBottom()).getHeight() - mazeHeight) / 2;

        mazeView.getNode().setTranslateX(offsetX);
        mazeView.getNode().setTranslateY(offsetY);
        playerView.getNode().setTranslateX(offsetX);
        playerView.getNode().setTranslateY(offsetY);
    }

    /**
     * Displays a hint path in the maze.
     * Highlights the path found by the DFS algorithm.
     *
     * @param path The list of coordinates representing the hint path.
     */
    @Override
    public void showHint(List<int[]> path) {
        int cellSize = mazeView.getCellSize();
        // Clear previous hints
        mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));

        // 如果存在旧的 Timeline，停止它
        if (hintTimeline != null) {
            hintTimeline.stop();
        }

        // 新建一个 Timeline
        hintTimeline = new Timeline();

        // Used to store the currently displayed rectangles for progressive deletion
        List<Rectangle> currentRects = new ArrayList<>();

        for (int i = 0; i < path.size(); i++) {
            int[] point = path.get(i);

            // Create a new rectangle for highlighting the current path point
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setUserData("highlight");

            // Encapsulate drawing and deleting operations in KeyFrame
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.2), event -> {
                // Add the current highlight rectangle to the canvas
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);

                // Create a new Timeline for each rectangle to gradually fade out the color
                Timeline fadeTimeline = new Timeline();
                KeyFrame fadeKeyFrame = new KeyFrame(Duration.seconds(2), new KeyValue(rect.fillProperty(), Color.TRANSPARENT));
                fadeTimeline.getKeyFrames().add(fadeKeyFrame);
                fadeTimeline.setOnFinished(e -> mazeView.getNode().getChildren().remove(rect));
                fadeTimeline.play();
            });

            hintTimeline.getKeyFrames().add(keyFrame);
        }

        hintTimeline.play();
    }

}
