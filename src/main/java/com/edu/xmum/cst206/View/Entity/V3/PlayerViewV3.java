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
        /*Circle circle=new Circle(cellSize/2,Color.GRAY);
        circle.setCenterX(player.getX() * cellSize + cellSize / 2);
        circle.setCenterY(player.getY() * cellSize + cellSize / 2);
        getChildren().clear();
        getChildren().add(circle);*/

        StringBuilder playerDir=new StringBuilder();
        switch (direction){
            case UP -> playerDir.append("Up");
            case DOWN -> playerDir.append("Down");
            case LEFT -> playerDir.append("Left");
            case RIGHT -> playerDir.append("Right");
            default -> playerDir.append("Down");//默认向下
        }
        Image playImg=new Image("com/edu/xmum/cst206/player/player"+playerDir.toString()+".png");
        playerDir.delete(0,playerDir.length());
        ImageView playerView=new ImageView(playImg);
        playerView.setFitHeight(cellSize);
        playerView.setFitHeight(cellSize);
        playerView.setX(player.getX()*cellSize);
        playerView.setY(player.getY()*cellSize);
        getChildren().clear();
        getChildren().addAll(playerView);
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
