package com.edu.xmum.CST210.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IWelcomeView;
import com.edu.xmum.CST210.View.Styler.WelcomeViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the welcome view for version 2.
 * This class is responsible for displaying the welcome screen before the game starts.
 */
public class WelcomeViewV2 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("Start game");
    private final Label titleLabel = new Label("Welcome to Maze Games");

    /**
     * Constructor to initialize the WelcomeViewV2 components.
     */
    public WelcomeViewV2() {
        // Apply styles to components
        WelcomeViewStyler.styleVbox(Skin.V2, this);
        WelcomeViewStyler.styleStartButton(Skin.V2, startButton);
        WelcomeViewStyler.styleTitleLabel(Skin.V2, titleLabel);

        // Adding components to VBox
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
    public VBox getNode() {
        return this;
    }
}
