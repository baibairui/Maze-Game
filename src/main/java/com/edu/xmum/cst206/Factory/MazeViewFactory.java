package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.MazeViewV1;
import com.edu.xmum.cst206.View.Entity.V3.MazeViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class MazeViewFactory extends AbstractFactory{
    @Override
    public IMazeView getMazeView(String maze, IMazeModel mazeModel) {
        if(maze.equals("V1")){
            return new MazeViewV1(mazeModel);
        } else if (maze.equals("V2")) {
            return new MazeViewV1(mazeModel);
        }else if(maze.equals("V3")){
            return new MazeViewV3(mazeModel);
        }
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
