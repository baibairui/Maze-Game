package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import com.edu.xmum.cst206.View.Styler.WelcomeViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class WelcomeViewV2 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("Start game");
    private final Label titleLabel = new Label("Welcome to Labyrinth Games");

    public WelcomeViewV2() {
        WelcomeViewStyler.styleVbox(Skin.V2, this);
        //Beautification Components
        WelcomeViewStyler.styleStartButton(Skin.V2, startButton);
        WelcomeViewStyler.styleTitleLabel(Skin.V2, titleLabel);

        // Adding components to VBox
        getChildren().addAll(titleLabel, startButton);
    }

    @Override
    public Button getStartButton() {
        return startButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
