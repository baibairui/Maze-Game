package com.edu.xmum.CST210.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.IVictoryView;
import com.edu.xmum.CST210.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the victory view for version 1.
 * This class is responsible for displaying the victory screen.
 */
public class VictoryViewV1 extends VBox implements IVictoryView {
    private final Button backButton = new Button("Back to main page");
    private String winner = "Player";
    private final Label victoryLabel = new Label(winner + " Win! ");

    /**
     * Constructor to initialize the VictoryViewV1 components.
     */
    public VictoryViewV1() {
        VictoryViewStyler.VboxStyle(Skin.V1, this);
        VictoryViewStyler.LabelStyle(Skin.V1, victoryLabel);
        VictoryViewStyler.ButtonStyle(Skin.V1, backButton);
        getChildren().addAll(victoryLabel, backButton);
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
     * Sets the winner's name to be displayed in the VictoryView.
     *
     * @param winner The name of the winner.
     */
    @Override
    public void setWinner(String winner) {
        this.winner = winner;
        victoryLabel.setText(winner + " Win! ");
    }
}
