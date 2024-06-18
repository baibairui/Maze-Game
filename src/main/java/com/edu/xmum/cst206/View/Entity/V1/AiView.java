package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AiView extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    private Direction direction;

    public AiView(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN;//Default down
    }

    @Override
    public void draw() {
        Image playImg = new Image("com/edu/xmum/cst206/player/僵尸4.gif");
        ImageView playerView = new ImageView(playImg);
        playerView.setFitHeight(cellSize);
        playerView.setFitWidth(cellSize); // Fixed here, should have set the width instead of setting the height again
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
        this.cellSize = cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
