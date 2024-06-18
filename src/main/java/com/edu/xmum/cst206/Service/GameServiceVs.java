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

/**
 * Implementation of the IGameService interface for a two-player game.
 * Provides methods to manage and control the game state and its components.
 */
public class GameServiceVs implements IGameService {
    final IGameModel gameModel;
    final IMazeService mazeService;
    final IPlayerService playerService;
    final IPlayerService secondPlayerService;

    /**
     * Constructor for GameServiceVs.
     * Uses the factory pattern to initialize the maze, player, and second player services.
     *
     * @param gameModel The game model instance.
     */
    public GameServiceVs(IGameModel gameModel) {
        this.gameModel = gameModel;
        mazeService = FactoryProducer.getFactory("GameService").getMazeService("Maze", gameModel.getMazeModel());
        playerService = FactoryProducer.getFactory("GameService").getPlayerService("Player", gameModel.getPlayModel(), mazeService);
        secondPlayerService = FactoryProducer.getFactory("GameService").getPlayerService("Player", gameModel.getSecondPlayModel(), mazeService);
    }

    /**
     * Sets the game difficulty by adjusting the maze size and second player's start position.
     *
     * @param difficulty The difficulty level to set.
     */
    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getSecondPlayModel().setPosition(gameModel.getMazeModel().getStartX(), gameModel.getMazeModel().getStartY());
    }

    /**
     * Resets the game to its initial state, including players and maze.
     */
    @Override
    public void resetGame() {
        playerService.reset();
        secondPlayerService.reset();
        mazeService.reset();
    }

    /**
     * Moves the first player in the specified direction.
     *
     * @param direction The direction to move the first player.
     * @return True if the move is valid and the first player is moved, false otherwise.
     */
    @Override
    public boolean movePlayer(Direction direction) {
        return playerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    /**
     * Moves the second player in the specified direction.
     *
     * @param direction The direction to move the second player.
     * @return True if the move is valid and the second player is moved, false otherwise.
     */
    @Override
    public boolean moveSecondPlayer(Direction direction) {
        return secondPlayerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    /**
     * Provides a hint for the players by returning the path to the goal.
     *
     * @return A list of coordinate pairs representing the path to the goal.
     */
    @Override
    public List<int[]> getHint() {
        return mazeService.getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    /**
     * Gets the first player service instance.
     *
     * @return The first player service instance.
     */
    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }

    /**
     * This version does not use AI services.
     *
     * @return Null as AI functionality is not required.
     */
    @Override
    public IAiService getAiService() {
        return null;
    }

    /**
     * Gets the maze service instance.
     *
     * @return The maze service instance.
     */
    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }

    /**
     * Gets the second player service instance.
     *
     * @return The second player service instance.
     */
    @Override
    public IPlayerService getSecondPlayerService() {
        return secondPlayerService;
    }
}
