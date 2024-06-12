package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.PrepareViewV1;
import com.edu.xmum.cst206.View.Entity.V2.PrepareViewV2;
import com.edu.xmum.cst206.View.Entity.V3.MazeViewV3;
import com.edu.xmum.cst206.View.Entity.V3.PrepareViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class PrepareViewFactory extends AbstractFactory{
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
        if(prepareView.equals("V1")){
            return new PrepareViewV1();
        }else if(prepareView.equals("V2")){
            return new PrepareViewV2();
        }else if(prepareView.equals("V3")){
            return new PrepareViewV3();
        }
        return null;
    }

    @Override
    public IRunView getRunView(String runView, IGameController gameController) {
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
