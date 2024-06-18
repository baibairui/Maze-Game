package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * Beautification of PrepareView based on Appearance Pattern Design.
 * Applies styles to the VBox, Label, and Button based on the selected skin.
 */
public class PrepareViewStyler {

    /**
     * Styles the VBox based on the specified skin.
     *
     * @param skin The skin to apply to the VBox.
     * @param vBox The VBox to style.
     */
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

    /**
     * Styles the Label based on the specified skin.
     *
     * @param skin The skin to apply to the Label.
     * @param prepareLabel The Label to style.
     */
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
        // Adds floating animation to the label
        addTextFloatingAnimation(prepareLabel);
    }

    /**
     * Styles the Button based on the specified skin.
     *
     * @param skin The skin to apply to the Button.
     * @param button The Button to style.
     */
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
                addButtonAnimation(button, "#4CAF50", "#45a049", "#3e8e41");
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
                addButtonAnimation(button, "#007BFF", "#0056b3", "#004085");
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
                addButtonAnimation(button, "#FF5722", "#E64A19", "#D84315");
            }
        }
    }

    /**
     * Adds floating animation to the specified Label.
     *
     * @param label The Label to animate.
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
     * Adds hover and press animations to the specified Button.
     *
     * @param button The Button to animate.
     * @param normalColor The normal background color of the Button.
     * @param hoverColor The background color of the Button when hovered.
     * @param pressedColor The background color of the Button when pressed.
     */
    private static void addButtonAnimation(Button button, String normalColor, String hoverColor, String pressedColor) {
        button.setOnMouseEntered(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
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
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
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
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(2);
            tt.play();
        });

        button.setOnMouseReleased(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(-2);
            tt.play();
        });
    }
}
