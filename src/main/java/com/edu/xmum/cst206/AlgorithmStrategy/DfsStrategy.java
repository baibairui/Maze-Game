package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

public class DfsStrategy implements IFindPathStrategy {

    /*
     不记录回溯过程的DFS
      */
    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // 如果越界或已经访问过或是墙，则返回 false
        if (x < 0 || x >= mazeModel.getCols() || y < 0 || y >= mazeModel.getRows() || visited[y][x] || mazeModel.getMaze()[y][x] == 1) {
            return false;
        }

        // 标记为已访问
        visited[y][x] = true;

        // 添加当前点到路径
        path.add(new int[]{y, x});

        // 如果到达目标点，则返回 true
        if (x == goalX && y == goalY) {
            return true;
        }

        // 尝试四个方向的递归调用
        if (findPath(mazeModel, path, visited, x - 1, y, goalX, goalY) || findPath(mazeModel, path, visited, x + 1, y, goalX, goalY) || findPath(mazeModel, path, visited, x, y - 1, goalX, goalY) || findPath(mazeModel, path, visited, x, y + 1, goalX, goalY)) {
            return true;
        }

        // 如果没有找到路径，回溯并从路径中移除当前点
        path.remove(path.size() - 1);

        return false;
    }

}
