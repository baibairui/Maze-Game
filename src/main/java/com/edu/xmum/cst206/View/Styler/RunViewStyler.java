package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * Beautification of RunView based on Appearance Pattern Design.
 * Applies styles to various components based on the selected skin.
 */
public class RunViewStyler {

    /**
     * Styles the reset button based on the specified skin.
     *
     * @param skin        The skin to apply to the reset button.
     * @param resetButton The reset button to style.
     */
    public static void resetButtonStyle(Skin skin, Button resetButton) {
        if (resetButton == null) return;
        switch (skin) {
            case V1 -> {
                resetButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(resetButton, "#FF6347", "#FF4500", "#FF6347");
            }
            case V2 -> {
                resetButton.setStyle("-fx-background-color: #6A5ACD; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(resetButton, "#6A5ACD", "#483D8B", "#6A5ACD");
            }
            case V3 -> {
                resetButton.setStyle("-fx-background-color: #32CD32; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(resetButton, "#32CD32", "#228B22", "#32CD32");
            }
        }
    }

    /**
     * Styles the hint button based on the specified skin.
     *
     * @param skin       The skin to apply to the hint button.
     * @param hintButton The hint button to style.
     */
    public static void hintButtonStyle(Skin skin, Button hintButton) {
        if (hintButton == null) return;
        switch (skin) {
            case V1 -> {
                hintButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(hintButton, "#4682B4", "#4169E1", "#4682B4");
            }
            case V2 -> {
                hintButton.setStyle("-fx-background-color: #FF69B4; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(hintButton, "#FF69B4", "#FF1493", "#FF69B4");
            }
            case V3 -> {
                hintButton.setStyle("-fx-background-color: #FFD700; -fx-text-fill: white; -fx-font-size: 14px;");
                applyButtonEffects(hintButton, "#FFD700", "#FFA500", "#FFD700");
            }
        }
    }

    /**
     * Styles the difficulty title label based on the specified skin.
     *
     * @param skin              The skin to apply to the difficulty title label.
     * @param currentDifficulty The difficulty title label to style.
     */
    public static void difficultyTitleStyle(Skin skin, Label currentDifficulty) {
        if (currentDifficulty == null) return;
        switch (skin) {
            case V1 -> {
                currentDifficulty.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                currentDifficulty.setStyle("-fx-text-fill: #333;");
            }
            case V2 -> {
                currentDifficulty.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                currentDifficulty.setStyle("-fx-text-fill: #555;");
            }
            case V3 -> {
                currentDifficulty.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
                currentDifficulty.setStyle("-fx-text-fill: #777;");
            }
        }
    }

    /**
     * Styles the info box based on the specified skin.
     *
     * @param skin    The skin to apply to the info box.
     * @param infoBox The info box to style.
     */
    public static void infoBoxStyle(Skin skin, HBox infoBox) {
        if (infoBox == null) return;
        switch (skin) {
            case V1 -> {
                infoBox.setAlignment(Pos.CENTER);
                infoBox.setPadding(new Insets(10, 10, 10, 10));
                infoBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                infoBox.setStyle("-fx-background-color: #ffa347; -fx-text-fill: white; -fx-font-size: 14px;");
            }
            case V2 -> {
                infoBox.setAlignment(Pos.CENTER);
                infoBox.setPadding(new Insets(10, 10, 10, 10));
                infoBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                infoBox.setStyle("-fx-background-color: #87CEFA; -fx-text-fill: black; -fx-font-size: 14px;");
            }
            case V3 -> {
                infoBox.setAlignment(Pos.CENTER);
                infoBox.setPadding(new Insets(10, 10, 10, 10));
                infoBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                infoBox.setStyle("-fx-background-color: #90EE90; -fx-text-fill: black; -fx-font-size: 14px;");
            }
        }
    }

    /**
     * Styles the control box based on the specified skin.
     *
     * @param skin       The skin to apply to the control box.
     * @param controlBox The control box to style.
     */
    public static void controlBoxStyle(Skin skin, HBox controlBox) {
        if (controlBox == null) return;
        switch (skin) {
            case V1 -> {
                controlBox.setAlignment(Pos.CENTER);
                controlBox.setPadding(new Insets(10, 10, 10, 10));
                controlBox.setBackground(new Background(new BackgroundFill(Color.web("#ffa947"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            case V2 -> {
                controlBox.setAlignment(Pos.CENTER);
                controlBox.setPadding(new Insets(10, 10, 10, 10));
                controlBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                controlBox.setStyle("-fx-background-color: #ffa947; -fx-text-fill: white; -fx-font-size: 14px;");
            }
            case V3 -> {
                controlBox.setAlignment(Pos.CENTER);
                controlBox.setPadding(new Insets(10, 10, 10, 10));
                controlBox.setBackground(new Background(new BackgroundFill(Color.web("#ffa947"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

    /**
     * Styles the game box based on the specified skin.
     *
     * @param skin     The skin to apply to the game box.
     * @param gamePane The game box to style.
     */
    public static void gameBoxStyle(Skin skin, StackPane gamePane) {
        if (gamePane == null) return;
        switch (skin) {
            case V1 -> {
                gamePane.setAlignment(Pos.CENTER);
                gamePane.setStyle("-fx-background-color: white; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");
            }
            case V2 -> {
                gamePane.setAlignment(Pos.CENTER);
                gamePane.setStyle("-fx-background-color: #ADD8E6; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");
            }
            case V3 -> {
                gamePane.setAlignment(Pos.CENTER);
                gamePane.setStyle("-fx-background-color: #98FB98; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");
            }
        }
    }

    /**
     * Styles the main BorderPane based on the specified skin.
     *
     * @param skin The skin to apply to the BorderPane.
     * @param pane The BorderPane to style.
     */
    public static void BoxStyle(Skin skin, BorderPane pane) {
        if (pane == null) return;
        switch (skin) {
            case V1 -> {
                // Setting the main border
                pane.setStyle("-fx-background-color: #F5F5F5;");
            }
            case V2 -> {
                // Setting the main border
                pane.setStyle("-fx-background-color: #E0FFFF;");
            }
            case V3 -> {
                // Setting the main border
                pane.setStyle("-fx-background-color: #F0FFF0;");
            }
        }
    }

    /**
     * Applies hover and press effects to the specified button.
     *
     * @param button      The button to apply effects to.
     * @param normalColor The normal background color of the button.
     * @param hoverColor  The background color of the button when hovered.
     * @param activeColor The background color of the button when pressed.
     */
    private static void applyButtonEffects(Button button, String normalColor, String hoverColor, String activeColor) {
        button.setStyle("-fx-background-color: " + normalColor + "; -fx-text-fill: white; -fx-font-size: 14px;");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: " + hoverColor + "; -fx-text-fill: white; -fx-font-size: 14px;");
            addScaleAnimation(button, 1.1);  // Add zoom animation
        });
        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: " + normalColor + "; -fx-text-fill: white; -fx-font-size: 14px;");
            addScaleAnimation(button, 1.0);  // Restore zoom animation
        });
        button.setOnMousePressed(event -> button.setStyle("-fx-background-color: " + activeColor + "; -fx-text-fill: white; -fx-font-size: 14px;"));
        button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-text-fill: white; -fx-font-size: 14px;"));
    }

    /**
     * Adds a scale animation to the specified button.
     *
     * @param button  The button to animate.
     * @param scaleTo The scale factor to animate to.
     */
    private static void addScaleAnimation(Button button, double scaleTo) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
        scaleTransition.setToX(scaleTo);
        scaleTransition.setToY(scaleTo);
        scaleTransition.play();
    }
}
