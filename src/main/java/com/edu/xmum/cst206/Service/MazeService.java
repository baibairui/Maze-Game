package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IMazeService;

import java.util.ArrayList;
import java.util.List;

public class MazeService implements IMazeService {
    private IMazeModel maze;

    // 使用依赖注入的方法构造
    public MazeService(IMazeModel mazeModel) {
        this.maze = mazeModel;
    }

    /*
    使用DFS算法来提示迷宫路线
     */
    @Override
    public List<int[]> getPath(int x, int y) {
        /*
        path.get(i)[0]:纵坐标
        path.get(i)[1]:横坐标
         */
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[getMaze().getRows()][getMaze().getCols()];
        int startX = getMaze().getStartX();
        int startY = getMaze().getStartY();
        if (dfs(path, visited, startX, startY)) {
            path.add(new int[]{getMaze().getGoalY(), getMaze().getGoalX()});
        }
        return path;
    }

    private boolean dfs(List<int[]> path, boolean[][] visited, int x, int y) {
        // 如果越界或已经访问过或是墙，则返回 false
        if (x < 0 || x >= getMaze().getCols() || y < 0 || y >= getMaze().getRows() || visited[y][x] || getMaze().getMaze()[y][x] == 1) {
            return false;
        }

        // 标记为已访问
        visited[y][x] = true;

        // 添加当前点到路径
        path.add(new int[]{y, x});

        // 如果到达目标点，则返回 true
        if (x == getMaze().getGoalX() && y == getMaze().getGoalY()) {
            return true;
        }

        // 尝试四个方向的递归调用
        if (dfs(path, visited, x - 1, y) || dfs(path, visited, x + 1, y) || dfs(path, visited, x, y - 1) || dfs(path, visited, x, y + 1)) {
            return true;
        }

        // 如果没有找到路径，回溯并从路径中移除当前点
        path.remove(path.size() - 1);
        return false;
    }
    @Override
    public boolean isValidMove(IPlayerModel player, int dx, int dy) {
        //获取新的坐标
        int newX=(int) (player.getX()+dx);
        int newY=(int) (player.getY()+dy);

        // 检查新的坐标是否在边界内以及是否是通路
        boolean isInBounds = isWithinBounds(newX, newY);
        if (isInBounds) {
            System.out.println("Maze cell value at (" + newX + ", " + newY + "): " + maze.getMaze()[newY][newX]);
        }
        boolean isInMaze = isInBounds && isPath(newX,newY);

        // 调试信息
        System.out.println("Checking move to: (" + newX + ", " + newY + "), isInBounds: " + isInBounds + ", isInMaze: " + isInMaze);
        System.out.println(maze.getRows()+" "+maze.getCols());
        return isInBounds && isInMaze;
    }

    @Override
    public boolean isPath(int x, int y) {
        return maze.getMaze()[y][x] == 0;
    }

    @Override
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < maze.getCols() && y >= 0 && y < maze.getRows();
    }

    @Override
    public boolean hasReachedGoal(IPlayerModel player) {
        return player.getX() == maze.getGoalX() && player.getY() == maze.getGoalY();
    }

    @Override
    public void reset() {
        maze.generateMaze();
    }

    @Override
    public IMazeModel getMaze() {
        return maze;
    }
}
