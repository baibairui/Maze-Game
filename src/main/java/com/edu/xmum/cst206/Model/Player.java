package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Drawable;
import com.edu.xmum.cst206.Interferce.Moveable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

/*
玩家对象
由于设计了View层，因此对象类中不需要考虑绘制的方法
 */
public class Player extends GameObject implements Moveable{
    private double radius;

    public Player(double x, double y, double radius) {
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
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
}

