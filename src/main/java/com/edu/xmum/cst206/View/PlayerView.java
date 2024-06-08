package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Model.Player;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

/*
玩家视图类
用于负责玩家的显示和更新
 */
public class PlayerView extends Pane {
    private Player player;
    private Circle circle;
    private double cellSize;

    public PlayerView(Player player) {
        this.player = player;
        this.cellSize = CELL_SIZE;
        circle = new Circle(player.getRadius(), Color.DARKGRAY);
        draw();
        getChildren().add(circle);
    }

    public void draw() {
        this.circle=new Circle(player.getRadius(),Color.DARKGRAY);
        circle.setCenterX(player.getX() * cellSize + cellSize / 2);
        circle.setCenterY(player.getY() * cellSize + cellSize / 2);
    }

    public Circle getCircle() {
        return circle;
    }

    public double getCellSize() {
        return cellSize;
    }

    public void setCellSize(double cellSize) {
        this.cellSize = cellSize;
        player.setRadius(cellSize / 2);
        draw();
    }
    public void redraw(){
        player.setX(0);
        player.setY(1);
        draw();
    }

}
