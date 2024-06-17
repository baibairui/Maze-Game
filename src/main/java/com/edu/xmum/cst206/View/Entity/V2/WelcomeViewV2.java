package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import com.edu.xmum.cst206.View.Styler.WelcomeViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class WelcomeViewV2 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("开始游戏");
    private final Label titleLabel = new Label("欢迎来到迷宫游戏");

    public WelcomeViewV2() {
        WelcomeViewStyler.styleVbox(Skin.V2, this);
        //美化组件
        WelcomeViewStyler.styleStartButton(Skin.V2, startButton);
        WelcomeViewStyler.styleTitleLabel(Skin.V2, titleLabel);

        // 添加组件到VBox
        getChildren().addAll(titleLabel, startButton);
    }

    @Override
    public Button getStartButton() {
        return startButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
