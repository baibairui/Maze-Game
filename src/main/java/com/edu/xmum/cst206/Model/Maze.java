package com.edu.xmum.cst206.Model;

import com.edu.xmum.cst206.Interferce.Drawable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.edu.xmum.cst206.Model.ConstantConfig.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

public class Maze implements Drawable {
    private final int rows;
    private final int cols;
    private final int[][] maze;
    private final Random random = new Random();

    private static class Edge {
        int x1, y1, x2, y2;

        Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMazePrim();
    }

    public int[][] getMaze() {
        return maze;
    }

    private void generateMazePrim() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }

        List<Edge> edges = new ArrayList<>();
        int startX = 1;
        int startY = 1;
        maze[startX][startY] = 0;
        addEdges(startX, startY, edges);

        while (!edges.isEmpty()) {
            Edge edge = edges.remove(random.nextInt(edges.size()));
            if (maze[edge.x2][edge.y2] == 1) {
                maze[edge.x1][edge.y1] = 0;
                maze[edge.x2][edge.y2] = 0;
                addEdges(edge.x2, edge.y2, edges);
            }
        }

        //设置边界
        for(int j=0;j<rows;j++){
            maze[j][0]=1;
            maze[j][cols-1]=1;
        }
        for(int j=0;j<cols;j++){
            maze[0][j]=1;
            maze[rows-1][j]=1;
        }
        //设置出口和入口
        maze[1][0]=0;
        maze[1][1] = 0;
        maze[rows - 2][cols - 1] = 0;
    }

    private void addEdges(int x, int y, List<Edge> edges) {
        if (x > 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < rows - 2) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < cols - 2) edges.add(new Edge(x, y + 1, x, y + 2));
    }

    @Override
    public Node draw() {
        Pane pane=new Pane();
        int cellSize=CELL_SIZE;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Rectangle rect=new Rectangle(j * cellSize, i * cellSize, cellSize, cellSize);
                if(maze[i][j] == 1) {
                    rect.setFill(Color.BLACK); // 墙壁
                } else {
                    rect.setFill(Color.WHITE); // 通道
                }
                rect.setStroke(Color.GRAY); // 单元格边框
                pane.getChildren().add(rect);
            }
        }
        return pane;
    }
}