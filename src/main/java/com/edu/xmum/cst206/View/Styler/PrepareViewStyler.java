package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PrepareViewStyler {
    public static void VboxStyle(Skin skin, VBox vBox) {
        if (vBox == null) return;
        switch (skin) {
            case V1 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #f7f8fa, #e2e2e2); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"
                );
            }
            case V2 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #a1c4fd, #c2e9fb); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                );
            }
            case V3 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #ffecd2, #fcb69f); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                );
            }
        }
    }

    public static void LabelStyle(Skin skin, Label prepareLabel) {
        if (prepareLabel == null) return;
        switch (skin) {
            case V1 -> {
                prepareLabel.setFont(new Font(18));
                prepareLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
            }
            case V2 -> {
                prepareLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                prepareLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #444;");
            }
            case V3 -> {
                prepareLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                prepareLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #222;");
            }
        }
    }

    public static void ButtonStyle(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            case V1 -> {
                button.setStyle(
                        "-fx-background-color: #4CAF50; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                );

                button.setOnMouseEntered(event -> button.setStyle(
                        "-fx-background-color: #45a049; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseExited(event -> button.setStyle(
                        "-fx-background-color: #4CAF50; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMousePressed(event -> button.setStyle(
                        "-fx-background-color: #3e8e41; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseReleased(event -> button.setStyle(
                        "-fx-background-color: #45a049; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));
            }
            case V2 -> {
                button.setStyle(
                        "-fx-background-color: #007BFF; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                );

                button.setOnMouseEntered(event -> button.setStyle(
                        "-fx-background-color: #0056b3; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseExited(event -> button.setStyle(
                        "-fx-background-color: #007BFF; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMousePressed(event -> button.setStyle(
                        "-fx-background-color: #004085; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseReleased(event -> button.setStyle(
                        "-fx-background-color: #0056b3; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                ));
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle(
                        "-fx-background-color: #FF5722; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                );

                button.setOnMouseEntered(e -> button.setStyle(
                        "-fx-background-color: #E64A19; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseExited(e -> button.setStyle(
                        "-fx-background-color: #FF5722; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMousePressed(e -> button.setStyle(
                        "-fx-background-color: #D84315; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                ));

                button.setOnMouseReleased(e -> button.setStyle(
                        "-fx-background-color: #E64A19; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                ));
            }
        }
    }
}
