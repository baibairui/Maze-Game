package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class RunViewV1 extends BorderPane implements IRunView {
    private IPlayerView playerView;
    private IPlayerView aiView;
    private IMazeView mazeView;
    private Label currentDifficulty;
    private Button resetButton;
    private Button hintButton;
    private IGameController gameController;

    public RunViewV1(IGameController gameController) {
        // 初始化组件
        this.gameController = gameController;
        currentDifficulty = new Label("难度:" + gameController.getDiffculty());
        mazeView = FactoryProducer.getFactory("Maze").getMazeView(Skin.V1, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("Player").getPlayerView(Skin.V1, gameController.getGameService().getPlayerService().getPlayer());
        aiView = new AiView(gameController.getGameService().getAiService().getAiModel());
        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        // 设置按钮样式
        setButtonStyle(resetButton, "#FF6347");
        setButtonStyle(hintButton, "#4682B4");

        // 设置字体和颜色
        currentDifficulty.setFont(new Font("Arial", 16));
        currentDifficulty.setStyle("-fx-text-fill: white;");

        // 设置提示信息样式
        HBox infoBox = new HBox(20, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPadding(new Insets(10, 10, 10, 10));
        infoBox.setBackground(new Background(new BackgroundFill(Color.web("#ffa347"), CornerRadii.EMPTY, Insets.EMPTY)));

        // 设置控制面板样式
        HBox controlBox = new HBox(20, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setPadding(new Insets(10, 10, 10, 10));
        controlBox.setBackground(new Background(new BackgroundFill(Color.web("#ffa947"), CornerRadii.EMPTY, Insets.EMPTY)));

        // 设置游戏面板样式
        StackPane gamePane = new StackPane();
        gamePane.setAlignment(Pos.CENTER);
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode(), aiView.getNode()); // 添加AI视图
        gamePane.setStyle("-fx-background-color: white; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");

        // 控制排版
        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);

        // 确保游戏面板可以获得焦点
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());

        // 添加监听器调整组件大小
        gamePane.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout());
        gamePane.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout());

        // 设置主边框
        setStyle("-fx-background-color: #F5F5F5;");
    }

    private void setButtonStyle(Button button, String backgroundColor) {
        button.setStyle(
                "-fx-background-color: " + backgroundColor + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(event -> button.setStyle(
                "-fx-background-color: #005bb5; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(event -> button.setStyle(
                "-fx-background-color: " + backgroundColor + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMousePressed(event -> button.setStyle(
                "-fx-background-color: #003d80; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseReleased(event -> button.setStyle(
                "-fx-background-color: #005bb5; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));
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
    public void reSetView() {
        playerView.reDraw();
        mazeView.reDraw();
        aiView.reDraw(); // 重绘AI视图
    }

    @Override
    public void adjustLayout() {
        double cellWidth = getWidth() / gameController.getGameService().getMazeService().getMaze().getCols();
        double cellHeight = (getHeight() - getTop().getLayoutBounds().getHeight() - getBottom().getLayoutBounds().getHeight()) /
                gameController.getGameService().getMazeService().getMaze().getRows();
        int cellSize = (int) Math.min(cellWidth, cellHeight);
        playerView.setCellSize(cellSize);
        mazeView.setCellSize(cellSize);
        aiView.setCellSize(cellSize);
        reSetView();
        // 居中调整
        double mazeWidth = cellSize * gameController.getGameService().getMazeService().getMaze().getCols();
        double mazeHeight = cellSize * gameController.getGameService().getMazeService().getMaze().getRows();
        double offsetX = (getWidth() - mazeWidth) / 2;
        double offsetY = (getHeight() - ((HBox) getTop()).getHeight() - ((HBox) getBottom()).getHeight() - mazeHeight) / 2;

        mazeView.getNode().setTranslateX(offsetX);
        mazeView.getNode().setTranslateY(offsetY);
        playerView.getNode().setTranslateX(offsetX);
        playerView.getNode().setTranslateY(offsetY);
        aiView.getNode().setTranslateX(offsetX);
        aiView.getNode().setTranslateY(offsetY);
    }

    @Override
    public void showHint(List<int[]> path) {
        int cellSize = mazeView.getCellSize();
        // 清除之前的提示
        mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));

        // 动态显示提示路径
        Timeline timeline = new Timeline();
        // 用于存储当前显示的矩形，以便逐步删除
        List<Rectangle> currentRects = new ArrayList<>();

        // 显示正确路径
        for (int i = 0; i < path.size(); i++) {
            int[] point = path.get(i);

            // 创建一个新的矩形，用于高亮当前路径点
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.BLUE);
            rect.setUserData("highlight");

            // 设置透明度动画，实现拖尾效果
            KeyFrame addRect = new KeyFrame(Duration.seconds(i * 0.3), event -> {
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);
            });

            KeyFrame fadeOut = new KeyFrame(Duration.seconds( (i + 1) * 0.3), new KeyValue(rect.opacityProperty(), 0.3)); // 使路径更清晰

            timeline.getKeyFrames().addAll(addRect, fadeOut);
        }

        // 添加一个最终的关键帧来移除所有高亮的矩形
        KeyFrame finalKeyFrame = new KeyFrame(Duration.seconds((path.size()) * 0.3 + 0.2), event -> {
            mazeView.getNode().getChildren().removeIf(node -> node.getUserData() != null && node.getUserData().equals("highlight"));
        });

        timeline.getKeyFrames().add(finalKeyFrame);
        timeline.play();
    }

    @Override
    public IPlayerView getAiView() {
        return aiView;
    }

    //V1不需要
    @Override
    public IPlayerView getSecondPlayerView() {
        return null;
    }
}
