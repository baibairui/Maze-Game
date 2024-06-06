package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;

/*
用于处理地图的相关逻辑
 */
public class MazeService {
    private Maze maze;
    public MazeService(Maze maze){
        this.maze=maze;
    }
    //处理玩家是否碰壁的问题
    public boolean isValidMove(Player player,int dx,int dy){
        //获取新的坐标
        int newX=(int) (player.getX()+dx);
        int newY=(int) (player.getY()+dy);

        // 检查新的坐标是否在边界内以及是否是通路
        boolean isInBounds = isWithinBounds(newX, newY);
        if (isInBounds) {
            System.out.println("Maze cell value at (" + newX + ", " + newY + "): " + maze.getMaze()[newY][newX]);
        }
        boolean isInMaze = isInBounds && maze.getMaze()[newY][newX] == 0;

        // 调试信息
        System.out.println("Checking move to: (" + newX + ", " + newY + "), isInBounds: " + isInBounds + ", isInMaze: " + isInMaze);
        System.out.println(maze.getRows()+" "+maze.getCols());
        return isInBounds && isInMaze;
    }
    // 检查坐标是否在迷宫边界内
    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < maze.getCols() && y >= 0 && y < maze.getRows();
    }

    // 检查玩家是否到达终点
    public boolean hasReachedGoal(Player player) {
        return  player.getX() == maze.getRows() - 1 &&  player.getY() == maze.getCols() -2;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}

