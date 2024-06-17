package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.View.Entity.SkinSelectionView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static com.edu.xmum.cst206.Config.SCENE_HEIGHT;
import static com.edu.xmum.cst206.Config.SCENE_WIDTH;

public class SkinSelectionViewStyler {

    public static void VBoxStyle(SkinSelectionView skinSelectionView) {
        skinSelectionView.setMinWidth(300);  // 设置最小宽度
        skinSelectionView.setMinHeight(400); // 设置最小高度
        skinSelectionView.setMaxWidth(SCENE_WIDTH);  // 设置最大宽度
        skinSelectionView.setMaxHeight(SCENE_HEIGHT); // 设置最大高度
        skinSelectionView.setAlignment(Pos.CENTER);
        skinSelectionView.setSpacing(20);
        skinSelectionView.setPadding(new Insets(40));
        skinSelectionView.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        skinSelectionView.setStyle("-fx-border-color: #666; -fx-border-width: 2px; -fx-border-radius: 10;");
    }

    public static void LabelStyle(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setTextFill(Color.DARKBLUE);
    }

    public static void ButtonStyle(Button button) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: #4CAF50; -fx-background-radius: 10;");

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 10;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #4CAF50; -fx-background-radius: 10;"));

        button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #3e8e41; -fx-background-radius: 10;"));
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 10;"));
    }
}
