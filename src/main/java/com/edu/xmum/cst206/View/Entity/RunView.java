package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import com.edu.xmum.cst206.View.Interface.IRunView;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class RunView extends BorderPane implements IRunView {
    private IPlayerView playerView;
    private IMazeView mazeView;
    private Label currentDifficulty;
    private Label currentTime;
    private Button resetButton;
    private Button hintButton;
    private IGameController gameController;

    public RunView(IGameController gameController) {
        this.gameController=gameController;
        currentDifficulty = new Label("当前难度:");
        currentTime = new Label("当前用时:");

        mazeView = new MazeView(gameController.getGameService().getMazeService().getMaze());
        playerView = new PlayerView(gameController.getGameService().getPlayerService().getPlayer());

        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        HBox infoBox = new HBox(10, currentTime, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER_LEFT);

        HBox controlBox = new HBox(10, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);

        StackPane gamePane = new StackPane();
        gamePane.setAlignment(Pos.CENTER);
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode());
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

    @Override
    public Button getResetButton() {
        return resetButton;
    }

    @Override
    public Button getHintButton() {
        return resetButton;
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
}
