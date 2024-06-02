package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Moveable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

public class Player extends GameObject implements Moveable {

    public Player(double x, double y, double radius, Color color) {
        super(x,y,radius,radius,color);
        this.node=draw();
        updatePosition();
    }
    @Override
    public Node draw() {
        Pane pane=new Pane();
        int cellSize=CELL_SIZE;
        Rectangle rect=new Rectangle(x,y,cellSize,cellSize);
        rect.setFill(Color.BLUE);
        pane.getChildren().addAll(rect);
        return pane;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        updateNodePosition();
    }
    private void updatePosition() {
        node.setTranslateX(x * 20);
        node.setTranslateY(y * 20);
    }

}
