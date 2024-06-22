package com.edu.xmum.CST210.Model.Interface;

/**
 * Interface for MazeModel.
 * Specifies the methods that the MazeModel should implement.
 * These include methods for getting and setting rows, columns, goal coordinates,
 * and methods for generating and accessing the maze structure.
 */
public interface IMazeModel {
    /**
     * Gets the number of rows in the maze.
     *
     * @return The number of rows.
     */
    int getRows();

    /**
     * Sets the number of rows in the maze.
     *
     * @param rows The number of rows to set.
     */
    void setRows(int rows);

    /**
     * Gets the number of columns in the maze.
     *
     * @return The number of columns.
     */
    int getCols();

    /**
     * Sets the number of columns in the maze.
     *
     * @param cols The number of columns to set.
     */
    void setCols(int cols);

    /**
     * Gets the x-coordinate of the goal position in the maze.
     *
     * @return The x-coordinate of the goal.
     */
    int getGoalX();

    /**
     * Gets the y-coordinate of the goal position in the maze.
     *
     * @return The y-coordinate of the goal.
     */
    int getGoalY();

    /**
     * Gets the x-coordinate of the start position in the maze.
     *
     * @return The x-coordinate of the start.
     */
    int getStartX();

    /**
     * Gets the y-coordinate of the start position in the maze.
     *
     * @return The y-coordinate of the start.
     */
    int getStartY();

    /**
     * Gets the maze structure as a two-dimensional array.
     * 0 means the cell is accessible, 1 means the cell is a wall.
     *
     * @return The maze structure.
     */
    int[][] getMaze();

    /**
     * Generates the maze using the randomized Prime's algorithm.
     */
    void generateMaze();
}
