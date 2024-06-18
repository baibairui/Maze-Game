package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.View.Entity.SkinSelectionView;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;



import static Constant.Config.SCENE_HEIGHT;
import static Constant.Config.SCENE_WIDTH;

public class SkinSelectionViewStyler {

    public static void VBoxStyle(SkinSelectionView skinSelectionView) {
        skinSelectionView.setMinWidth(300);  // Setting the minimum width
        skinSelectionView.setMinHeight(400); // Setting the minimum height
        skinSelectionView.setMaxWidth(SCENE_WIDTH);  // Setting the maximum width
        skinSelectionView.setMaxHeight(SCENE_HEIGHT); // Setting the maximum height
        skinSelectionView.setAlignment(Pos.CENTER);
        skinSelectionView.setSpacing(20);
        skinSelectionView.setPadding(new Insets(40));
        skinSelectionView.setStyle("-fx-border-color: #666; -fx-border-width: 2px; -fx-border-radius: 10;"); // 设置边框样式

        // 加载背景图像
        Image backgroundImage = new Image("/com/edu/xmum/cst206/带背景动图/首页背景.gif");

        // 创建背景图像对象
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,  // 背景不重复
                BackgroundRepeat.NO_REPEAT,  // 背景不重复
                BackgroundPosition.CENTER,  // 背景居中
                new BackgroundSize(100, 100, true, true, false, true)
        );

        // 设置背景
        skinSelectionView.setBackground(new Background(bgImage));
    }

    public static void LabelStyle(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 60));
        label.setTextFill(Color.LIGHTGRAY);
        // Adding a float up/down animation
        addTextFloatingAnimation(label);
    }

    public static void ButtonStyle(Button button) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: #4CAF50; -fx-background-radius: 10;");

        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 10;");
            // Add zoom animation
            addScaleAnimation(button, 1.1);
        });
        button.setOnMouseExited(e -> {
            button.setStyle("-fx-background-color: #4CAF50; -fx-background-radius: 10;");
            // Add zoom animation
            addScaleAnimation(button, 1.0);
        });

        button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #3e8e41; -fx-background-radius: 10;"));
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 10;"));
    }

    private static void addTextFloatingAnimation(Label label) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), label);
        translateTransition.setFromY(0);
        translateTransition.setToY(-10);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();
    }

    private static void addScaleAnimation(Button button, double scaleTo) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
        scaleTransition.setToX(scaleTo);
        scaleTransition.setToY(scaleTo);
        scaleTransition.play();
    }
}

