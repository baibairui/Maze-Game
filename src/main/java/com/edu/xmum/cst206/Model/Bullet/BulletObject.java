package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Inteferce.Drawable;
import com.edu.xmum.cst206.Inteferce.Moveable;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class BulletObject extends GameObject {
    protected double speed;
    public BulletObject(double x, double y, double width, double height, Color color, Node node,double speed) {
        super(x, y, width, height, color, node);
        this.speed=speed;
    }
}
