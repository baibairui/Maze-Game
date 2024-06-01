package com.edu.xmum.cst206.Model;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class Wall extends MapObject{
    public Wall(double x, double y, double width, double height, Color color, Node node) {
        super(x, y, width, height, color, node);
    }

    @Override
    public void update() {

    }

    @Override
    protected Node createNode() {
        return null;
    }
}
