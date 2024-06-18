package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IPrepareView;
import com.edu.xmum.cst206.View.Styler.PrepareViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class PrepareViewV1 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("Start game");
    private final Label prepareLabel = new Label("Get ready to start playing!");

    public PrepareViewV1() {
        super();
        //Binding Style
        PrepareViewStyler.VboxStyle(Skin.V1, this);
        PrepareViewStyler.LabelStyle(Skin.V1, prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V1, startGameButton);
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
