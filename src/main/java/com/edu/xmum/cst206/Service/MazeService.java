package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
public class MazeService implements IMazeService {
    private IMazeModel maze;

    // 使用依赖注入的方法构造
    public MazeService(IMazeModel mazeModel) {
        this.maze = mazeModel;
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
