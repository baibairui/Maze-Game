package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IVictoryView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoryViewV1 extends VBox implements IVictoryView {
    private final Button backButton= new Button("返回主页面");
    private final String winner="Player";
    public VictoryViewV1() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label victoryLabel = new Label(winner+" 获胜 ");
        victoryLabel.setFont(new Font(24));
        getChildren().addAll(victoryLabel,backButton);
    }

    @Override
    public Button getBackButton() {
        return backButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }

    //空实现
    @Override
    public void setWinner(String winner) {

    }
}
