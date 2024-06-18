package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IVictoryView;
import com.edu.xmum.cst206.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VictoryViewV3 extends VBox implements IVictoryView {
    private Label victoryLabel = new Label();
    private final Button backButton = new Button("Back to Main Menu");
    private String winner;


    public VictoryViewV3() {
        //Setting css style
        VictoryViewStyler.VboxStyle(Skin.V3, this);
        VictoryViewStyler.LabelStyle(Skin.V3, victoryLabel);
        VictoryViewStyler.ButtonStyle(Skin.V3, backButton);
        getChildren().addAll(victoryLabel, backButton);
    }

    @Override
    public VBox getNode() {
        return this;
    }

    @Override
    public void setWinner(String winner) {
        this.winner = winner;
        victoryLabel.setText(winner + " Win !");
    }

    @Override
    public Button getBackButton() {
        //can be designed to return
        return backButton;
    }
}
