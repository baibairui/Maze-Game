package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IVictoryView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoryViewV1 extends VBox implements IVictoryView {
    public VictoryViewV1() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label victoryLabel = new Label("恭喜通关!");
        victoryLabel.setFont(new Font(24));
        getChildren().add(victoryLabel);
    }

    @Override
    public Button getBackButton() {
        return null;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
