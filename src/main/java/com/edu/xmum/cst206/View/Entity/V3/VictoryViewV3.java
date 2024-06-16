package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.View.Interface.IVictoryView;
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

public class VictoryViewV3 extends VBox implements IVictoryView {
    private  Label victoryLabel;
    private final Button backButton = new Button("返回主菜单");
    private String winner;

    public VictoryViewV3() {
        setAlignment(Pos.CENTER);
        setSpacing(30);
        setPadding(new Insets(40));
        setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        victoryLabel=new Label();
        victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        victoryLabel.setTextFill(Color.DARKGREEN);
        // 美化按钮
        styleButton(backButton, "#FF6347", "#FF4500");

        getChildren().addAll(victoryLabel, backButton);
    }

    private void styleButton(Button button, String bgColor, String hoverColor) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-background-radius: 10;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;"));
    }

    @Override
    public VBox getNode() {
        return this;
    }

    @Override
    public void setWinner(String winner) {
        this.winner=winner;
        victoryLabel.setText(winner+" Win !");
    }

    @Override
    public Button getBackButton() {
        //可以设计返回
        return backButton;
    }
}
