package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IPrepareView;
import com.edu.xmum.cst206.View.Styler.PrepareViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrepareViewV2 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("Start game");
    private final Label prepareLabel = new Label("Get ready to start playing!");

    public PrepareViewV2() {
        super();
        //Setting the style
        PrepareViewStyler.VboxStyle(Skin.V2, this);
        PrepareViewStyler.LabelStyle(Skin.V2, prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V2, startGameButton);
        // Adding components to VBox
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
