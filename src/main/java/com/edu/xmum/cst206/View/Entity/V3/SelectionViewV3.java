package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.ISelectionView;
import com.edu.xmum.cst206.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SelectionViewV3 extends VBox implements ISelectionView {
    private Button easyButton = new Button("Easy");
    private Button mediumButton = new Button("Medium");
    private Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("Choose difficulty");

    public SelectionViewV3() {
        // Setting the background colour
        super();
        //Beautification Containers
        SelectionViewStyler.styleVBox(Skin.V3, this);
        // Beautification Components
        SelectionViewStyler.styleTitleLabel(Skin.V3, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V3, easyButton);
        SelectionViewStyler.styleButton(Skin.V3, mediumButton);
        SelectionViewStyler.styleButton(Skin.V3, hardButton);

        // Adding components to VBox
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
