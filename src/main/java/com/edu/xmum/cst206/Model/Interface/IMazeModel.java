package com.edu.xmum.cst206.Model.Interface;

/*
MazeModel的接口
规定了MazeModel应实现的方法：
1.Rows的get和set方法
2.Cols的get和set方法
3.GoalX和GoalY的get和set方法
4.generateMaze的方法
5.Maze的set和get方法：Maze是用来表示迷宫的一个二维数组，0表示通路，1表示墙壁
 */
public interface IMazeModel {
    int getRows();
    int getCols();
    int getGoalX();
    int getGoalY();
    int getStartX();
    int getStartY();
    int[][] getMaze();
    void setRows(int rows);
    void setCols(int cols);
    void generateMaze();

}
