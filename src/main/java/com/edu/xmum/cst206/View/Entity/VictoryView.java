package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.View.Interface.IVictoryView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoryView extends VBox implements IVictoryView {
    public VictoryView() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label victoryLabel = new Label("恭喜通关!");
        victoryLabel.setFont(new Font(24));
        getChildren().add(victoryLabel);
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
