package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Interferce.Drawable;
import com.edu.xmum.cst206.Model.Player;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
玩家视图类
用于负责玩家的显示和更新
 */
public class PlayerView implements Drawable {
    public Player player;
    public Node circle;
    public PlayerView(Player player) {
        this.player = player;
        this.circle = draw();
    }
    //返回节点
    public Node getNode(){
        return circle;
    }
    // 获取绘制的节点
    @Override
    public Node draw() {
        Circle circle = new Circle(player.getX(), player.getY(), player.getRadius(), Color.BLUE);
        return circle;
    }

    // 更新玩家在视图中的位置
    public void updatePlayerPosition() {
        circle.setTranslateX(player.getX());
        circle.setTranslateY(player.getY());
    }
}
