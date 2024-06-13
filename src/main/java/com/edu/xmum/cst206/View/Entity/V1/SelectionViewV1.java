package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.ISelectionView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SelectionViewV1 extends VBox implements ISelectionView {
    private Button easyButton = new Button("Easy");
    private Button mediumButton = new Button("Medium");
    private Button hardButton = new Button("Hard");

    public SelectionViewV1() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(15);

        // 创建难度选择标签
        Label difficultyLabel = new Label("选择难度");
        difficultyLabel.setFont(new Font(24));
        difficultyLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #491f1f;");

        // 设置按钮样式
        setButtonStyle(easyButton);
        setButtonStyle(mediumButton);
        setButtonStyle(hardButton);

        // 背景美化
        setStyle("-fx-background-color: linear-gradient(to bottom right, #4facfe, #00f2fe); -fx-padding: 20px; -fx-border-radius: 10; -fx-alignment: center; -fx-spacing: 20px;");

        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }

    // 设置按钮样式的方法
    private void setButtonStyle(Button button) {
        button.setStyle(
                "-fx-background-color: #0073e6; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(event -> button.setStyle(
                "-fx-background-color: #005bb5; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(event -> button.setStyle(
                "-fx-background-color: #0073e6; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMousePressed(event -> button.setStyle(
                "-fx-background-color: #003d80; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseReleased(event -> button.setStyle(
                "-fx-background-color: #005bb5; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));
    }

    @Override
    public Button getEasyButton() {
        return easyButton;
    }

    @Override
    public Button getMediumButton() {
        return mediumButton;
    }

    @Override
    public Button getHardButton() {
        return hardButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}