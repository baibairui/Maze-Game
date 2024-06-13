package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.View.Interface.ISkinSelectionView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SkinSelectionView extends VBox implements ISkinSelectionView {
    ArrayList<Button> Buttons;
    public SkinSelectionView(){
        super();
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label label=new Label("选择你想用的皮肤");
        Buttons=new ArrayList<>();
        for(int i=0;i<FactoryProducer.getSize();i++){
            Buttons.add(new Button("V"+(i+1)));
        }
        getChildren().add(label);
        for(Button button:getButtons()){
            getChildren().add(button);
        }
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
