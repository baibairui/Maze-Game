package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IPrepareView;
import com.edu.xmum.cst206.View.Styler.PrepareViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the PrepareView for version 1.
 * Implements the IPrepareView interface.
 */
public class PrepareViewV1 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("Start game");
    private final Label prepareLabel = new Label("Get ready to start playing!");

    /**
     * Constructs the PrepareViewV1 and initializes the UI components.
     */
    public PrepareViewV1() {
        super();
        // Binding styles
        PrepareViewStyler.VboxStyle(Skin.V1, this);
        PrepareViewStyler.LabelStyle(Skin.V1, prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V1, startGameButton);
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
