package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Model.Entity.GameModel;
import com.edu.xmum.cst206.Model.Entity.GameModelVs;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Skin;

public class GameModelFactory extends AbstractFactory{
    @Override
    public IGameModel getGameModel(Skin playerModel) {
        if(playerModel.getSkin().equals("V3")){
            return new GameModelVs();
        }else{
            return new GameModel();
        }
    }
}
