package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IVictoryView;
import com.edu.xmum.cst206.View.Styler.VictoryViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VictoryViewV2 extends VBox implements IVictoryView {
    private final Label victoryLabel = new Label("Congrats on the clearance!");
    private final Button backButton = new Button("Back to Main Menu");

    public VictoryViewV2() {
        //美化
        VictoryViewStyler.VboxStyle(Skin.V2, this);
        VictoryViewStyler.ButtonStyle(Skin.V2, backButton);
        VictoryViewStyler.LabelStyle(Skin.V2, victoryLabel);
        getChildren().addAll(victoryLabel, backButton);
    }


    @Override
    public VBox getNode() {
        return this;
    }

    //空实现
    @Override
    public void setWinner(String winner) {

    }

    @Override
    public Button getBackButton() {
        //can be designed to return
        return backButton;
    }
}
