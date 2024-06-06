package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.GameModel;
import com.edu.xmum.cst206.Model.GameObject;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;

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

    public void setDifficulty(String difficulty) {
        if(difficulty.equals("Hard")){
            this.getGameModel().getMaze().setCols(HARD);
            this.getGameModel().getMaze().setRows(HARD);

        }else if(difficulty.equals("Medium")){
            this.getGameModel().getMaze().setRows(MEDIUM);
            this.getGameModel().getMaze().setCols(MEDIUM);
        }else if(difficulty.equals("Easy")){
            this.getGameModel().getMaze().setCols(EASY);
            this.getGameModel().getMaze().setRows(EASY);
        }
    }
    //重新开始游戏的逻辑
    public void resetGame() {
        this.getGameModel().getMaze().generateMazePrim();
    }


    //提供游戏提示的逻辑
    public void provideHint() {
    }
}
