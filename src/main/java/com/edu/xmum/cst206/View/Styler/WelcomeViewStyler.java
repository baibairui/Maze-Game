package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * Beautification of WelcomeView based on Appearance Pattern Design.
 * Applies styles to various components based on the selected skin.
 */
public class WelcomeViewStyler {

    /**
     * Styles the VBox based on the specified skin.
     *
     * @param skin The skin to apply to the VBox.
     * @param box  The VBox to style.
     */
    public static void styleVbox(Skin skin, VBox box) {
        if (box == null) return;
        switch (skin) {
            case V1 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setStyle("-fx-border-color: #0073e6; -fx-border-width: 2px; -fx-border-radius: 10;");

                Image backgroundImage = new Image("/com/edu/xmum/cst206/带背景动图/僵尸背景1.gif");
                BackgroundImage bgImage = new BackgroundImage(
                        backgroundImage,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                );
                box.setBackground(new Background(bgImage));
            }
            case V2 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setStyle("-fx-border-color: #32CD32; -fx-border-width: 2px; -fx-border-radius: 10;");
                Image backgroundImage = new Image("/com/edu/xmum/cst206/带背景动图/迷宫2.png");
                BackgroundImage bgImage = new BackgroundImage(
                        backgroundImage,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                );
                box.setBackground(new Background(bgImage));
            }
            case V3 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
                box.setStyle("-fx-border-color: #FF69B4; -fx-border-width: 2px; -fx-border-radius: 10;");
                Image backgroundImage = new Image("/com/edu/xmum/cst206/带背景动图/皮卡丘2.gif");
                BackgroundImage bgImage = new BackgroundImage(
                        backgroundImage,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                );
                box.setBackground(new Background(bgImage));
            }
        }
    }

    /**
     * Styles the title label based on the specified skin.
     *
     * @param skin  The skin to apply to the title label.
     * @param label The title label to style.
     */
    public static void styleTitleLabel(Skin skin, Label label) {
        if (label == null) return;
        switch (skin) {
            case V1 -> {
                label.setStyle("-fx-font-size: 48px; " +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #667fe3;" +
                        "-fx-effect: dropshadow(gaussian, rgba(117, 26, 26, 0.75), 10, 0.5, 0, 0);");
            }
            case V2 -> {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 48));
                label.setTextAlignment(TextAlignment.CENTER);
                label.setTextFill(Color.DARKBLUE);
                label.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            case V3 -> {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 48));
                label.setTextAlignment(TextAlignment.CENTER);
                label.setTextFill(Color.DARKBLUE);
                label.setStyle("-fx-background-color: #FF69B4; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
        }
        // Adding a float up/down animation
        addTextFloatingAnimation(label);
    }

    /**
     * Styles the start button based on the specified skin.
     *
     * @param skin   The skin to apply to the start button.
     * @param button The start button to style.
     */
    public static void styleStartButton(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            case V1 -> {
                button.setStyle("-fx-background-color: #3f4b57; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 24px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#3f4b57", "#2c3e50", "#21252b");
            }
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10;");
                addButtonAnimation(button, "#FF6347", "#FF4500", "#FF6347");
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10;");
                addButtonAnimation(button, "#FF69B4", "#FF1493", "#FF69B4");
            }
        }
    }

    /**
     * Adds a floating animation to the specified label.
     *
     * @param label The label to animate.
     */
    private static void addTextFloatingAnimation(Label label) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), label);
        translateTransition.setFromY(0);
        translateTransition.setToY(-10);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();
    }

    /**
     * Adds hover and press effects to the specified button.
     *
     * @param button       The button to apply effects to.
     * @param normalColor  The normal background color of the button.
     * @param hoverColor   The background color of the button when hovered.
     * @param pressedColor The background color of the button when pressed.
     */
    private static void addButtonAnimation(Button button, String normalColor, String hoverColor, String pressedColor) {
        button.setOnMouseEntered(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 22px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand; " +
                            "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"
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
                            "-fx-font-size: 22px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand; " +
                            "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"
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
                            "-fx-font-size: 22px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand; " +
                            "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"
            );

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(2);
            tt.play();
        });

        button.setOnMouseReleased(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 22px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand; " +
                            "-fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0);"
            );

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(-2);
            tt.play();
        });
    }
}
