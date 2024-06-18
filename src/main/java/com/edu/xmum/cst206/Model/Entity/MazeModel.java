package com.edu.xmum.cst206.Model.Entity;


import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
The concrete implementation class of the maze object
Attributes:
rows: indicates the number of rows
cols: indicates the number of columns
maze: a two-dimensional array to represent the maze, [y][x]
goal:target position
start: start position
 */
public class MazeModel extends GameObject implements IMazeModel {
    private int rows;
    private int cols;
    private int[][] maze;
    private int goalX;
    private int goalY;
    private int startX;
    private int startY;

    // Define the class of the edge
    private static class Edge {
        int x1, y1, x2, y2;

        Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public MazeModel(int rows, int cols) {
        super(0, 0);
        this.rows = rows;
        this.cols = cols;
        this.startX = 1;
        this.startY = 1;
        this.maze = new int[rows][cols];
    }

    /*Maze generation based on stochastic prim algorithm
        1. First, initialise all two-dimensional arrays used to represent the maze to 1
        2. Set the entrance position to 0
        3. Initialise a list of adjacency edges to store candidate edges
        4. Add candidate edges from the current position.
        5. Randomly select the pathway in the list of candidate edges
        6. Cycle through the selection of pathways until the list is empty.
         */
    public void generateMaze() {
        this.goalX = cols - 1; // Initialised maze endpoint coordinates (cols-1, rows-2)
        this.goalY = rows - 2;
        Random random = new Random();
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = 1; // Initialise the 2D array of the maze to 1 (wall)
            }
        }
        maze[startY][startX] = 0; // Setting up the entrance
        //Initialise a list of edges for storing candidate pathways
        List<Edge> edges = new ArrayList<>();
        //Initialising candidate pathways
        addEdges(startX, startY, edges);

        //Cycle through the candidate pathways until a pathway to the endpoint is generated
        while (!edges.isEmpty()) {
            // Randomly select an edge and remove it
            Edge edge = edges.remove(random.nextInt(edges.size()));//Generate a pathway by randomly selecting an edge among the candidate edges
            //If the location is a wall then it has not been visited
            if (maze[edge.x2][edge.y2] == 1) {
                //Setting up a pathway
                maze[edge.x1][edge.y1] = 0;
                maze[edge.x2][edge.y2] = 0;
                //Add new candidate edge
                addEdges(edge.x2, edge.y2, edges);
            }
        }
        maze[goalY][goalX] = 0; // Setting up an outlet

        // Print Labyrinth Structure
        System.out.println("Maze structure:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
    }

    //Methods for adding candidate edges
    private void addEdges(int x, int y, List<Edge> edges) {
        // Limit edges to ensure that added candidate edges do not cross boundaries
        if (x > 1 && maze[x - 2][y] == 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1 && maze[x][y - 2] == 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < rows - 2 && maze[x + 2][y] == 1) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < cols - 2 && maze[x][y + 2] == 1) edges.add(new Edge(x, y + 1, x, y + 2));
    }

    // Getters
    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public void setCols(int cols) {
        this.cols = cols;
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
}
