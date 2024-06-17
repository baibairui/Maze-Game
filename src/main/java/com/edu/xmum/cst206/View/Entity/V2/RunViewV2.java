package com.edu.xmum.cst206.View.Entity.V2;

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

public class RunViewV2 extends BorderPane implements IRunView {
    private IPlayerView playerView;
    private IMazeView mazeView;
    private Label currentDifficulty;
    private Button resetButton;
    private Button hintButton;
    private IGameController gameController;

    public RunViewV2(IGameController gameController) {
        // 初始化组件
        this.gameController = gameController;
        currentDifficulty = new Label("难度:" + gameController.getDiffculty());
        mazeView = FactoryProducer.getFactory("GameView").getMazeView(Skin.V2, gameController.getGameService().getMazeService().getMaze());
        playerView = FactoryProducer.getFactory("GameView").getPlayerView(Skin.V2, gameController.getGameService().getPlayerService().getPlayer());
        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        // 设置按钮样式
        RunViewStyler.resetButtonStyle(Skin.V2, resetButton);
        RunViewStyler.hintButtonStyle(Skin.V2, hintButton);
        // 设置字体和颜色
        RunViewStyler.diffcultyTitleStyle(Skin.V2, currentDifficulty);

        // 设置提示信息样式
        HBox infoBox = new HBox(20, currentDifficulty);
        RunViewStyler.infoBoxStyle(Skin.V2, infoBox);

        // 设置控制面板样式
        HBox controlBox = new HBox(20, resetButton, hintButton);
        RunViewStyler.controlBoxStyle(Skin.V2, controlBox);

        // 设置游戏面板样式
        StackPane gamePane = new StackPane();
        gamePane.getChildren().addAll(mazeView.getNode(), playerView.getNode());
        RunViewStyler.gameBoxStyle(Skin.V2, gamePane);

        // 确保游戏面板可以获得焦点
        gamePane.setFocusTraversable(true);
        setOnMouseClicked(event -> requestFocus());

        // 添加监听器调整组件大小
        gamePane.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout());
        gamePane.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout());

        //调整整体页面
        // 控制排版
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
        // 居中调整
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
    绘制DFS搜索出来的路径
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

            // 创建一个新的矩形，用于高亮当前路径点
            Rectangle rect = new Rectangle(point[1] * cellSize, point[0] * cellSize, cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setUserData("highlight");

            // 将绘制和删除操作封装在 KeyFrame 中
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.5), event -> {
                // 移除前一个高亮的矩形（如果有）
                if (!currentRects.isEmpty()) {
                    mazeView.getNode().getChildren().remove(currentRects.remove(0));
                }
                // 添加当前高亮的矩形
                mazeView.getNode().getChildren().add(rect);
                currentRects.add(rect);
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }

}

