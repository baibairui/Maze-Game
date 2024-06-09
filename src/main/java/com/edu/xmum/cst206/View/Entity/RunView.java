package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RunView extends BorderPane implements IRunView {
    private IPlayerView playerView;
    private IMazeView mazeView;
    private Label currentDifficulty;
    private Label currentTime;
    private Button resetButton;
    private Button hintButton;
    private IGameController gameController;

    public RunView(IGameController gameController) {
        //初始化组件
        this.gameController = gameController;
        currentDifficulty = new Label("当前难度: EASY");
        currentTime = new Label("当前用时: 00:00");
        mazeView = new MazeView(gameController.getGameService().getMazeService().getMaze());
        playerView = new PlayerView(gameController.getGameService().getPlayerService().getPlayer());
        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        // 设置按钮样式
        resetButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 14px;");
        hintButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px;");
        // 设置字体和颜色
        currentDifficulty.setFont(new Font("Arial", 16));
        currentDifficulty.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 14px;");
        currentTime.setFont(new Font("Arial", 16));
        currentTime.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 14px;");

        //设置提示信息样式
        HBox infoBox = new HBox(20, currentTime, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        infoBox.setPadding(new Insets(10, 10, 10, 10));
        infoBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        infoBox.setStyle("-fx-background-color: #ffa347; -fx-text-fill: white; -fx-font-size: 14px;");
        //设置控制面板样式
        HBox controlBox = new HBox(20, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setPadding(new Insets(10, 10, 10, 10));
        controlBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        controlBox.setStyle("-fx-background-color: #ffa947; -fx-text-fill: white; -fx-font-size: 14px;");
        //设置游戏面板样式
        StackPane gamePane = new StackPane();
        gamePane.setAlignment(Pos.CENTER);
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode());
        gamePane.setStyle("-fx-background-color: white; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");
        //控制排版
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
        // 居中调整
        double mazeWidth = cellSize * gameController.getGameService().getMazeService().getMaze().getCols();
        double mazeHeight = cellSize * gameController.getGameService().getMazeService().getMaze().getRows();
        double offsetX = (getWidth() - mazeWidth) / 2;
        double offsetY = (getHeight() - ((HBox)getTop()).getHeight() - ((HBox)getBottom()).getHeight() - mazeHeight) / 2;

        mazeView.getNode().setTranslateX(offsetX);
        mazeView.getNode().setTranslateY(offsetY);
        playerView.getNode().setTranslateX(offsetX);
        playerView.getNode().setTranslateY(offsetY);
    }
}
