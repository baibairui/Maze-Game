package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

public class DfsStrategy implements IFindPathStrategy {

    /*
     DFS without recording the backtracking process
      */
    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // Returns false if it is out of bounds or has already been accessed or walled.
        if (x < 0 || x >= mazeModel.getCols() || y < 0 || y >= mazeModel.getRows() || visited[y][x] || mazeModel.getMaze()[y][x] == 1) {
            return false;
        }

        // Marked as visited
        visited[y][x] = true;

        // Add the current point to the path
        path.add(new int[]{y, x});

        // Returns true if the target point is reached
        if (x == goalX && y == goalY) {
            return true;
        }

        // Try recursive calls in all four directions
        if (findPath(mazeModel, path, visited, x - 1, y, goalX, goalY) || findPath(mazeModel, path, visited, x + 1, y, goalX, goalY) || findPath(mazeModel, path, visited, x, y - 1, goalX, goalY) || findPath(mazeModel, path, visited, x, y + 1, goalX, goalY)) {
            return true;
        }

        // If no path is found, backtrack and remove the current point from the path
        path.remove(path.size() - 1);

        return false;
    }

}
