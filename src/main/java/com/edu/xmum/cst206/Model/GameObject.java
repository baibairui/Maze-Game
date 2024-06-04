package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Drawable;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public abstract class GameObject {
    protected double x;//横坐标
    protected double y;//纵坐标
    protected double width;//宽
    protected double height;//高
    protected Color color;//颜色
    protected Node node;//绑定的节点

    public GameObject(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.node = null;//具体如何绘制由相应的子类对象决定
    }
    //每个游戏对象的绘制方法各自决定
    //每个游戏对象都应该实现对应的get和set方法，以便于其他层模块进行处理

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
