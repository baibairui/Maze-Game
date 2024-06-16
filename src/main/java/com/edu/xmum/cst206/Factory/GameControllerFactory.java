package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Controller.GameControllerVs;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.Service.Interface.IGameService;

public class GameControllerFactory extends AbstractFactory{
    @Override
    public IGameController gameController(Skin gameController, IGameService gameService) {
       if(gameController.getSkin().equals("V3")){
           return new GameControllerVs(gameService);
       }else {
           return new GameController(gameService);
       }
    }
}
