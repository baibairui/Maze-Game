package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

/*
Strategy mode Select different algorithms
 */
public class PathfindingContext {
    private IFindPathStrategy strategy;

    public PathfindingContext(IFindPathStrategy strategy) {
        this.strategy = strategy;
    }


    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        return strategy.findPath(mazeModel, path, visited, x, y, goalX, goalY);
    }
}
