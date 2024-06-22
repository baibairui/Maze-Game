package com.edu.xmum.CST210.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IWelcomeView;
import com.edu.xmum.CST210.View.Styler.WelcomeViewStyler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the welcome view for version 1.
 * This class is responsible for displaying the welcome screen.
 */
public class WelComeViewV1 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("Start game");
    private final Label titleLabel = new Label("Welcome to Maze Games");

    /**
     * Constructor to initialize the WelComeViewV1 components.
     */
    public WelComeViewV1() {
        // Beautification Containers
        WelcomeViewStyler.styleVbox(Skin.V1, this);
        // Beautification Components
        WelcomeViewStyler.styleTitleLabel(Skin.V1, titleLabel);
        WelcomeViewStyler.styleStartButton(Skin.V1, startButton);

        // Adding Components
        getChildren().addAll(titleLabel, startButton);
    }

    /**
     * Gets the start button in the WelcomeView.
     *
     * @return The start button.
     */
    @Override
    public Button getStartButton() {
        return startButton;
    }

    /**
     * Gets the root node of the WelcomeView.
     *
     * @return The VBox root node.
     */
    @Override
    public Node getNode() {
        return this;
    }
}
