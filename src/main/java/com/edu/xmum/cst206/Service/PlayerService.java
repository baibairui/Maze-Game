package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

/**
 * Implementation of the IPlayerService interface.
 * Provides methods for player-related operations within the maze.
 */
public class PlayerService implements IPlayerService {
    private IPlayerModel player;
    private IMazeService mazeService;

    /**
     * Constructor for PlayerService.
     * Uses dependency injection to initialize the player and maze services.
     *
     * @param maze The maze service instance.
     * @param playerModel The player model instance.
     */
    public PlayerService(IMazeService maze, IPlayerModel playerModel) {
        this.player = playerModel;
        this.mazeService = maze;
    }

    /**
     * Checks if the move is valid and moves the player.
     *
     * @param dx The delta x value for the move.
     * @param dy The delta y value for the move.
     * @return True if the move is valid and the player is moved, false otherwise.
     */
    @Override
    public boolean movePlayer(int dx, int dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
            System.out.println("X: " + player.getX() + " Y: " + player.getY());
            return checkGoal(); // Returns whether or not the end point has been reached
        }
        return false; // Invalid move
    }

    /**
     * Checks if the player has reached the goal.
     *
     * @return True if the player has reached the goal, false otherwise.
     */
    @Override
    public boolean checkGoal() {
        return mazeService.hasReachedGoal(player);
    }

    /**
     * Gets the Player model instance.
     *
     * @return The Player model instance.
     */
    @Override
    public IPlayerModel getPlayer() {
        return player;
    }

    /**
     * Resets the player's position to the starting point.
     */
    @Override
    public void reset() {
        player.setPosition(player.getStartX(), player.getStartY());
    }

    /**
     * Gets the maze model associated with the player.
     *
     * @return The maze model.
     */
    @Override
    public IMazeModel getMaze() {
        return mazeService.getMaze();
    }
}
