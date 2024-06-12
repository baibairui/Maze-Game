package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.View.Interface.IWelcomeView;
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


public class WelcomeViewV3 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("开始游戏");

    public WelcomeViewV3() {
        // 设置对齐方式和间距
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40));

        // 设置背景颜色
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // 添加标题
        Label titleLabel = new Label("欢迎来到迷宫游戏");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.setTextFill(Color.DARKBLUE);

        // 美化开始按钮
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        startButton.setTextFill(Color.WHITE);
        startButton.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10;");

        // 鼠标悬停样式
        startButton.setOnMouseEntered(e -> startButton.setStyle("-fx-background-color: #FF4500; -fx-background-radius: 10;"));
        startButton.setOnMouseExited(e -> startButton.setStyle("-fx-background-color: #FF6347; -fx-background-radius: 10;"));

        // 添加组件到VBox
        getChildren().addAll(titleLabel, startButton);
    }

    @Override
    public Button getStartButton() {
        return startButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
