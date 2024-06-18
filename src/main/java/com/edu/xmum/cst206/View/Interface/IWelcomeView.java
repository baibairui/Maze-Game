package com.edu.xmum.cst206.View.Interface;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Interface for WelcomeView.
 * Specifies the methods that the WelcomeView should implement.
 */
public interface IWelcomeView {

    /**
     * Gets the start button in the WelcomeView.
     *
     * @return The start button.
     */
    Button getStartButton();

    /**
     * Gets the root node of the WelcomeView.
     *
     * @return The root node.
     */
    Node getNode();
}
