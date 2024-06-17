package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.View.Interface.ISkinSelectionView;
import com.edu.xmum.cst206.View.Styler.SkinSelectionViewStyler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SkinSelectionView extends VBox implements ISkinSelectionView {
    ArrayList<Button> Buttons = new ArrayList<>();
    private final Label label = new Label("选择你想用的皮肤");

    public SkinSelectionView() {
        super();
        SkinSelectionViewStyler.VBoxStyle(this);
        SkinSelectionViewStyler.LabelStyle(label);
        //添加按钮
        for (int i = 0; i < FactoryProducer.getSkinSize(); i++) {
            Button button = new Button("V" + (i + 1));
            SkinSelectionViewStyler.ButtonStyle(button);
            Buttons.add(button);
        }
        //添加组件
        getChildren().add(label);
        getChildren().addAll(Buttons);
    }

    @Override
    public ArrayList<Button> getButtons() {
        return Buttons;
    }

    @Override
    public VBox getNode() {
        return this;
    }
}
