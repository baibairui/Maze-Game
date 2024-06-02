package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Drawable;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public abstract class GameObject implements Drawable {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Color color;
    protected Node node;

    public GameObject(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.node = draw();
    }
    //绘制展示
    public abstract Node draw();

    public Node getNode() {
        return node;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    protected void updateNodePosition() {
        node.setTranslateX(x * width);
        node.setTranslateY(y * height);
    }
}
