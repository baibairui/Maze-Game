package com.edu.xmum.CST210.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IVictoryView;
import com.edu.xmum.CST210.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the victory view for version 3.
 * This class is responsible for displaying the victory screen when a player wins the game.
 */
public class VictoryViewV3 extends VBox implements IVictoryView {
    private final Label victoryLabel = new Label();
    private final Button backButton = new Button("Back to Main Menu");
    private String winner;

    /**
     * Constructor to initialize the VictoryViewV3 components.
     */
    public VictoryViewV3() {
        // Apply styling to the VBox container
        VictoryViewStyler.VboxStyle(Skin.V3, this);
        // Apply styling to the components
        VictoryViewStyler.LabelStyle(Skin.V3, victoryLabel);
        VictoryViewStyler.ButtonStyle(Skin.V3, backButton);

        // Add components to the VBox
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
     * Sets the winner's name and updates the victory label text.
     *
     * @param winner The name of the winning player.
     */
    @Override
    public void setWinner(String winner) {
        this.winner = winner;
        victoryLabel.setText(winner + " Win!");
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
