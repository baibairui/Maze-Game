package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Interface.IPrepareView;
import com.edu.xmum.cst206.View.Styler.PrepareViewStyler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class PrepareViewV1 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("开始游戏");
    private final Label prepareLabel = new Label("准备好开始游戏!");

    public PrepareViewV1() {
        super();
        //绑定样式
        PrepareViewStyler.VboxStyle(Skin.V1,this);
        PrepareViewStyler.LabelStyle(Skin.V1,prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V1,startGameButton);
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
