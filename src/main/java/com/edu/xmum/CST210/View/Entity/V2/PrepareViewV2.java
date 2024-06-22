package com.edu.xmum.CST210.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IPrepareView;
import com.edu.xmum.CST210.View.Styler.PrepareViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the prepare view for version 2.
 * This class is responsible for displaying the prepare screen before the game starts.
 */
public class PrepareViewV2 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("Start game");
    private final Label prepareLabel = new Label("Get ready to start playing!");

    /**
     * Constructor to initialize the PrepareViewV2 components.
     */
    public PrepareViewV2() {
        super();
        // Setting the style
        PrepareViewStyler.VboxStyle(Skin.V2, this);
        PrepareViewStyler.LabelStyle(Skin.V2, prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V2, startGameButton);
        // Adding components to VBox
        getChildren().addAll(prepareLabel, startGameButton);
    }

    /**
     * Gets the start game button in the PrepareView.
     *
     * @return The start game button.
     */
    @Override
    public Button getStartGameButton() {
        return startGameButton;
    }

    /**
     * Gets the root node of the PrepareView.
     *
     * @return The VBox root node.
     */
    @Override
    public VBox getNode() {
        return this;
    }
}
