package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IFailView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * Represents the view displayed when the player fails the game.
 * Implements the IFailView interface.
 */
public class FailView implements IFailView {
    private VBox root;
    private Button backButton;

    /**
     * Constructs the FailView and initializes the UI components.
     */
    public FailView() {
        initialize();
    }

    /**
     * Initializes the FailView components and layout.
     */
    private void initialize() {
        root = new VBox(20);
        root.setAlignment(Pos.BOTTOM_CENTER);

        Image backgroundImage = new Image("/com/edu/xmum/cst206/background/zombie5.png");
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );
        root.setBackground(new Background(bgImage));

        backButton = new Button("Back to Main Menu");
        backButton.setFont(new Font("Arial", 24));
        backButton.setStyle(
                "-fx-background-color: #FF6347; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        );

        backButton.setOnMouseEntered(event -> backButton.setStyle(
                "-fx-background-color: #FF4500; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        backButton.setOnMouseExited(event -> backButton.setStyle(
                "-fx-background-color: #FF6347; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        root.getChildren().addAll(backButton);
    }

    /**
     * Gets the root node of the FailView.
     *
     * @return The VBox root node.
     */
    @Override
    public VBox getNode() {
        return root;
    }

    /**
     * Gets the back button in the FailView.
     *
     * @return The back button.
     */
    @Override
    public Button getBackButton() {
        return backButton;
    }
}



