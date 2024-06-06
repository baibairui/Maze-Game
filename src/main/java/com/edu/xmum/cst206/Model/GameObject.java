package com.edu.xmum.cst206.Model;


public abstract class GameObject {
    protected int x;//横坐标
    protected int y;//纵坐标
    protected double width;//宽
    protected double height;//高

    public GameObject(int x, int y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    //每个游戏对象的绘制方法各自决定
    //每个游戏对象都应该实现对应的get和set方法，以便于其他层模块进行处理

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
}
