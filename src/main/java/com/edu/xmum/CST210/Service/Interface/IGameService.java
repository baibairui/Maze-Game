package com.edu.xmum.CST210.Service.Interface;

import Constant.Difficulty;
import Constant.Direction;

import java.util.List;

/**
 * Interface for the game service.
 * Specifies the methods that the game service should implement.
 * These include methods for setting difficulty, resetting the game, moving players, getting submodules, and providing path hints.
 */
public interface IGameService {
    /**
     * Sets the game difficulty.
     *
     * @param difficulty The difficulty level to set.
     */
    void setDifficulty(Difficulty difficulty);

    /**
     * Resets the game to its initial state.
     */
    void resetGame();

    /**
     * Moves the player in the specified direction.
     *
     * @param direction The direction to move the player.
     * @return True if the player reached the goal, false otherwise.
     */
    boolean movePlayer(Direction direction);

    /**
     * Gets the player service submodule.
     *
     * @return The player service.
     */
    IPlayerService getPlayerService();

    /**
     * Gets the AI service submodule.
     *
     * @return The AI service.
     */
    IAiService getAiService();

    /**
     * Gets the maze service submodule.
     *
     * @return The maze service.
     */
    IMazeService getMazeService();

    /**
     * Gets the second player service submodule.
     *
     * @return The second player service.
     */
    IPlayerService getSecondPlayerService();

    /**
     * Provides path hints for the player.
     *
     * @return A list of coordinates representing the hint path.
     */
    List<int[]> getHint();

    /**
     * Moves the second player in the specified direction.
     *
     * @param direction The direction to move the second player.
     * @return True if the second player reached the goal, false otherwise.
     */
    boolean moveSecondPlayer(Direction direction);
}
