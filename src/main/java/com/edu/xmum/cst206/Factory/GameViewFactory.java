package com.edu.xmum.cst206.Factory;

import Constant.Skin;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Entity.V1.*;
import com.edu.xmum.cst206.View.Entity.V2.*;
import com.edu.xmum.cst206.View.Entity.V3.*;
import com.edu.xmum.cst206.View.Interface.*;

public class GameViewFactory extends AbstractFactory{
    @Override
    public IVictoryView getVictoryView(Skin victoryView) {
        if (victoryView.getSkin().equals("V1")) {
            return new VictoryViewV1();
        } else if (victoryView.getSkin().equals("V2")) {
            return new VictoryViewV2();
        } else if (victoryView.getSkin().equals("V3")) {
            return new VictoryViewV3();
        }
        return null;
    }
    @Override
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        if (maze.getSkin().equals("V1")) {
            return new MazeViewV1(mazeModel);
        } else if (maze.getSkin().equals("V2")) {
            return new MazeViewV1(mazeModel);
        } else if (maze.getSkin().equals("V3")) {
            return new MazeViewV3(mazeModel);
        }
        return null;
    }
    public IRunView getRunView(Skin runView, IGameController gameController) {
        if (runView.getSkin().equals("V1")) {
            return new RunViewV1(gameController);
        } else if (runView.getSkin().equals("V2")) {
            return new RunViewV2(gameController);
        } else if (runView.getSkin().equals("V3")) {
            return new RunViewV3(gameController);
        }
        return null;
    }
    @Override
    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        if (player.getSkin().equals("V1")) {
            return new PlayerViewV1(playerModel);
        } else if (player.getSkin().equals("V2")) {
            return new PlayerViewV2(playerModel);
        } else if (player.getSkin().equals("V3")) {
            return new PlayerViewV3(playerModel);
        } else if (player.getSkin().equals("Vs")) {
            return new SecondPlayerViewV3(playerModel);
        } else if (player.getSkin().equals("AI")) {
            return new AiView(playerModel);
        }
        return null;
    }
    public IPrepareView getPrepareView(Skin prepareView) {
        if (prepareView.getSkin().equals("V1")) {
            return new PrepareViewV1();
        } else if (prepareView.getSkin().equals("V2")) {
            return new PrepareViewV2();
        } else if (prepareView.getSkin().equals("V3")) {
            return new PrepareViewV3();
        }
        return null;
    }
    @Override
    public IWelcomeView getWelcomeView(Skin welcomeVIew) {
        if (welcomeVIew.getSkin().equals("V1")) {
            return new WelComeViewV1();
        } else if (welcomeVIew.getSkin().equals("V2")) {
            return new WelcomeViewV2();
        } else if (welcomeVIew.getSkin().equals("V3")) {
            return new WelcomeViewV3();
        }
        return null;
    }
    @Override
    public ISelectionView getSelectionView(Skin selectionView) {
        if (selectionView.getSkin().equals("V1")) {
            return new SelectionViewV1();
        } else if (selectionView.getSkin().equals("V2")) {
            return new SelectionViewV2();
        } else if (selectionView.getSkin().equals("V3")) {
            return new SelectionViewV3();
        }
        return null;
    }
}
