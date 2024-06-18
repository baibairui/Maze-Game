package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Styler.RunViewStyler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class RunViewV3 extends BorderPane implements IRunView {
    private IPlayerView playerView;
    private IPlayerView secondPlayerView;
    private IMazeView mazeView;
    private Label currentDifficulty;
    private Button resetButton;
    private Button hintButton;
    private IGameController gameController;

    public RunViewV3(IGameController gameController) {
        // Initialising components
        this.gameController = gameController;
        currentDifficulty = new Label("Difficulty:" + gameController.getDiffculty());
        mazeView = FactoryProducer.getFactory("GameView").getMazeView(Skin.V3, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.V3, gameController.getGameService().getPlayerService().getPlayer());
        secondPlayerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.Vs, gameController.getGameService().getSecondPlayerService().getPlayer());
        resetButton = new Button("Restart");
        hintButton = new Button("Tips");

        /*
        Calling style to beautify a component
         */
        // Setting the button style
        RunViewStyler.resetButtonStyle(Skin.V3, resetButton);
        RunViewStyler.hintButtonStyle(Skin.V3, hintButton);

        // Setting fonts and colours
        RunViewStyler.diffcultyTitleStyle(Skin.V3, currentDifficulty);

        // Setting the prompt message style
        HBox infoBox = new HBox(20, currentDifficulty);
        RunViewStyler.infoBoxStyle(Skin.V3, infoBox);

        // Setting the control panel style
        HBox controlBox = new HBox(20, resetButton, hintButton);
        RunViewStyler.infoBoxStyle(Skin.V3, controlBox);

        // Setting the game panel style
        StackPane gamePane = new StackPane();
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode(), secondPlayerView.getNode()); // Adding a second player view
        RunViewStyler.gameBoxStyle(Skin.V3, gamePane);


        // Ensure that the game panel can gain focus
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());

        // Adding a listener to resize a component
        gamePane.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout());
        gamePane.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout());

        // Setting the main border
        // Controlling typography
        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);
        RunViewStyler.BoxStyle(Skin.V1, this);
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
        secondPlayerView.reDraw(); // Redrawing the second player view
        mazeView.reDraw();
    }

    @Override
    public void adjustLayout() {
        double cellWidth = getWidth() / gameController.getGameService().getMazeService().getMaze().getCols();
        double cellHeight = (getHeight() - getTop().getLayoutBounds().getHeight() - getBottom().getLayoutBounds().getHeight()) /
                gameController.getGameService().getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellWidth, cellHeight);
        playerView.setCellSize(cellSize);
        secondPlayerView.setCellSize(cellSize); // Setting the cell size for the second player
        mazeView.setCellSize(cellSize);
        reSetView();
        // centre
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

    /*
    Plotting the path searched by DFS
     */
    @Override
    public void showHint(List<int[]> path) {
        int cellSize = mazeView.getCellSize();
        // Clear the previous tip
        mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));
        // Dynamic display of cue paths
        Timeline timeline = new Timeline();
        // Used to store the currently displayed rectangle for progressive deletion
        List<Rectangle> currentRects = new ArrayList<>();

        for (int i = 0; i < path.size(); i++) {
            int[] point = path.get(i);

            // Creates a new rectangle for highlighting the current path point
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setUserData("highlight");

            // Encapsulate drawing and deletion operations in KeyFrame
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.5), event -> {
                // Remove the previous highlighted rectangle (if any)
                if (!currentRects.isEmpty()) {
                    mazeView.getNode().getChildren().remove(currentRects.remove(0));
                }
                // Add the currently highlighted rectangle
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }
}
