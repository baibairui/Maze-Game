package com.edu.xmum.cst206.View.Entity.V2;

import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.ISelectionView;
import com.edu.xmum.cst206.View.Styler.SelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SelectionViewV2 extends VBox implements ISelectionView {
    private final Button easyButton = new Button("Easy");
    private final Button mediumButton = new Button("Medium");
    private final Button hardButton = new Button("Hard");
    private final Label difficultyLabel = new Label("选择难度");

    public SelectionViewV2() {
        // 设置背景颜色
        super();
        SelectionViewStyler.styleVBox(Skin.V2, this);
        // 美化页面
        SelectionViewStyler.styleTitleLabel(Skin.V2, difficultyLabel);
        SelectionViewStyler.styleButton(Skin.V2, easyButton);
        SelectionViewStyler.styleButton(Skin.V2, mediumButton);
        SelectionViewStyler.styleButton(Skin.V2, hardButton);

        // 添加组件到VBox
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
