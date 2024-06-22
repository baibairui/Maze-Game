package com.edu.xmum.CST210.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for FailView.
 * Specifies the methods that the FailView should implement.
 */
public interface IFailView {

    /**
     * Gets the root node of the FailView.
     *
     * @return The VBox root node.
     */
    VBox getNode();

    /**
     * Gets the back button in the FailView.
     *
     * @return The back button.
     */
    Button getBackButton();
}
