package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.ISelectionView;
import com.edu.xmum.cst206.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Implementation of the selection view for version 3.
 * This class is responsible for displaying the difficulty selection screen before the game starts.
 */
public class SelectionViewV3 extends VBox implements ISelectionView {
    private final Button easyButton = new Button("Easy");
    private final Button mediumButton = new Button("Medium");
    private final Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("Choose difficulty");

    /**
     * Constructor to initialize the SelectionViewV3 components.
     */
    public SelectionViewV3() {
        super();
        // Apply styling to the VBox container
        SelectionViewStyler.styleVBox(Skin.V3, this);
        // Apply styling to the components
        SelectionViewStyler.styleTitleLabel(Skin.V3, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V3, easyButton);
        SelectionViewStyler.styleButton(Skin.V3, mediumButton);
        SelectionViewStyler.styleButton(Skin.V3, hardButton);

        // Adding components to the VBox
        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }

    /**
     * Gets the easy difficulty button.
     *
     * @return The easy difficulty button.
     */
    @Override
    public Button getEasyButton() {
        return easyButton;
    }

    /**
     * Gets the medium difficulty button.
     *
     * @return The medium difficulty button.
     */
    @Override
    public Button getMediumButton() {
        return mediumButton;
    }

    /**
     * Gets the hard difficulty button.
     *
     * @return The hard difficulty button.
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
