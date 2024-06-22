package com.edu.xmum.CST210.View.Styler;

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
import javafx.util.Duration;

/**
 * Beautification of SelectionView based on Appearance Pattern Design.
 * Applies styles to various components based on the selected skin.
 */
public class SelectionViewStyler {

    /**
     * Styles the VBox based on the specified skin.
     *
     * @param skin The skin to apply to the VBox.
     * @param box  The VBox to style.
     */
    public static void styleVBox(Skin skin, VBox box) {
        if (box == null) return;
        switch (skin) {
            case V1 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #0073e6; -fx-border-width: 2px; -fx-border-radius: 10;");

                Image backgroundImage = new Image("/com/edu/xmum/CST210/background/zombie2.jpg");
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
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #32CD32; -fx-border-width: 2px; -fx-border-radius: 10;");
                Image backgroundImage = new Image("/com/edu/xmum/CST210/background/maze2.gif");
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
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #FF69B4; -fx-border-width: 2px; -fx-border-radius: 10;");
                Image backgroundImage = new Image("/com/edu/xmum/CST210/background/pikachu2.jpg");
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
     * @param skin            The skin to apply to the title label.
     * @param difficultyLabel The title label to style.
     */
    public static void styleTitleLabel(Skin skin, Label difficultyLabel) {
        if (difficultyLabel == null) return;
        switch (skin) {
            // Beautification of the V1 model
            case V1 -> {
                difficultyLabel.setFont(new Font(48));
                difficultyLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: #0073e6; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            // Beautification of the V2 model
            case V2 -> {
                difficultyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
                difficultyLabel.setTextFill(Color.DARKGREEN);
                difficultyLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            // Beautification of the V3 model
            case V3 -> {
                difficultyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
                difficultyLabel.setTextFill(Color.DEEPPINK);
                difficultyLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
        }
        // Adding a float up/down animation
        addTextFloatingAnimation(difficultyLabel);
    }

    /**
     * Styles the button based on the specified skin.
     *
     * @param skin   The skin to apply to the button.
     * @param button The button to style.
     */
    public static void styleButton(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            // Used to beautify V1
            case V1 -> {
                button.setStyle(
                        "-fx-background-color: #0073e6; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 24px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                );

                addButtonAnimation(button, "#0073e6", "#005bb5", "#003d80");
            }
            // Used to beautify V2
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#32CD32", "#2E8B57", "#228B22");
            }
            // Used to beautify V3
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                addButtonAnimation(button, "#FF69B4", "#FF1493", "#FF007F");
            }
        }
    }

    /**
     * Adds animation to the button for hover and press effects.
     *
     * @param button       The button to animate.
     * @param normalColor  The normal background color of the button.
     * @param hoverColor   The background color of the button when hovered.
     * @param pressedColor The background color of the button when pressed.
     */
    private static void addButtonAnimation(Button button, String normalColor, String hoverColor, String pressedColor) {
        button.setOnMouseEntered(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 24px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
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
                            "-fx-font-size: 24px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
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
                            "-fx-font-size: 24px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
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
                            "-fx-font-size: 24px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
            );

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(-2);
            tt.play();
        });
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
}
