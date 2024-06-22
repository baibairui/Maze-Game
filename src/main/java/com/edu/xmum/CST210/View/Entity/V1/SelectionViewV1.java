package com.edu.xmum.CST210.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.CST210.View.Interface.ISelectionView;
import com.edu.xmum.CST210.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * Implementation of the selection view for version 1.
 * This class is responsible for displaying the difficulty selection interface.
 */
public class SelectionViewV1 extends VBox implements ISelectionView {
    private final Button easyButton = new Button("Easy");
    private final Button mediumButton = new Button("Medium");
    private final Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("Choose difficulty");

    /**
     * Constructor to initialize the SelectionViewV1 components.
     */
    public SelectionViewV1() {
        // Background beautification
        super();
        SelectionViewStyler.styleVBox(Skin.V1, this);
        // Setting the button style
        SelectionViewStyler.styleTitleLabel(Skin.V1, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V1, easyButton);
        SelectionViewStyler.styleButton(Skin.V1, mediumButton);
        SelectionViewStyler.styleButton(Skin.V1, hardButton);

        // Adding components
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
