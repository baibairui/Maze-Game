package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import com.edu.xmum.cst206.Service.MazeService;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
游戏进行的主要页面
页面中要包含：
1.玩家视图
2.迷宫视图
3.计时器
4.重置按钮
5.难度显示
 */
public class RunView extends VBox {
    //玩家和迷宫视图
    private PlayerView playerView;
    private MazeView mazeView;
    //难度显示和计时器
    private Label currentDifficulty;
    private Label currentTime;
    //重置游戏和提示按钮
    private Button resetButton;
    private Button hintButton;
    public RunView(GameController gameController) {
        setSpacing(20);
        setAlignment(Pos.CENTER);

        currentDifficulty = new Label("当前难度:");
        currentTime = new Label("当前用时:");

        mazeView = new MazeView(gameController.getGameService().mazeService.getMaze());
        playerView = new PlayerView(gameController.getGameService().playerService.getPlayer());

        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        HBox infoBox = new HBox(20, currentTime, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER);

        HBox controlBox = new HBox(20, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);

        getChildren().addAll(infoBox, mazeView, playerView.getNode(), controlBox);
    }

    //相关的get和set方法
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
}
