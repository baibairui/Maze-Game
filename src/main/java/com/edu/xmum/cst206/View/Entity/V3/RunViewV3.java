package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Styler.RunViewStyler;
import javafx.animation.KeyFrame;
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
 * Implementation of the run view for version 3.
 * This class is responsible for displaying the main game interface, including the maze,
 * player, and second player views, and handling interactions such as reset and hint buttons.
 */
public class RunViewV3 extends BorderPane implements IRunView {
    private final IPlayerView playerView;
    private final IPlayerView secondPlayerView;
    private final IMazeView mazeView;
    private final Label currentDifficulty;
    private final Button resetButton;
    private final Button hintButton;
    private final IGameController gameController;

    /**
     * Constructor to initialize the RunViewV3 components.
     *
     * @param gameController The game controller to manage game logic.
     */
    public RunViewV3(IGameController gameController) {
        // Initializing components
        this.gameController = gameController;
        currentDifficulty = new Label("Difficulty: " + gameController.getDifficulty());
        mazeView = FactoryProducer.getFactory("GameView").getMazeView(Skin.V3, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.V3, gameController.getGameService().getPlayerService().getPlayer());
        secondPlayerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.Vs, gameController.getGameService().getSecondPlayerService().getPlayer());
        resetButton = new Button("Restart");
        hintButton = new Button("Tips");

        // Applying styles to components
        RunViewStyler.resetButtonStyle(Skin.V3, resetButton);
        RunViewStyler.hintButtonStyle(Skin.V3, hintButton);
        RunViewStyler.difficultyTitleStyle(Skin.V3, currentDifficulty);
        HBox infoBox = new HBox(20, currentDifficulty);
        RunViewStyler.infoBoxStyle(Skin.V3, infoBox);
        HBox controlBox = new HBox(20, resetButton, hintButton);
        RunViewStyler.infoBoxStyle(Skin.V3, controlBox);
        StackPane gamePane = new StackPane();
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode(), secondPlayerView.getNode());
        RunViewStyler.gameBoxStyle(Skin.V3, gamePane);

        // Ensuring the game panel can gain focus
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());

        // Adding listeners to resize components
        gamePane.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout());
        gamePane.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout());

        // Setting the main border and adding components to the layout
        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);
        RunViewStyler.BoxStyle(Skin.V3, this);
    }

    @Override
    public Button getResetButton() {
        return resetButton;
    }

    @Override
    public Button getHintButton() {
        return hintButton;
    }

    @Override
    public BorderPane getNode() {
        return this;
    }

    @Override
    public IPlayerView getPlayerView() {
        return playerView;
    }

    @Override
    public IMazeView getMazeView() {
        return mazeView;
    }

    @Override
    public IPlayerView getAiView() {
        return null;
    }

    @Override
    public IPlayerView getSecondPlayerView() {
        return secondPlayerView;
    }

    @Override
    public void reSetView() {
        playerView.reDraw();
        secondPlayerView.reDraw();
        mazeView.reDraw();
    }

    @Override
    public void adjustLayout() {
        double cellWidth = getWidth() / gameController.getGameService().getMazeService().getMaze().getCols();
        double cellHeight = (getHeight() - getTop().getLayoutBounds().getHeight() - getBottom().getLayoutBounds().getHeight()) /
                gameController.getGameService().getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellWidth, cellHeight);
        playerView.setCellSize(cellSize);
        secondPlayerView.setCellSize(cellSize);
        mazeView.setCellSize(cellSize);
        reSetView();

        // Centering the maze within the game pane
        double mazeWidth = cellSize * gameController.getGameService().getMazeService().getMaze().getCols();
        double mazeHeight = cellSize * gameController.getGameService().getMazeService().getMaze().getRows();
        double offsetX = (getWidth() - mazeWidth) / 2;
        double offsetY = (getHeight() - ((HBox) getTop()).getHeight() - ((HBox) getBottom()).getHeight() - mazeHeight) / 2;

        mazeView.getNode().setTranslateX(offsetX);
        mazeView.getNode().setTranslateY(offsetY);
        playerView.getNode().setTranslateX(offsetX);
        playerView.getNode().setTranslateY(offsetY);
        secondPlayerView.getNode().setTranslateX(offsetX);
        secondPlayerView.getNode().setTranslateY(offsetY);
    }

    /**
     * Displays a hint path by dynamically highlighting the path on the maze.
     *
     * @param path The path to be highlighted.
     */
    @Override
    public void showHint(List<int[]> path) {
        int cellSize = mazeView.getCellSize();
        // Clear the previous hint
        mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));
        Timeline timeline = new Timeline();
        List<Rectangle> currentRects = new ArrayList<>();

        for (int i = 0; i < path.size(); i++) {
            int[] point = path.get(i);
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setUserData("highlight");

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.5), event -> {
                if (!currentRects.isEmpty()) {
                    mazeView.getNode().getChildren().remove(currentRects.remove(0));
                }
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }
}
