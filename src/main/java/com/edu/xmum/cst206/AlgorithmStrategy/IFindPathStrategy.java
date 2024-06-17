package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

public interface IFindPathStrategy {
    boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY);
}
