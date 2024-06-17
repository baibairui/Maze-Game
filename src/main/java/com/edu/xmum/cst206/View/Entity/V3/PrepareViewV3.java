package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IPrepareView;
import com.edu.xmum.cst206.View.Styler.PrepareViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrepareViewV3 extends VBox implements IPrepareView {
    private final Button startGameButton = new Button("开始游戏");
    private final Label prepareLabel = new Label("准备好开始游戏!");

    public PrepareViewV3() {
        super();
        PrepareViewStyler.VboxStyle(Skin.V3, this);
        PrepareViewStyler.LabelStyle(Skin.V3, prepareLabel);
        PrepareViewStyler.ButtonStyle(Skin.V3, startGameButton);
        // 添加组件到VBox
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
