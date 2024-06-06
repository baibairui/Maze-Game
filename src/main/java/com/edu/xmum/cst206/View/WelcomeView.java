package com.edu.xmum.cst206.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/*
游戏的进入页面
 */
public class WelcomeView extends VBox {
    private final Button startButton=new Button("开始游戏");

    public WelcomeView() {
        setAlignment(Pos.CENTER);//居中显示
        setSpacing(20);

        Label titleLabel = new Label("欢迎来到迷宫游戏");
        titleLabel.setFont(new Font(24));
        getChildren().addAll(titleLabel, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }
}
