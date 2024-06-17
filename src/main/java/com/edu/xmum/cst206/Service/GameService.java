package com.edu.xmum.cst206.Service;

import Constant.Difficulty;
import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;

import java.util.List;

public class GameService implements IGameService {
    IGameModel gameModel;
    IMazeService mazeService;
    IPlayerService playerService;
    IAiService aiService;

    public GameService(IGameModel gameModel) {
        this.gameModel = gameModel;
        mazeService = FactoryProducer.getFactory("GameService").getMazeService("Maze",gameModel.getMazeModel());
        playerService = FactoryProducer.getFactory("GameService").getPlayerService("Player",gameModel.getPlayModel(),mazeService);
        aiService = FactoryProducer.getFactory("GameService").getAiService("AI",mazeService,gameModel.getPlayModel(),gameModel.getAiModel());
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getAiModel().setPosition(mazeService.getMaze().getStartX(), mazeService.getMaze().getRows() - 2);
    }

    @Override
    public void resetGame() {
        playerService.reset();
        mazeService.reset();
        aiService.reset();
    }

    @Override
    public boolean movePlayer(Direction direction) {
        return playerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    @Override
    public List<int[]> getHint() {
        return mazeService.getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    //该版本不需要
    @Override
    public boolean moveSecondPlayer(Direction direction) {
        return false;
    }

    //获取子模块的方法
    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }

    @Override
    public IAiService getAiService() {
        return aiService;
    }

    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }

    //该版本不需要
    @Override
    public IPlayerService getSecondPlayerService() {
        return null;
    }

}
