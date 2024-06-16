package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Interface.*;

import java.util.function.IntPredicate;

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

    public IGameController gameController(Skin gameController,IGameService gameService) {
        return null;
    }
}
