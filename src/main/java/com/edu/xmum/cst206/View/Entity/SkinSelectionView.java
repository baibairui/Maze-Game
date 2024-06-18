package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.View.Interface.ISkinSelectionView;
import com.edu.xmum.cst206.View.Styler.SkinSelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Implementation of the skin selection view.
 * This class is responsible for displaying the skin selection interface to the user.
 */
public class SkinSelectionView extends VBox implements ISkinSelectionView {
    private final ArrayList<Button> buttons = new ArrayList<>();
    private final Label label = new Label("Choose your skin!");

    /**
     * Constructor to initialize the SkinSelectionView components.
     */
    public SkinSelectionView() {
        super();
        // Apply styles to the VBox and Label
        SkinSelectionViewStyler.VBoxStyle(this);
        SkinSelectionViewStyler.LabelStyle(label);


        // Add buttons for each available skin
        for (int i = 0; i < FactoryProducer.getSkinSize(); i++) {
            Button button = new Button("V" + (i + 1));
            SkinSelectionViewStyler.ButtonStyle(button);
            buttons.add(button);
        }

        // Add components to the VBox
        getChildren().add(label);
        getChildren().addAll(buttons);

    }

    /**
     * Gets the list of buttons for skin selection.
     *
     * @return The list of buttons.
     */
    @Override
    public ArrayList<Button> getButtons() {
        return buttons;
    }

    /**
     * Gets the root node of the SkinSelectionView.
     *
     * @return The VBox root node.
     */
    @Override
    public VBox getNode() {
        return this;
    }
}
