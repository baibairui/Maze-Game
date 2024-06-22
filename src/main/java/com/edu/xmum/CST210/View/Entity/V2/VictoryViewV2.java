package com.edu.xmum.CST210.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IVictoryView;
import com.edu.xmum.CST210.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the victory view for version 2.
 * This class is responsible for displaying the victory screen after the game is won.
 */
public class VictoryViewV2 extends VBox implements IVictoryView {
    private final Label victoryLabel = new Label("Congrats on the clearance!");
    private final Button backButton = new Button("Back to Main Menu");

    /**
     * Constructor to initialize the VictoryViewV2 components.
     */
    public VictoryViewV2() {
        // Beautify components
        VictoryViewStyler.VboxStyle(Skin.V2, this);
        VictoryViewStyler.ButtonStyle(Skin.V2, backButton);
        VictoryViewStyler.LabelStyle(Skin.V2, victoryLabel);
        getChildren().addAll(victoryLabel, backButton);
    }

    /**
     * Gets the root node of the VictoryView.
     *
     * @return The VBox root node.
     */
    @Override
    public VBox getNode() {
        return this;
    }

    /**
     * Sets the winner's name.
     * This method is currently not implemented for V2.
     *
     * @param winner The winner's name.
     */
    @Override
    public void setWinner(String winner) {
        // Not implemented for V2
    }

    /**
     * Gets the back button in the VictoryView.
     *
     * @return The back button.
     */
    @Override
    public Button getBackButton() {
        return backButton;
    }
}
