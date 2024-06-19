package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.View.Interface.ISkinSelectionView;
import com.edu.xmum.cst206.View.Styler.SkinSelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

/**
 * Implementation of the skin selection view.
 * This class is responsible for displaying the skin selection interface to the user.
 */
public class SkinSelectionView extends VBox implements ISkinSelectionView {
    private final ArrayList<Button> buttons = new ArrayList<>();
    private final Label label = new Label("Choose your Game Mode!");


    /**
     * Constructor to initialize the SkinSelectionView components.
     */
    public SkinSelectionView() {
        super();
        // Apply styles to the VBox and Label
        SkinSelectionViewStyler.VBoxStyle(this);
        SkinSelectionViewStyler.LabelStyle(label);


        // Add buttons for each available skin
        Button button = new Button("Single player Mode");
        SkinSelectionViewStyler.ButtonStyle(button);
        buttons.add(button);

        Button button1 = new Button("Chase mode");
        SkinSelectionViewStyler.ButtonStyle(button1);
        buttons.add(button1);

        Button button2 = new Button("Two-player mode");
        SkinSelectionViewStyler.ButtonStyle(button2);
        buttons.add(button2);


        // Add components to the VBox
        getChildren().add(label);
        getChildren().addAll(buttons);

    }

    public static void LabelStyle(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setTextFill(Color.DARKBLUE);
        label.setStyle("-fx-padding: 10px;");
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
