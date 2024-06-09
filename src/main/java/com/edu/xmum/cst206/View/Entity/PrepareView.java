package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.View.Interface.IPrepareView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PrepareView extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("开始游戏");

    public PrepareView() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(15);
        Label prepareLabel = new Label("准备好开始游戏!");
        prepareLabel.setFont(new Font(18));
        getChildren().addAll(prepareLabel, startGameButton);
    }

    @Override
    public Button getStartGameButton() {
        return startGameButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}