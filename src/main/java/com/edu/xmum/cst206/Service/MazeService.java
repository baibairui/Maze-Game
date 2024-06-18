package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.AlgorithmStrategy.DfsStrategy;
import com.edu.xmum.cst206.AlgorithmStrategy.PathfindingContext;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IMazeService;

import java.util.ArrayList;
import java.util.List;


public class MazeService implements IMazeService {
    private IMazeModel maze;

    // Methods constructed using dependency injection
    public MazeService(IMazeModel mazeModel) {
        this.maze = mazeModel;
    }

    /*
    Using the DFS algorithm to hint at maze routes
     */
    @Override
    public List<int[]> getPath(int x, int y) {
        /*
        path.get(i)[0]:vertical coordinate
        path.get(i)[1]:horizontal coordinate
         */
        List<int[]> path = new ArrayList<>();
        List<int[]> back = new ArrayList<>();
        boolean[][] visited = new boolean[getMaze().getRows()][getMaze().getCols()];
        int startX = getMaze().getStartX();
        int startY = getMaze().getStartY();

        List<int[]> hintPath = new ArrayList<>();
        //Finding Answers Using the DFS Algorithm
        PathfindingContext findPath = new PathfindingContext(new DfsStrategy());
        findPath.findPath(maze, hintPath, visited, startX, startY, maze.getGoalX(), maze.getGoalY());
        return hintPath;
    }

    @Override
    public boolean isValidMove(IPlayerModel player, int dx, int dy) {
        //Get new coordinates
        int newX = (int) (player.getX() + dx);
        int newY = (int) (player.getY() + dy);

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
