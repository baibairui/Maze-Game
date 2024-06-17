package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.ISelectionView;
import com.edu.xmum.cst206.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SelectionViewV1 extends VBox implements ISelectionView {
    private final Button easyButton = new Button("Easy");
    private final Button mediumButton = new Button("Medium");
    private final Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("选择难度");

    public SelectionViewV1() {
        // 背景美化
        super();
        SelectionViewStyler.styleVBox(Skin.V1, this);
        // 设置按钮样式
        SelectionViewStyler.styleTitleLabel(Skin.V1, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V1, easyButton);
        SelectionViewStyler.styleButton(Skin.V1, mediumButton);
        SelectionViewStyler.styleButton(Skin.V1, hardButton);

        //添加组件
        getChildren().addAll(difficultyLabel, easyButton, mediumButton, hardButton);
    }


    @Override
    public Button getEasyButton() {
        return easyButton;
    }

    @Override
    public Button getMediumButton() {
        return mediumButton;
    }

    @Override
    public Button getHardButton() {
        return hardButton;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}