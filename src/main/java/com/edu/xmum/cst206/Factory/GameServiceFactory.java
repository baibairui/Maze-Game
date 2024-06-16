package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.Service.GameServiceVs;
import com.edu.xmum.cst206.Service.Interface.IGameService;

public class GameServiceFactory extends AbstractFactory{
    @Override
    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        if(gameService.getSkin().equals("V3")){
            return new GameServiceVs(gameModel);
        }else{
            return new GameService(gameModel);
        }
    }
}
