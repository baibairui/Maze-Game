package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.Model.Skin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SelectionViewStyler {
    // 用于美化容器
    public static void styleVBox(Skin skin, VBox box){
        if(box == null) return;
        switch (skin){
            case V1 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #0073e6; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V2 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #32CD32; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
            case V3 -> {
                box.setAlignment(Pos.CENTER);
                box.setSpacing(20);
                box.setPadding(new Insets(40));
                box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
                box.setStyle("-fx-border-color: #FF69B4; -fx-border-width: 2px; -fx-border-radius: 10;");
            }
        }
    }

    public static void styleTitleLabel(Skin skin, Label difficultyLabel){
        if(difficultyLabel == null) return;
        switch (skin){
            // 对V1模式的美化
            case V1 -> {
                difficultyLabel.setFont(new Font(24));
                difficultyLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0073e6; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            // 对V2模式的美化
            case V2 -> {
                difficultyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                difficultyLabel.setTextFill(Color.DARKGREEN);
                difficultyLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            // 对V3模式的美化
            case V3 -> {
                difficultyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                difficultyLabel.setTextFill(Color.DEEPPINK);
                difficultyLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
        }
    }

    public static void styleButton(Skin skin, Button button){
        if(button == null) return;
        switch (skin){
            // 用来美化V1
            case V1 -> {
                button.setStyle(
                        "-fx-background-color: #0073e6; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                );

                button.setOnMouseEntered(event -> button.setStyle(
                        "-fx-background-color: #005bb5; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                ));

                button.setOnMouseExited(event -> button.setStyle(
                        "-fx-background-color: #0073e6; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                ));

                button.setOnMousePressed(event -> button.setStyle(
                        "-fx-background-color: #003d80; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                ));

                button.setOnMouseReleased(event -> button.setStyle(
                        "-fx-background-color: #005bb5; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;" +
                                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"
                ));
            }
            // 用来美化V2
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #2E8B57; -fx-background-radius: 10;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));

                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
            }
            // 用来美化V3
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF1493; -fx-background-radius: 10;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));

                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
            }
        }
    }
}
