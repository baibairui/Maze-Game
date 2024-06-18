package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IVictoryView;
import com.edu.xmum.cst206.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VictoryViewV1 extends VBox implements IVictoryView {
    private final Button backButton = new Button("Back to main page");
    private String winner = "Player";
    private final Label victoryLabel = new Label(winner + " Win! ");

    public VictoryViewV1() {
        VictoryViewStyler.VboxStyle(Skin.V1, this);
        VictoryViewStyler.LabelStyle(Skin.V1, victoryLabel);
        VictoryViewStyler.ButtonStyle(Skin.V1, backButton);
        getChildren().addAll(victoryLabel, backButton);
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
        this.winner = winner;
    }
}
