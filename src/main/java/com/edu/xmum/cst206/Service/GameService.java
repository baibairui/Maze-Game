package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.GameModel;

import java.util.HashMap;
import java.util.Map;

import static com.edu.xmum.cst206.Model.ConstantConfig.*;

public class GameService {
    private GameController gameController;
    private GameModel gameModel;
    private MazeService mazeService;
    private PlayerService playerService;

    public GameService(GameModel gameModel) {
        this.gameModel=gameModel;
        this.mazeService=new MazeService(gameModel.getMaze());
        this.playerService=new PlayerService(gameModel.getPlayer(),this.mazeService);
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public MazeService getMazeService() {
        return mazeService;
    }

    public void setMazeService(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Map<String,Integer> setDifficulty(String difficulty) {
        int newRows=0,newCols = 0;
        Map<String,Integer>newParm=new HashMap<>();
        if(difficulty.equals("Hard")){
            newRows=HARD;
            newCols=HARD;
        }else if(difficulty.equals("Medium")){
            newRows=MEDIUM;
            newCols=MEDIUM;
        }else if(difficulty.equals("Easy")){
            newRows=EASY;
            newCols=EASY;
        }
        resetMaze(newRows,newCols);
        newParm.put("NEWROWS",newRows);
        newParm.put("NEWCOLS",newCols);
        newParm.put("CELLSIZE",getMazeService().getMaze().getWidth());
        return newParm;
    }
    public void resetMaze(int newRows,int newCols){
        this.getGameModel().getMaze().setCols(newCols);
        this.getGameModel().getMaze().setRows(newRows);
        this.getGameModel().getMaze().setMaze(new int[newRows][newCols]);
        this.getGameModel().getMaze().generateMazePrim();

    }
    //重新开始游戏的逻辑
    public void resetGame() {
        this.getGameModel().getMaze().generateMazePrim();
    }


    //提供游戏提示的逻辑
    public void provideHint() {
    }
}
