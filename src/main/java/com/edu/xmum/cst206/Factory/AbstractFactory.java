package com.edu.xmum.cst206.Factory;

import Constant.Skin;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;
import com.edu.xmum.cst206.View.Interface.*;

public abstract class AbstractFactory {

    /**
     * Abstract method to get the maze view.
     * @param maze Skin enumeration.
     * @param mazeModel Maze model.
     * @return Maze view.
     */
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        return null;
    }

    /**
     * Abstract method to get the player view.
     * @param player Skin enumeration.
     * @param playerModel Player model.
     * @return Player view.
     */
    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        return null;
    }

    /**
     * Abstract method to get the prepare view.
     * @param prepareView Skin enumeration.
     * @return Prepare view.
     */
    public IPrepareView getPrepareView(Skin prepareView) {
        return null;
    }

    /**
     * Abstract method to get the run view.
     * @param runView Skin enumeration.
     * @param gameController Game controller.
     * @return Run view.
     */
    public IRunView getRunView(Skin runView, IGameController gameController) {
        return null;
    }

    /**
     * Abstract method to get the selection view.
     * @param selectionView Skin enumeration.
     * @return Selection view.
     */
    public ISelectionView getSelectionView(Skin selectionView) {
        return null;
    }

    /**
     * Abstract method to get the victory view.
     * @param victoryView Skin enumeration.
     * @return Victory view.
     */
    public IVictoryView getVictoryView(Skin victoryView) {
        return null;
    }

    /**
     * Abstract method to get the welcome view.
     * @param welcomeView Skin enumeration.
     * @return Welcome view.
     */
    public IWelcomeView getWelcomeView(Skin welcomeView) {
        return null;
    }

    /**
     * Abstract method to get the game model.
     * @param playerModel Skin enumeration.
     * @return Game model.
     */
    public IGameModel getGameModel(Skin playerModel) {
        return null;
    }

    /**
     * Abstract method to get the game service.
     * @param gameService Skin enumeration.
     * @param gameModel Game model.
     * @return Game service.
     */
    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        return null;
    }

    /**
     * Abstract method to get the game controller.
     * @param gameController Skin enumeration.
     * @param gameService Game service.
     * @return Game controller.
     */
    public IGameController getGameController(Skin gameController, IGameService gameService) {
        return null;
    }

    /**
     * Abstract method to get the maze model.
     * @param maze Maze identifier.
     * @return Maze model.
     */
    public IMazeModel getMazeModel(String maze) {
        return null;
    }

    /**
     * Abstract method to get the player model.
     * @param player Player identifier.
     * @param mazeModel Maze model.
     * @return Player model.
     */
    public IPlayerModel getPlayerModel(String player, IMazeModel mazeModel) {
        return null;
    }

    /**
     * Abstract method to get the player service.
     * @param vision Vision identifier.
     * @param playerModel Player model.
     * @param mazeService Maze service.
     * @return Player service.
     */
    public IPlayerService getPlayerService(String vision, IPlayerModel playerModel, IMazeService mazeService) {
        return null;
    }

    /**
     * Abstract method to get the maze service.
     * @param vision Vision identifier.
     * @param mazeModel Maze model.
     * @return Maze service.
     */
    public IMazeService getMazeService(String vision, IMazeModel mazeModel) {
        return null;
    }

    /**
     * Abstract method to get the AI service.
     * @param vision Vision identifier.
     * @param mazeService Maze service.
     * @param playerModel Player model.
     * @param aiModel AI model.
     * @return AI service.
     */
    public IAiService getAiService(String vision, IMazeService mazeService, IPlayerModel playerModel, IPlayerModel aiModel) {
        return null;
    }
}
