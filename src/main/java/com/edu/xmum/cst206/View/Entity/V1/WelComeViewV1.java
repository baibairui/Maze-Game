package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import com.edu.xmum.cst206.View.Styler.WelcomeViewStyler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class WelComeViewV1 extends VBox implements IWelcomeView {
    private final Button startButton = new Button("开始游戏");
    private final Label titleLabel = new Label("欢迎来到迷宫游戏");

    public WelComeViewV1() {
        // 美化容器
        WelcomeViewStyler.styleVbox(Skin.V1, this);
        //美化组件
        WelcomeViewStyler.styleTitleLabel(Skin.V1, titleLabel);
        WelcomeViewStyler.styleStartButton(Skin.V1, startButton);

        //添加组件
        getChildren().addAll(titleLabel, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }

    @Override
    public Node getNode() {
        return this;
    }
}