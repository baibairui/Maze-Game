package com.edu.xmum.CST210.Service.Interface;

import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;

import java.util.List;

/**
 * Interface for MazeService.
 * Specifies the methods that the MazeService should implement.
 */
public interface IMazeService {

    /**
     * Checks if the player's move to the specified direction (dx, dy) is valid within the maze.
     *
     * @param player The player model instance.
     * @param dx     The delta x value for the move.
     * @param dy     The delta y value for the move.
     * @return True if the move is valid, false otherwise.
     */
    boolean isValidMove(IPlayerModel player, int dx, int dy);

    /**
     * Checks if the specified coordinates (x, y) are within the maze boundaries.
     *
     * @param x The x coordinate to check.
     * @param y The y coordinate to check.
     * @return True if the coordinates are within bounds, false otherwise.
     */
    boolean isWithinBounds(int x, int y);

    /**
     * Checks if the specified coordinates (X, Y) are a path and not a wall.
     *
     * @param X The x coordinate to check.
     * @param Y The y coordinate to check.
     * @return True if the coordinates represent a path, false otherwise.
     */
    boolean isPath(int X, int Y);

    /**
     * Checks if the player has reached the goal position in the maze.
     *
     * @param player The player model instance.
     * @return True if the player has reached the goal, false otherwise.
     */
    boolean hasReachedGoal(IPlayerModel player);

    /**
     * Resets the maze to its initial state.
     */
    void reset();

    /**
     * Gets the current maze model instance.
     *
     * @return The maze model instance.
     */
    IMazeModel getMaze();

    /**
     * Gets the path from the current position (x, y) to the goal as a list of coordinate pairs.
     *
     * @param x The starting x coordinate.
     * @param y The starting y coordinate.
     * @return The list of coordinate pairs representing the path.
     */
    List<int[]> getPath(int x, int y);

    void initializeMaze(String mazeData);
}
