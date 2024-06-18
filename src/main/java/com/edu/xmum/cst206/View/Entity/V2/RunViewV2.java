package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Styler.RunViewStyler;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class RunViewV2 extends BorderPane implements IRunView {
    private final IPlayerView playerView;
    private final IMazeView mazeView;
    private final Label currentDifficulty;
    private final Button resetButton;
    private final Button hintButton;
    private final IGameController gameController;

    public RunViewV2(IGameController gameController) {
        // Initialising components
        this.gameController = gameController;
        currentDifficulty = new Label("Difficulty:" + gameController.getDifficulty());
        mazeView = FactoryProducer.getFactory("GameView").getMazeView(Skin.V2, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.V2, gameController.getGameService().getPlayerService().getPlayer());
        resetButton = new Button("Restart");
        hintButton = new Button("Tips");

        // Setting the button style
        RunViewStyler.resetButtonStyle(Skin.V2, resetButton);
        RunViewStyler.hintButtonStyle(Skin.V2, hintButton);
        // Setting fonts and colours
        RunViewStyler.diffcultyTitleStyle(Skin.V2, currentDifficulty);

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

        //Adjustments to the overall page
        // Controlling typography
        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);
        RunViewStyler.BoxStyle(Skin.V2, this);

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

    //V2不需要
    @Override
    public IPlayerView getSecondPlayerView() {
        return null;
    }

    @Override
    public void reSetView() {
        playerView.reDraw();
        mazeView.reDraw();
    }

    @Override
    public void adjustLayout() {
        double cellWidth = getWidth() / gameController.getGameService().getMazeService().getMaze().getCols();
        double cellHeight = (getHeight() - getTop().getLayoutBounds().getHeight() - getBottom().getLayoutBounds().getHeight()) /
                gameController.getGameService().getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellWidth, cellHeight);
        playerView.setCellSize(cellSize);
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
    }

    /*
    Plotting the path searched by DFS
     */
    @Override
    public void showHint(List<int[]> path) {
        int cellSize = mazeView.getCellSize();
        // 清除之前的提示
        mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));
        // 动态显示提示路径
        Timeline timeline = new Timeline();
        // 用于存储当前显示的矩形，以便逐步删除
        List<Rectangle> currentRects = new ArrayList<>();

        for (int i = 0; i < path.size(); i++) {
            int[] point = path.get(i);

            // 创建用于高亮当前路径点的新矩形
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setUserData("highlight");

            // 封装绘制和删除操作在KeyFrame中
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.2), event -> {
                // 将当前高亮矩形添加到画布上
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);

                // 为每个矩形创建一个新的Timeline，用于逐渐淡出颜色
                Timeline fadeTimeline = new Timeline();
                KeyFrame fadeKeyFrame = new KeyFrame(Duration.seconds(2), new KeyValue(rect.fillProperty(), Color.TRANSPARENT));
                fadeTimeline.getKeyFrames().add(fadeKeyFrame);
                fadeTimeline.setOnFinished(e -> mazeView.getNode().getChildren().remove(rect));
                fadeTimeline.play();
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();

    }

}

