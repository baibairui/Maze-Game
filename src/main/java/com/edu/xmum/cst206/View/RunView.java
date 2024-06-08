package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/*
游戏进行的主要页面
页面中要包含：
1.玩家视图
2.迷宫视图
3.计时器
4.重置按钮
5.难度显示
 */
public class RunView extends BorderPane {
    private PlayerView playerView;
    private MazeView mazeView;
    private Label currentDifficulty;
    private Label currentTime;
    private Button resetButton;
    private Button hintButton;

    public RunView(GameController gameController) {
        currentDifficulty = new Label("当前难度:");
        currentTime = new Label("当前用时:");

        mazeView = new MazeView(gameController.getGameService().getGameModel().getMaze());
        playerView = new PlayerView(gameController.getGameService().getGameModel().getPlayer());

        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        HBox infoBox = new HBox(10, currentTime, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER_LEFT);

        HBox controlBox = new HBox(10, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);

        StackPane gamePane = new StackPane();
        gamePane.setAlignment(Pos.CENTER);
        gamePane.getChildren().addAll(mazeView, playerView);
        gamePane.setStyle("-fx-background-color: white;"); // 设置背景颜色

        setTop(infoBox);
        setCenter(gamePane);
        setBottom(controlBox);

        // 设置拉伸策略
        VBox.setVgrow(gamePane, Priority.ALWAYS);
        HBox.setHgrow(infoBox, Priority.ALWAYS);
        HBox.setHgrow(controlBox, Priority.ALWAYS);

        // 确保游戏面板可以获得焦点
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());
    }


    //重新开始游戏
    public void resetView() {
        // 重新设置迷宫和玩家视图
        mazeView.redraw();
        playerView.redraw();
    }
    // 相关的 get 和 set 方法
    public PlayerView getPlayerView() {
        return playerView;
    }

    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }

    public MazeView getMazeView() {
        return mazeView;
    }

    public void setMazeView(MazeView mazeView) {
        this.mazeView = mazeView;
    }

    public Label getCurrentDifficulty() {
        return currentDifficulty;
    }

    public void setCurrentDifficulty(Label currentDifficulty) {
        this.currentDifficulty = currentDifficulty;
    }

    public Label getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Label currentTime) {
        this.currentTime = currentTime;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public void setResetButton(Button resetButton) {
        this.resetButton = resetButton;
    }

    public Button getHintButton() {
        return hintButton;
    }

    public void setHintButton(Button hintButton) {
        this.hintButton = hintButton;
    }

    public void updatePlayer() {
        playerView.redraw();
    }
}