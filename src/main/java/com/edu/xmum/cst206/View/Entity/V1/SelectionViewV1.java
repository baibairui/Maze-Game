package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.ISelectionView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SelectionViewV1 extends VBox implements ISelectionView {
    private Button easyButton = new Button("Easy");
    private Button mediumButton = new Button("Medium");
    private Button hardButton = new Button("Hard");

    public SelectionViewV1() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(15);
        Label difficultyLabel = new Label("选择难度");
        difficultyLabel.setFont(new Font(18));
        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }

    @Override
    public Button getEasyButton() {
        return easyButton;
    }

    @Override
    public Button getMediumButton() {
        return mediumButton;
    }

    @Override
    public Button getHardButton() {
        return hardButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}