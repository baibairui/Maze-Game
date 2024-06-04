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
    public boolean isValidMove(Player player,double dx,double dy){
        //获取新的坐标
        double newX= player.getX()+dx;
        double newY=player.getY()+dy;
        double radius=player.getRadius();

        //检查边际坐标
        int leftX=(int)(newX-radius);//左边界
        int rightX = (int) (newX + radius);//右边界
        int topY = (int) (newY - radius);//上边界
        int bottomY = (int) (newY + radius);//下边界
        boolean isInBounds=isWithinBounds(leftX, topY) && isWithinBounds(rightX, topY) &&
                isWithinBounds(leftX, bottomY) && isWithinBounds(rightX, bottomY);//检查是否在边界内
        boolean isInMaze=maze.getMaze()[leftX][topY] == 0 && maze.getMaze()[rightX][topY] == 0 &&
                maze.getMaze()[leftX][bottomY] == 0 && maze.getMaze()[rightX][bottomY] == 0;//检查是否是墙

        // 确保新的坐标在迷宫边界内并且不是墙
        return  isInBounds&&isInMaze;
    }
    // 检查坐标是否在迷宫边界内
    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getCols();
    }
    // 检查玩家是否到达终点
    public boolean hasReachedGoal(Player player) {
        return player.getX() == maze.getRows() - 2 && player.getY() == maze.getCols() - 1;
    }
}

