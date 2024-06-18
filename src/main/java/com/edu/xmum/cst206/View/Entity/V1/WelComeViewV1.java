package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import com.edu.xmum.cst206.View.Styler.WelcomeViewStyler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class WelComeViewV1 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("Start game");
    private final Label titleLabel = new Label("Welcome to Labyrinth Games");

    public WelComeViewV1() {
        // Beautification Containers
        WelcomeViewStyler.styleVbox(Skin.V1, this);
        //Beautification Components
        WelcomeViewStyler.styleTitleLabel(Skin.V1, titleLabel);
        WelcomeViewStyler.styleStartButton(Skin.V1, startButton);

        //Adding Components
        getChildren().addAll(titleLabel, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }

    @Override
    public Node getNode() {
        return this;
    }
}