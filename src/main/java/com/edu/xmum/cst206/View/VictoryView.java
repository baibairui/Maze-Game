package com.edu.xmum.cst206.View;

import com.almasb.fxgl.core.View;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoryView extends VBox {
    public VictoryView(){
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label victoryLabel = new Label("恭喜通关!");
        victoryLabel.setFont(new Font(24));

        getChildren().add(victoryLabel);
    }

}
