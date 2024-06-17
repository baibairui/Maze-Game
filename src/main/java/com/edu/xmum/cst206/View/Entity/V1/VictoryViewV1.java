package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Interface.IVictoryView;
import com.edu.xmum.cst206.View.Styler.VictoryViewStyler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoryViewV1 extends VBox implements IVictoryView {
    private final Button backButton= new Button("返回主页面");
    private String winner="Player";
    private final Label victoryLabel = new Label(winner+" 获胜 ");

    public VictoryViewV1() {
        VictoryViewStyler.VboxStyle(Skin.V1,this);
        VictoryViewStyler.LabelStyle(Skin.V1,victoryLabel);
        VictoryViewStyler.ButtonStyle(Skin.V1,backButton);
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

    @Override
    public void setWinner(String winner) {
        this.winner=winner;
    }
}
