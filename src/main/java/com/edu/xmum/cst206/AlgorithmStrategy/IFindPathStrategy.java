package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import java.util.List;

/**
 * Interface for pathfinding strategy in a maze.
 * This interface defines the method for finding a path in a maze model.
 */
public interface IFindPathStrategy {

    /**
     * Finds a path from the starting position to the goal position in the given maze model.
     *
     * @param mazeModel The maze model containing the maze structure.
     * @param path A list to store the path found from start to goal.
     * @param visited A 2D boolean array to keep track of visited positions in the maze.
     * @param x The x-coordinate of the current position.
     * @param y The y-coordinate of the current position.
     * @param goalX The x-coordinate of the goal position.
     * @param goalY The y-coordinate of the goal position.
     * @return True if a path is found, false otherwise.
     */
    boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY);
}
