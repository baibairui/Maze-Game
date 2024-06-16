package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
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
        mazeService = new MazeService(gameModel.getMazeModel());
        playerService = new PlayerService(mazeService, gameModel.getPlayModel());
        secondPlayerService=new PlayerService(mazeService,gameModel.getSecondPlayModel());
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getSecondPlayModel().setPosition(mazeService.getMaze().getStartX(),mazeService.getMaze().getRows()-2);
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
        return secondPlayerService.movePlayer(direction.getDirectionX(),direction.getDirectionY());
    }

    @Override
    public List<int[]> getHint() {
        return mazeService.getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    //获取子模块的方法
    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }
    @Override
    public IAiService getAiService(){return null;}
    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }
    //该版本需要设计双人游戏
    @Override
    public IPlayerService getSecondPlayerService() {
        return secondPlayerService;
    }
}
