package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.View.Interface.ISelectionView;
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

public class SelectionViewNew extends VBox implements ISelectionView {
    private Button easyButton = new Button("Easy");
    private Button mediumButton = new Button("Medium");
    private Button hardButton = new Button("Hard");

    public SelectionViewNew() {
        super();
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40));

        // 设置背景颜色
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // 添加标题
        Label difficultyLabel = new Label("选择难度");
        difficultyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        difficultyLabel.setTextFill(Color.DARKBLUE);

        // 美化按钮
        styleButton(easyButton, "#32CD32", "#228B22");
        styleButton(mediumButton, "#FFA500", "#FF8C00");
        styleButton(hardButton, "#FF6347", "#FF4500");

        // 添加组件到VBox
        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }

    private void styleButton(Button button, String bgColor, String hoverColor) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-background-radius: 10;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;"));
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
