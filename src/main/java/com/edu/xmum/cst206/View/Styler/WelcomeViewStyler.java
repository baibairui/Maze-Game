package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.Model.Skin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class WelcomeViewStyler {
    // 用于美化容器
    public static void styleVbox(Skin skin, VBox box) {
        if (box == null) return;
        switch (skin) {
            case V1 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setStyle("-fx-border-color: #0073e6; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V2 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setStyle("-fx-border-color: #32CD32; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V3 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setStyle("-fx-border-color: #FF69B4; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
        }
    }

    // 用于美化文本
    public static void styleTitleLabel(Skin skin, Label label) {
        if (label == null) return;
        switch (skin) {
            case V1 -> {
                label.setFont(new Font(50));
                label.setStyle("-fx-font-size: 50px; " +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #667fe3;" +
                        "-fx-effect: dropshadow(gaussian, rgba(117, 26, 26, 0.75), 10, 0.5, 0, 0);");
            }
            case V2 -> {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                label.setTextAlignment(TextAlignment.CENTER);
                label.setTextFill(Color.DARKBLUE);
                label.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            case V3 -> {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                label.setTextAlignment(TextAlignment.CENTER);
                label.setTextFill(Color.DARKBLUE);
                label.setStyle("-fx-background-color: #FF69B4; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
        }
    }

    // 用于美化按钮
    public static void styleStartButton(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            case V1 -> {
                button.setStyle("-fx-background-color: #3f4b57; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #2c3e50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"));

                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #3f4b57; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"));
            }
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10;");
                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF4500; -fx-background-radius: 10;"));
                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10;"));
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10;");
                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF1493; -fx-background-radius: 10;"));
                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10;"));
            }
        }
    }
}
