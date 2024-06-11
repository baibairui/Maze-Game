package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.RunViewV1;
import com.edu.xmum.cst206.View.Entity.V2.RunViewV2;
import com.edu.xmum.cst206.View.Interface.*;

public class RunViewFactory extends AbstractFactory{
    @Override
    public IMazeView getMazeView(String maze, IMazeModel mazeModel) {
        return null;
    }

    @Override
    public IPlayerView getPlayerView(String player, IPlayerModel playerModel) {
        return null;
    }

    @Override
    public IPrepareView getPrepareView(String prepareView) {
        return null;
    }

    @Override
    public IRunView getRunView(String runView, IGameController gameController) {
        if(runView.equals("V1")){
            return new RunViewV1(gameController);
        }else if(runView.equals("V2")){
            return new RunViewV2(gameController);
        }
        return null;
    }

    @Override
    public ISelectionView getSelectionView(String selectionView) {
        return null;
    }

    @Override
    public IVictoryView getVictoryView(String victoryView) {
        return null;
    }

    @Override
    public IWelcomeView getWelcomeView(String welcomeVIew) {
        return null;
    }
}
