package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import com.edu.xmum.cst206.View.Styler.WelcomeViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class WelcomeViewV3 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("Start game");
    private final Label titleLabel = new Label("Welcome to Labyrinth Games");

    public WelcomeViewV3() {
        //Beautification Containers
        WelcomeViewStyler.styleVbox(Skin.V3, this);
        // Beautification Components
        WelcomeViewStyler.styleTitleLabel(Skin.V3, titleLabel);
        WelcomeViewStyler.styleStartButton(Skin.V3, startButton);
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
