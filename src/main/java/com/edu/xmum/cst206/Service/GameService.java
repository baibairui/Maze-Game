package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.GameModel;
import com.edu.xmum.cst206.Model.GameObject;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;

public class GameService {
    private GameController gameController;
    private GameModel gameModel;
    private MazeService mazeService;
    private PlayerService playerService;

    public GameService(GameController gameController, GameModel gameModel) {
        this.gameController = gameController;
        this.gameModel = gameModel;
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
}
