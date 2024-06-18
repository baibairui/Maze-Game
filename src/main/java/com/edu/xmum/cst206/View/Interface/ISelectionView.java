package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for SelectionView.
 * Specifies the methods that the SelectionView should implement.
 */
public interface ISelectionView {

    /**
     * Gets the easy button in the SelectionView.
     *
     * @return The easy button.
     */
    Button getEasyButton();

    /**
     * Gets the medium button in the SelectionView.
     *
     * @return The medium button.
     */
    Button getMediumButton();

    /**
     * Gets the hard button in the SelectionView.
     *
     * @return The hard button.
     */
    Button getHardButton();

    /**
     * Gets the root node of the SelectionView.
     *
     * @return The VBox root node.
     */
    VBox getNode();
}
