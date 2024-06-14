package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayerViewV3 extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    private Direction direction;
    public PlayerViewV3(IPlayerModel playerModel){
        this.player=playerModel;
        this.direction=Direction.DOWN;//默认向下
    }

    @Override
    public void draw() {
    /*Circle circle = new Circle(cellSize / 2, Color.GRAY);
    circle.setCenterX(player.getX() * cellSize + cellSize / 2);
    circle.setCenterY(player.getY() * cellSize + cellSize / 2);
    getChildren().clear();
    getChildren().add(circle);*/

        String playerDir;
        switch (direction) {
            case UP -> playerDir = "Up";
            case DOWN -> playerDir = "Down";
            case LEFT -> playerDir = "Left";
            case RIGHT -> playerDir = "Right";
            default -> playerDir = "Down"; // 默认向下
        }

        Image playImg = new Image("com/edu/xmum/cst206/player/player" + playerDir + ".png");
        ImageView playerView = new ImageView(playImg);
        playerView.setFitHeight(cellSize);
        playerView.setFitWidth(cellSize); // 修正这里，应该设置宽度而不是再设置一次高度
        playerView.setX(player.getX() * cellSize);
        playerView.setY(player.getY() * cellSize);

        getChildren().clear();
        getChildren().add(playerView);
    }

    @Override
    public void reDraw() {
        draw();
    }

    @Override
    public void setCellSize(int cellSize) {
        this.cellSize=cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction=direction;
        draw();
    }
}
