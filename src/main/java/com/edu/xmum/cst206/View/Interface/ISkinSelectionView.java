package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Interface for SkinSelectionView.
 * Specifies the methods that the SkinSelectionView should implement.
 */
public interface ISkinSelectionView {

    /**
     * Gets the list of buttons in the SkinSelectionView.
     *
     * @return An ArrayList of buttons.
     */
    ArrayList<Button> getButtons();

    /**
     * Gets the root node of the SkinSelectionView.
     *
     * @return The VBox root node.
     */
    VBox getNode();
}
