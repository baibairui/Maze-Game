package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.*;

import java.util.function.IntPredicate;

public abstract class AbstractFactory {
    public abstract IMazeView getMazeView(String maze, IMazeModel mazeModel);
    public abstract IPlayerView getPlayerView(String player, IPlayerModel playerModel);
    public abstract IPrepareView getPrepareView(String prepareView);
    public abstract IRunView getRunView(String runView, IGameController gameController);
    public abstract ISelectionView getSelectionView(String selectionView);
    public abstract IVictoryView getVictoryView(String victoryView);
    public abstract IWelcomeView getWelcomeView(String welcomeVIew);
}
