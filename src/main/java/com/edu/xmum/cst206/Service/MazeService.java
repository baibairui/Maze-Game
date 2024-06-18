package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.AlgorithmStrategy.DfsStrategy;
import com.edu.xmum.cst206.AlgorithmStrategy.PathfindingContext;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IMazeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IMazeService interface.
 * Provides methods to handle maze-related logic.
 */
public class MazeService implements IMazeService {
    private final IMazeModel maze;

    /**
     * Constructor for MazeService.
     * Uses dependency injection to initialize the maze model.
     *
     * @param mazeModel The maze model instance.
     */
    public MazeService(IMazeModel mazeModel) {
        this.maze = mazeModel;
    }

    /**
     * Provides a hint for the maze path using the DFS algorithm.
     *
     * @param x The starting x coordinate.
     * @param y The starting y coordinate.
     * @return A list of coordinate pairs representing the path to the goal.
     */
    @Override
    public List<int[]> getPath(int x, int y) {
        /*
        path.get(i)[0]: vertical coordinate
        path.get(i)[1]: horizontal coordinate
         */
        List<int[]> hintPath = new ArrayList<>();
        boolean[][] visited = new boolean[getMaze().getRows()][getMaze().getCols()];
        int startX = getMaze().getStartX();
        int startY = getMaze().getStartY();

        // Finding Answers Using the DFS Algorithm
        PathfindingContext findPath = new PathfindingContext(new DfsStrategy());
        findPath.findPath(maze, hintPath, visited, startX, startY, maze.getGoalX(), maze.getGoalY());
        return hintPath;
    }

    /**
     * Checks if the player's move to the specified direction (dx, dy) is valid within the maze.
     *
     * @param player The player model instance.
     * @param dx     The delta x value for the move.
     * @param dy     The delta y value for the move.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(IPlayerModel player, int dx, int dy) {
        // Get new coordinates
        int newX =  player.getX() + dx;
        int newY =  player.getY() + dy;

        // Checks if the new coordinates are within the boundary and if it is a pathway
        boolean isInBounds = isWithinBounds(newX, newY);
        if (isInBounds) {
            System.out.println("Maze cell value at (" + newX + ", " + newY + "): " + maze.getMaze()[newY][newX]);
        }
        boolean isInMaze = isInBounds && isPath(newX, newY);

        // Debugging Information
        System.out.println("Checking move to: (" + newX + ", " + newY + "), isInBounds: " + isInBounds + ", isInMaze: " + isInMaze);
        System.out.println(maze.getRows() + " " + maze.getCols());
        return isInBounds && isInMaze;
    }

    /**
     * Checks if the specified coordinates (x, y) are a path and not a wall.
     *
     * @param x The x coordinate to check.
     * @param y The y coordinate to check.
     * @return True if the coordinates represent a path, false otherwise.
     */
    @Override
    public boolean isPath(int x, int y) {
        return maze.getMaze()[y][x] == 0;
    }

    /**
     * Checks if the specified coordinates (x, y) are within the maze boundaries.
     *
     * @param x The x coordinate to check.
     * @param y The y coordinate to check.
     * @return True if the coordinates are within bounds, false otherwise.
     */
    @Override
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < maze.getCols() && y >= 0 && y < maze.getRows();
    }

    /**
     * Checks if the player has reached the goal position in the maze.
     *
     * @param player The player model instance.
     * @return True if the player has reached the goal, false otherwise.
     */
    @Override
    public boolean hasReachedGoal(IPlayerModel player) {
        return player.getX() == maze.getGoalX() && player.getY() == maze.getGoalY();
    }

    /**
     * Resets the maze to its initial state by generating a new maze.
     */
    @Override
    public void reset() {
        maze.generateMaze();
    }

    /**
     * Gets the current maze model instance.
     *
     * @return The maze model instance.
     */
    @Override
    public IMazeModel getMaze() {
        return maze;
    }
}
