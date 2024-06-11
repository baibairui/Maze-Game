package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.View.Interface.IPrepareView;
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

public class PrepareViewV2 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("开始游戏");

    public PrepareViewV2() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40));

        // 设置背景颜色
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setStyle("-fx-background-color: rgba(71,249,255,0.63); -fx-text-fill: white; -fx-font-size: 14px;");
        // 添加标题
        Label prepareLabel = new Label("准备好开始游戏!");
        prepareLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        prepareLabel.setTextFill(Color.DARKBLUE);

        // 美化开始游戏按钮
        styleButton(startGameButton, "#FF6347", "#FF4500");

        // 添加组件到VBox
        getChildren().addAll(prepareLabel, startGameButton);
    }

    private void styleButton(Button button, String bgColor, String hoverColor) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-background-radius: 10;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;"));
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
