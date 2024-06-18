package com.edu.xmum.cst206.Factory;

import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.*;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;

public class GameServiceFactory extends AbstractFactory {
    @Override
    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        if (gameService.getSkin().equals("V3")) {
            return new GameServiceVs(gameModel);
        } else {
            return new GameService(gameModel);
        }
    }

    @Override
    public IPlayerService getPlayerService(String vision, IPlayerModel playerModel, IMazeService mazeService) {
        if (vision.equals("Player")) {
            return new PlayerService(mazeService, playerModel);
        }
        return null;
    }

    @Override
    public IAiService getAiService(String vision, IMazeService mazeService, IPlayerModel playModel, IPlayerModel aiModel) {
        if (vision.equals("AI")) {
            return new AiService(mazeService, playModel, aiModel);
        }
        return null;
    }

    @Override
    public IMazeService getMazeService(String vision, IMazeModel mazeModel) {
        if (vision.equals("Maze")) {
            return new MazeService(mazeModel);
        }
        return null;
    }
}
