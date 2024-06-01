package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Inteferce.Moveable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import static com.edu.xmum.cst206.Model.ConstantConfig.*;

public abstract class TankObject extends GameObject implements Moveable {
    protected double speed;
    public TankObject(double x, double y, double width, double height, Color color, Node node,double speed) {
        super(x, y, width, height, color, node);
        this.speed=speed;
    }

    @Override
    protected Node createNode() {
        //绘制坦克身体
        Rectangle body=new Rectangle(x,y,width,height);
        body.setFill(color);
        //绘制左履带
        Rectangle leftTyre = new Rectangle(TYRE_WIDTH, TYRE_LENGTH);
        leftTyre.setFill(Color.DARKGRAY);
        leftTyre.setTranslateX(-width / 2 - TYRE_WIDTH);
        leftTyre.setTranslateY(height / 2 - TYRE_LENGTH / 2);
        //绘制右履带
        Rectangle rightTyre = new Rectangle(TYRE_WIDTH, TYRE_LENGTH);
        rightTyre.setFill(Color.DARKGRAY);
        rightTyre.setTranslateX(width / 2);
        rightTyre.setTranslateY(height / 2 - TYRE_LENGTH / 2);

        //绘制炮筒
        Line barrel = new Line(0, -height / 2, 0, -height / 2 - BARREL_LENGTH);
        barrel.setStroke(Color.BLACK);
        barrel.setStrokeWidth(BARREL_WIDTH);
        barrel.setTranslateX(width / 2);
        barrel.setTranslateY(height / 2);

        //绘制塔台
        Circle fort = new Circle(width / 4);
        fort.setFill(color.darker());
        fort.setTranslateX(width / 2);
        fort.setTranslateY(height / 2);

        // 使用 Pane 来组合车体、履带、炮筒和塔台
        Pane tank = new Pane();
        tank.getChildren().addAll(leftTyre, rightTyre, body, fort, barrel);

        // 设置 Pane 的位置
        tank.setTranslateX(x);
        tank.setTranslateY(y);

        return tank;
    }
}
