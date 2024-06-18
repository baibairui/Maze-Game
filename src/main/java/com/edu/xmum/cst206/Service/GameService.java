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
 * Implementation of the IGameService interface.
 * Provides methods to manage and control the game state and its components.
 */
public class GameService implements IGameService {
    final IGameModel gameModel;
    final IMazeService mazeService;
    final IPlayerService playerService;
    final IAiService aiService;

    /**
     * Constructor for GameService.
     * Uses the factory pattern to initialize the maze, player, and AI services.
     *
     * @param gameModel The game model instance.
     */
    public GameService(IGameModel gameModel) {
        this.gameModel = gameModel;
        mazeService = FactoryProducer.getFactory("GameService").getMazeService("Maze", gameModel.getMazeModel());
        playerService = FactoryProducer.getFactory("GameService").getPlayerService("Player", gameModel.getPlayModel(), mazeService);
        aiService = FactoryProducer.getFactory("GameService").getAiService("AI", mazeService, gameModel.getPlayModel(), gameModel.getAiModel());
    }

    /**
     * Sets the game difficulty by adjusting the maze size and AI position.
     *
     * @param difficulty The difficulty level to set.
     */
    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
        gameModel.getAiModel().setPosition(mazeService.getMaze().getStartX(), mazeService.getMaze().getRows() - 2);
    }

    /**
     * Resets the game to its initial state, including player, maze, and AI.
     */
    @Override
    public void resetGame() {
        playerService.reset();
        mazeService.reset();
        aiService.reset();
    }

    /**
     * Moves the player in the specified direction.
     *
     * @param direction The direction to move the player.
     * @return True if the move is valid and the player is moved, false otherwise.
     */
    @Override
    public boolean movePlayer(Direction direction) {
        return playerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    /**
     * Provides a hint for the player by returning the path to the goal.
     *
     * @return A list of coordinate pairs representing the path to the goal.
     */
    @Override
    public List<int[]> getHint() {
        return mazeService.getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    /**
     * This version does not require a second player.
     *
     * @param direction The direction to move the second player.
     * @return False as second player functionality is not required.
     */
    @Override
    public boolean moveSecondPlayer(Direction direction) {
        return false;
    }

    /**
     * Gets the player service instance.
     *
     * @return The player service instance.
     */
    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }

    /**
     * Gets the AI service instance.
     *
     * @return The AI service instance.
     */
    @Override
    public IAiService getAiService() {
        return aiService;
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
     * This version does not require a second player.
     *
     * @return Null as second player functionality is not required.
     */
    @Override
    public IPlayerService getSecondPlayerService() {
        return null;
    }
}
