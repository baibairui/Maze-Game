package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SecondPlayerViewV3 extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    private Direction direction;

    public SecondPlayerViewV3(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN;//Default down
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
            default -> playerDir = "Down"; // Default down
        }

        ImageView playerView = new ImageView();
        PlayerViewStyler.playerViewStyle(Skin.Vs,playerView,cellSize,player,playerDir);
        getChildren().clear();
        getChildren().add(playerView);
        System.out.println("x: "+player.getX()+"Y: "+player.getY());
        System.out.println("second Done");
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
