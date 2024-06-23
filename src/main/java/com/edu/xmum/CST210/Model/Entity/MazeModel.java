package com.edu.xmum.CST210.Model.Entity;

import com.edu.xmum.CST210.Model.AbstractClass.GameObject;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Concrete implementation class of the maze object.
 * This class represents a maze and provides methods to generate it using the stochastic Prim's algorithm.
 * <p>
 * Attributes:
 * - rows: number of rows in the maze
 * - cols: number of columns in the maze
 * - maze: a two-dimensional array to represent the maze, [y][x]
 * - goalX, goalY: target position coordinates
 * - startX, startY: start position coordinates
 */
public class MazeModel extends GameObject implements IMazeModel {
    private final int[][] maze;
    private final int startX;
    private final int startY;
    private int rows;
    private int cols;
    private int goalX;
    private int goalY;

    /**
     * Constructor to initialize the maze with the specified number of rows and columns.
     *
     * @param rows The number of rows in the maze.
     * @param cols The number of columns in the maze.
     */
    public MazeModel(int rows, int cols) {
        super(0, 0);
        this.rows = rows;
        this.cols = cols;
        this.startX = 1;
        this.startY = 1;
        this.maze = new int[rows][cols];
    }

    /**
     * Generates the maze using the stochastic Prim's algorithm.
     * 1. Initialize all cells in the maze to 1 (wall).
     * 2. Set the entrance position to 0 (path).
     * 3. Initialize a list of adjacent edges to store candidate edges.
     * 4. Add candidate edges from the current position.
     * 5. Randomly select a pathway from the list of candidate edges.
     * 6. Repeat until the list of candidate edges is empty.
     */
    public void generateMaze() {
        this.goalX = cols - 1; // Initialize maze endpoint coordinates (cols-1, rows-2)
        this.goalY = rows - 2;
        Random random = new Random();
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = 1; // Initialize the 2D array of the maze to 1 (wall)
            }
        }
        maze[startY][startX] = 0; // Setting up the entrance
        // Initialize a list of edges for storing candidate pathways
        List<Edge> edges = new ArrayList<>();
        // Initialize candidate pathways
        addEdges(startX, startY, edges);

        // Cycle through the candidate pathways until a pathway to the endpoint is generated
        while (!edges.isEmpty()) {
            // Randomly select an edge and remove it
            Edge edge = edges.remove(random.nextInt(edges.size())); // Generate a pathway by randomly selecting an edge among the candidate edges
            // If the location is a wall, then it has not been visited
            if (maze[edge.x2][edge.y2] == 1) {
                // Set up a pathway
                maze[edge.x1][edge.y1] = 0;
                maze[edge.x2][edge.y2] = 0;
                // Add new candidate edges
                addEdges(edge.x2, edge.y2, edges);
            }
        }
        maze[goalY][goalX] = 0; // Set up an outlet

        // Print the maze structure
        System.out.println("Maze structure:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 序列化迷宫数据为字符串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            for (int cell : row) {
                sb.append(cell).append(",");
            }
            sb.append(";");
        }
        return sb.toString();
    }
    @Override
    public void fromString(String mazeData) {
        String[] rows = mazeData.split(";");
        for (int i = 0; i < rows.length; i++) {
            String[] cells = rows[i].split(",");
            for (int j = 0; j < cells.length; j++) {
                maze[i][j] = Integer.parseInt(cells[j]);
            }
        }
    }

    /**
     * Adds candidate edges to the list for a given position in the maze.
     *
     * @param x     The x-coordinate of the current position.
     * @param y     The y-coordinate of the current position.
     * @param edges The list of candidate edges.
     */
    private void addEdges(int x, int y, List<Edge> edges) {
        // Ensure that added candidate edges do not cross boundaries
        if (x > 1 && maze[x - 2][y] == 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1 && maze[x][y - 2] == 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < rows - 2 && maze[x + 2][y] == 1) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < cols - 2 && maze[x][y + 2] == 1) edges.add(new Edge(x, y + 1, x, y + 2));
    }

    // Getters and Setters
    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public void setCols(int cols) {
        this.cols = cols;
    }

    @Override
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public int getGoalX() {
        return goalX;
    }

    @Override
    public int getGoalY() {
        return goalY;
    }

    @Override
    public int getStartX() {
        return startX;
    }

    @Override
    public int getStartY() {
        return startY;
    }

    /**
     * Inner class representing an edge in the maze.
     */
    private static class Edge {
        final int x1;
        final int y1;
        final int x2;
        final int y2;

        Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
