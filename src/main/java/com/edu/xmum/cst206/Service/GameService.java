package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;

public class GameService implements IGameService {
    IGameModel gameModel;
    IMazeService mazeService;
    IPlayerService playerService;
    IGameController gameController;
    public GameService(IGameModel gameModel){
        this.gameModel=gameModel;
        mazeService=new MazeService(gameModel.getMazeModel());
        playerService=new PlayerService(mazeService,gameModel.getPlayModel());
    }
    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getMazeModel().generateMaze();
    }

    @Override
    public void resetGame() {
        playerService.reset();
        mazeService.reset();
    }

    @Override
    public boolean checkGoal() {
        return playerService.checkGoal();
    }

    @Override
    public boolean movePlayer(Direction direction) {
       return playerService.movePlayer(direction.getDirectionX(),direction.getDirectionY());
    }

    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }

    @Override
    public void setGameController(IGameController gameController) {
        this.gameController=gameController;
    }

    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }
}
