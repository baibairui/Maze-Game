package com.edu.xmum.cst206.Model;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EmpTank extends TankObject{


    public EmpTank(double x, double y, double width, double height, Color color, Node node, double speed) {
        super(x, y, width, height, color, node, speed);
    }

    @Override
    public void move(double x, double y) {

    }

    @Override
    public void update() {

    }

    @Override
    protected Node createNode() {
        return null;
    }
}
