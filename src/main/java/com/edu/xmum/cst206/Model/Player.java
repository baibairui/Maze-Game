package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Moveable;

/*
玩家对象
由于设计了View层，因此对象类中不需要考虑绘制的方法
 */
public class Player extends GameObject implements Moveable{
    private double radius;

    public Player(int x, int y, double radius) {
        super(x, y, radius * 2, radius * 2); // 宽度和高度为直径
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    /*玩家类的移动方法
    模型层只需要专注模型类的属性
    更新视图的方法由View层负责
     */
    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

