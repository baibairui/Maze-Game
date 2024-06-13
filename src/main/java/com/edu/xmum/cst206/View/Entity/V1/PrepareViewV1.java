package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IPrepareView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class PrepareViewV1 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("开始游戏");

    public PrepareViewV1() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(15);

        // 创建准备标签
        Label prepareLabel = new Label("准备好开始游戏!");
        prepareLabel.setFont(new Font(18));
        prepareLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // 设置按钮样式
        startGameButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        );

        startGameButton.setOnMouseEntered(event -> startGameButton.setStyle(
                "-fx-background-color: #45a049; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        startGameButton.setOnMouseExited(event -> startGameButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        startGameButton.setOnMousePressed(event -> startGameButton.setStyle(
                "-fx-background-color: #3e8e41; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        startGameButton.setOnMouseReleased(event -> startGameButton.setStyle(
                "-fx-background-color: #45a049; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5; " +
                        "-fx-cursor: hand;"
        ));

        // 设置背景样式
        setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #f7f8fa, #e2e2e2); " +
                        "-fx-padding: 20px; " +
                        "-fx-border-radius: 10; " +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"
        );

        getChildren().addAll(prepareLabel, startGameButton);
    }

    @Override
    public Button getStartGameButton() {
        return startGameButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
