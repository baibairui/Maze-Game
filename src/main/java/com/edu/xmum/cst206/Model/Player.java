package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Drawable;
import com.edu.xmum.cst206.Interferce.Moveable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

public class Player extends GameObject implements Moveable, Drawable {
    private double radius;

    public Player(double x, double y, double radius, Color color) {
        super(x, y, radius * 2, radius * 2, color); // 宽度和高度为直径
        this.radius = radius;
        this.node = draw();
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    // 绘制玩家的方法
    @Override
    public Node draw() {
        Circle circle = new Circle(x, y, radius, color);
        return circle;
    }

    // 玩家类的移动方法
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        updateNodePosition();
    }

    @Override
    public void updateNodePosition() {
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
}

