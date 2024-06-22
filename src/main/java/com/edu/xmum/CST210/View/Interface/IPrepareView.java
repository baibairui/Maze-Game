package com.edu.xmum.CST210.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for PrepareView.
 * Specifies the methods that the PrepareView should implement.
 */
public interface IPrepareView {

    /**
     * Gets the start game button in the PrepareView.
     *
     * @return The start game button.
     */
    Button getStartGameButton();

    /**
     * Gets the root node of the PrepareView.
     *
     * @return The VBox root node.
     */
    VBox getNode();
}
