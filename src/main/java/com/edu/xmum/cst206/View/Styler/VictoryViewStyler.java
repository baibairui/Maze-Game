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

public class VictoryViewStyler {

    public static void VboxStyle(Skin skin, VBox box){
        if(box == null) return;
        switch (skin){
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
        if(victoryLabel == null) return;
        switch (skin){
            case V1 -> {
                victoryLabel.setFont(new Font(24));
                victoryLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0073e6; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            case V2 -> {
                victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                victoryLabel.setTextFill(Color.DARKGREEN);
                victoryLabel.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
            case V3 -> {
                victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                victoryLabel.setTextFill(Color.DEEPPINK);
                victoryLabel.setStyle("-fx-background-color: #FF69B4; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");
            }
        }
    }

    public static void ButtonStyle(Skin skin, Button button) {
        if(button == null) return;
        switch (skin){
            case V1 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF4500; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
            }
            case V2 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #2E8B57; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #32CD32; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);");

                button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF1493; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
                button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #FF69B4; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 5, 0.5, 0, 0);"));
            }
        }
    }
}
