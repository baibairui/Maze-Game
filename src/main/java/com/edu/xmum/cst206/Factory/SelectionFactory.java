package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.SelectionViewV1;
import com.edu.xmum.cst206.View.Entity.V2.SelectionViewV2;
import com.edu.xmum.cst206.View.Entity.V3.SelectionViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public  class SelectionFactory extends AbstractFactory{
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
        return null;
    }

    @Override
    public ISelectionView getSelectionView(String selectionView) {
        if(selectionView.equals("V1")){
            return new SelectionViewV1();
        }else if(selectionView.equals("V2")){
            return new SelectionViewV2();
        }else if(selectionView.equals("V3")){
            return new SelectionViewV3();
        }
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
