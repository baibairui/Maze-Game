package com.edu.xmum.cst206.Model.Interface;

/*
Interfaces for MazeModel
Specifies the methods that the MazeModel should implement:
1.Rows get and set methods
2. Cols get and set methods
3. GoalX and GoalY get and set methods
4. generateMaze: the method used to generate the maze, here we use the randomised prim algorithm to generate the
5. Maze set and get methods: Maze is used to represent the maze of a two-dimensional array, 0 means access, 1 means that the wall
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
