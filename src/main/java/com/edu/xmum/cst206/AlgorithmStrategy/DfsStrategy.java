package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

/**
 * Implementation of the depth-first search (DFS) strategy for pathfinding in a maze.
 * This class uses a DFS algorithm to find a path from the starting position to the goal position without recording the backtracking process.
 */
public class DfsStrategy implements IFindPathStrategy {

    /**
     * Finds a path using DFS without recording the backtracking process.
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
    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // Returns false if it is out of bounds or has already been accessed or is walled.
        if (x < 0 || x >= mazeModel.getCols() || y < 0 || y >= mazeModel.getRows() || visited[y][x] || mazeModel.getMaze()[y][x] == 1) {
            return false;
        }

        // Mark the current cell as visited
        visited[y][x] = true;

        // Add the current point to the path
        path.add(new int[]{y, x});

        // Returns true if the target point is reached
        if (x == goalX && y == goalY) {
            return true;
        }

        // Try recursive calls in all four directions
        if (findPath(mazeModel, path, visited, x - 1, y, goalX, goalY) ||
                findPath(mazeModel, path, visited, x + 1, y, goalX, goalY) ||
                findPath(mazeModel, path, visited, x, y - 1, goalX, goalY) ||
                findPath(mazeModel, path, visited, x, y + 1, goalX, goalY)) {
            return true;
        }

        // If no path is found, backtrack and remove the current point from the path
        path.remove(path.size() - 1);

        return false;
    }
}
