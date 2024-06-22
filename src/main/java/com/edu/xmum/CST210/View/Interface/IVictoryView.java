package com.edu.xmum.CST210.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for VictoryView.
 * Specifies the methods that the VictoryView should implement.
 */
public interface IVictoryView {

    /**
     * Gets the back button in the VictoryView.
     *
     * @return The back button.
     */
    Button getBackButton();

    /**
     * Gets the root node of the VictoryView.
     *
     * @return The VBox root node.
     */
    VBox getNode();

    /**
     * Sets the winner's name to be displayed in the VictoryView.
     *
     * @param winner The name of the winner.
     */
    void setWinner(String winner);
}
