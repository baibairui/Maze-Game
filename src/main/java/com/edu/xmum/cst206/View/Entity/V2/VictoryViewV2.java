package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Interface.IVictoryView;
import com.edu.xmum.cst206.View.Styler.VictoryViewStyler;
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

public class VictoryViewV2 extends VBox implements IVictoryView {
    private final Label victoryLabel = new Label("恭喜通关!");
    private final Button backButton = new Button("返回主菜单");

    public VictoryViewV2() {
        //美化
        VictoryViewStyler.VboxStyle(Skin.V2,this);
        VictoryViewStyler.ButtonStyle(Skin.V2,backButton);
        VictoryViewStyler.LabelStyle(Skin.V2,victoryLabel);
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
        //可以设计返回
        return backButton;
    }
}
