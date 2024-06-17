package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import Constant.Skin;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;
import com.edu.xmum.cst206.View.Interface.*;

public abstract class AbstractFactory {
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        return null;
    }

    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        return null;
    }

    public IPrepareView getPrepareView(Skin prepareView) {
        return null;
    }

    public IRunView getRunView(Skin runView, IGameController gameController) {
        return null;
    }

    public ISelectionView getSelectionView(Skin selectionView) {
        return null;
    }

    public IVictoryView getVictoryView(Skin victoryView) {
        return null;
    }

    public IWelcomeView getWelcomeView(Skin welcomeVIew) {
        return null;
    }

    public IGameModel getGameModel(Skin playerModel) {
        return null;
    }

    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        return null;
    }

    public IGameController getGameController(Skin gameController, IGameService gameService) {
        return null;
    }
    public IMazeModel getMazeModel(String maze){ return null;}
    public IPlayerModel getPlayerModel(String player,IMazeModel mazeModel){return null;}
    public IPlayerService getPlayerService(String vision,IPlayerModel mazeModel,IMazeService mazeService){return null;}
    public IMazeService getMazeService(String vision,IMazeModel mazeModel){return null;}
    public IAiService getAiService(String vision,IMazeService mazeService,IPlayerModel playModel,IPlayerModel aiModel){return null;}
}
