package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WelcomeViewV3 extends VBox implements IWelcomeView {
    @FXML
    private Button startButton;

    public WelcomeViewV3() {
        super();
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
