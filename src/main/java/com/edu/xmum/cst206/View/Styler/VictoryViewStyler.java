package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

public class VictoryViewStyler {

    public static void VboxStyle(Skin skin, VBox box) {
        if (box == null) return;
        switch (skin) {
            case V1 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(20));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #0073e6; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V2 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(30);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #32CD32; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V3 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(30);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #FF69B4; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
        }
    }

    public static void LabelStyle(Skin skin, Label victoryLabel) {
        if (victoryLabel == null) return;
        switch (skin) {
            case V1 -> {
                victoryLabel.setFont(new Font(24));
                victoryLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0073e6; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
                addFloatingLabelAnimation(victoryLabel);
            }
            case V2 -> {
                victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                victoryLabel.setTextFill(Color.DARKGREEN);
                victoryLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
                addFloatingLabelAnimation(victoryLabel);
            }
            case V3 -> {
                victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                victoryLabel.setTextFill(Color.DEEPPINK);
                victoryLabel.setStyle("-fx-background-color: #FF69B4; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
                addFloatingLabelAnimation(victoryLabel);
            }
        }
    }

    public static void ButtonStyle(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            case V1 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#FF6347", "#FF4500", "#CD5C5C");
            }
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#32CD32", "#2E8B57", "#228B22");
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#FF69B4", "#FF1493", "#FF007F");
            }
        }
    }

    private static void addButtonAnimation(Button button, String normalColor, String hoverColor, String pressedColor) {
        button.setOnMouseEntered(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 18px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 10; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
            );

            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        button.setOnMouseExited(event -> {
            button.setStyle(
                    "-fx-background-color: " + normalColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 18px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 10; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
            );

            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        button.setOnMousePressed(event -> {
            button.setStyle(
                    "-fx-background-color: " + pressedColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 18px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 10; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
            );

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(2);
            tt.play();
        });

        button.setOnMouseReleased(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 18px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 10; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
            );

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(-2);
            tt.play();
        });
    }

    private static void addFloatingLabelAnimation(Label label) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(1000), label);
        tt.setFromY(-10);
        tt.setToY(10);
        tt.setAutoReverse(true);
        tt.setCycleCount(TranslateTransition.INDEFINITE);
        tt.play();
    }
}
