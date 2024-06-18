package com.edu.xmum.cst206.Service;

import Constant.Difficulty;
import Constant.Direction;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;

import java.util.List;

public class GameServiceVs implements IGameService {
    IGameModel gameModel;
    IMazeService mazeService;
    IPlayerService playerService;
    IPlayerService secondPlayerService;


    public GameServiceVs(IGameModel gameModel) {
        this.gameModel = gameModel;
        mazeService = FactoryProducer.getFactory("GameService").getMazeService("Maze",gameModel.getMazeModel());
        playerService = FactoryProducer.getFactory("GameService").getPlayerService("Player",gameModel.getPlayModel(),mazeService);
        secondPlayerService = FactoryProducer.getFactory("GameService").getPlayerService("Player",gameModel.getSecondPlayModel(),mazeService);
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getSecondPlayModel().setPosition(gameModel.getMazeModel().getStartX(),gameModel.getMazeModel().getStartY());

    }

    @Override
    public void resetGame() {
        playerService.reset();
        secondPlayerService.reset();
        mazeService.reset();
    }

    @Override
    public boolean movePlayer(Direction direction) {
        return playerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    @Override
    public boolean moveSecondPlayer(Direction direction) {
        return secondPlayerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    @Override
    public List<int[]> getHint() {
        return mazeService.getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    //Methods to get submodules
    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }

    @Override
    public IAiService getAiService() {
        return null;
    }

    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }

    //This version requires the design of a two-player game
    @Override
    public IPlayerService getSecondPlayerService() {
        return secondPlayerService;
    }
}
