package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Inteferce.Drawable;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class MapObject extends GameObject{

    public MapObject(double x, double y, double width, double height, Color color, Node node) {
        super(x, y, width, height, color, node);
    }
}
