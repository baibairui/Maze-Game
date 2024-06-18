package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

/**
 * Context class for pathfinding strategy.
 * This class is used to select and execute different pathfinding algorithms.
 */
public class PathfindingContext {
    private final IFindPathStrategy strategy;

    /**
     * Constructor to set the pathfinding strategy.
     *
     * @param strategy The pathfinding strategy to be used.
     */
    public PathfindingContext(IFindPathStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Finds a path from the starting position to the goal position using the selected strategy.
     *
     * @param mazeModel The maze model containing the maze structure.
     * @param path      A list to store the path found from start to goal.
     * @param visited   A 2D boolean array to keep track of visited positions in the maze.
     * @param x         The x-coordinate of the current position.
     * @param y         The y-coordinate of the current position.
     * @param goalX     The x-coordinate of the goal position.
     * @param goalY     The y-coordinate of the goal position.
     * @return True if a path is found, false otherwise.
     */
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        return strategy.findPath(mazeModel, path, visited, x, y, goalX, goalY);
    }
}
