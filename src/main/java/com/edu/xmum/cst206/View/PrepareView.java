package com.edu.xmum.cst206.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/*
游戏的准备进入页面
 */
public class PrepareView extends VBox{
    private final Button startGameButton = new Button("开始游戏");

    public PrepareView() {
        setAlignment(Pos.CENTER);
        setSpacing(15);

        Label prepareLabel = new Label("准备好开始游戏!");
        prepareLabel.setFont(new Font(18));


        getChildren().addAll(prepareLabel, startGameButton);
    }

    public Button getStartGameButton() {
        return startGameButton;
    }
}
