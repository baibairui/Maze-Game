package com.edu.xmum.cst206.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.nio.Buffer;

public class SelectionView extends VBox {
    private  Button easyButton=new Button("Easy");
    private  Button mediumButton=new Button("Medium");
    private  Button hardButton=new Button("Hard");
    public SelectionView(){
        setAlignment(Pos.CENTER);
        setSpacing(15);

        Label difficultyLabel = new Label("选择难度");
        difficultyLabel.setFont(new Font(18));

        getChildren().addAll(difficultyLabel,easyButton,mediumButton,hardButton);

    }
    //相关的get和set

    public Button getEasyButton() {
        return easyButton;
    }

    public Button getMediumButton() {
        return mediumButton;
    }

    public Button getHardButton() {
        return hardButton;
    }
}
