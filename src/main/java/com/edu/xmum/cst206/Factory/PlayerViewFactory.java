package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.PlayerViewV1;
import com.edu.xmum.cst206.View.Entity.V2.PlayerViewV2;
import com.edu.xmum.cst206.View.Entity.V3.MazeViewV3;
import com.edu.xmum.cst206.View.Entity.V3.PlayerViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class PlayerViewFactory extends AbstractFactory{
    @Override
    public IMazeView getMazeView(String maze, IMazeModel mazeModel) {
        return null;
    }

    @Override
    public IPlayerView getPlayerView(String player, IPlayerModel playerModel) {
        if(player.equals("V1")){
            return new PlayerViewV1(playerModel);
        }else if(player.equals("V2")){
            return new PlayerViewV2(playerModel);
        }else if(player.equals("V3")){
            return new PlayerViewV3(playerModel);
        }
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
