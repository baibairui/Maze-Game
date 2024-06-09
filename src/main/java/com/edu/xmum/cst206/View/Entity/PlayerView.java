package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlayerView extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    public PlayerView(IPlayerModel playerModel){
        this.player=playerModel;
    }

    @Override
    public void draw() {
        Circle circle=new Circle(cellSize/2,Color.GRAY);
        circle.setCenterX(player.getX() * cellSize + cellSize / 2);
        circle.setCenterY(player.getY() * cellSize + cellSize / 2);
        getChildren().clear();
        getChildren().add(circle);
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
}
