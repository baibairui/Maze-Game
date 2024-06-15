package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IFailView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FailView implements IFailView {
    private VBox root;
    private Button backButton;

    public FailView() {
        initialize();
    }

    private void initialize() {
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Label failLabel = new Label("Game Over!");
        failLabel.setFont(new Font("Arial", 24));
        failLabel.setStyle("-fx-text-fill: red;");

        backButton = new Button("Back to Main Menu");
        backButton.setFont(new Font("Arial", 16));
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

        root.getChildren().addAll(failLabel, backButton);
    }

    @Override
    public VBox getNode() {
        return root;
    }
    @Override
    public Button getBackButton() {
        return backButton;
    }
}
