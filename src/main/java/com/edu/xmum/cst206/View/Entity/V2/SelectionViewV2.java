package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.ISelectionView;
import com.edu.xmum.cst206.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the selection view for version 2.
 * This class is responsible for displaying the difficulty selection interface.
 */
public class SelectionViewV2 extends VBox implements ISelectionView {
    private final Button easyButton = new Button("Easy");
    private final Button mediumButton = new Button("Medium");
    private final Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("Choose difficulty");

    /**
     * Constructor to initialize the SelectionViewV2 components.
     */
    public SelectionViewV2() {
        // Setting the background colour
        super();
        SelectionViewStyler.styleVBox(Skin.V2, this);
        // Beautify page
        SelectionViewStyler.styleTitleLabel(Skin.V2, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V2, easyButton);
        SelectionViewStyler.styleButton(Skin.V2, mediumButton);
        SelectionViewStyler.styleButton(Skin.V2, hardButton);

        // Adding components to VBox
        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }

    /**
     * Gets the easy button in the SelectionView.
     *
     * @return The easy button.
     */
    @Override
    public Button getEasyButton() {
        return easyButton;
    }

    /**
     * Gets the medium button in the SelectionView.
     *
     * @return The medium button.
     */
    @Override
    public Button getMediumButton() {
        return mediumButton;
    }

    /**
     * Gets the hard button in the SelectionView.
     *
     * @return The hard button.
     */
    @Override
    public Button getHardButton() {
        return hardButton;
    }

    /**
     * Gets the root node of the SelectionView.
     *
     * @return The VBox root node.
     */
    @Override
    public VBox getNode() {
        return this;
    }
}
