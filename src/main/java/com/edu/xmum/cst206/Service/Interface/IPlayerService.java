package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

/**
 * Interface for PlayerService.
 * Specifies the methods that the PlayerService should implement.
 */
public interface IPlayerService {
    /**
     * Checks if the move is valid and moves the player.
     *
     * @param dx The delta x value for the move.
     * @param dy The delta y value for the move.
     * @return True if the move is valid and the player is moved, false otherwise.
     */
    boolean movePlayer(int dx, int dy);

    /**
     * Checks if the player has reached the goal.
     *
     * @return True if the player has reached the goal, false otherwise.
     */
    boolean checkGoal();

    /**
     * Gets the Player model instance.
     *
     * @return The Player model instance.
     */
    IPlayerModel getPlayer();

    /**
     * Resets the player's position to the starting point.
     */
    void reset();

    /**
     * Gets the maze model associated with the player.
     *
     * @return The maze model.
     */
    IMazeModel getMaze();
}
