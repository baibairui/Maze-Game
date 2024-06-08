package com.edu.xmum.cst206.Model.Entity;


import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeModel extends GameObject implements IMazeModel {
    private int rows;
    private int cols;
    private int[][] maze;
    private int goalX;
    private int goalY;
    private int startX;
    private int startY;

    // 定义边的类
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
        super(0, 0); // 初始位置可以设置为 (0, 0) 或其他默认值
        this.rows = rows;
        this.cols = cols;
        this.startX = 1; // 默认的起点
        this.startY = 1;
        this.goalX = cols - 2; // 初始化的迷宫终点坐标（cols-2，rows-2）
        this.goalY = rows - 2;
        this.maze = new int[rows][cols];
        generateMaze();
    }

    @Override
    public void generateMaze() {
        Random random = new Random(); // 用于随机选择一条候选边
        // 将用于表示迷宫的二维数组全部初始化为1
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }
        // 设置入口
        maze[startY][startX] = 0; // 使用 [y][x] 顺序
        // 初始化一个边的列表，用于存储候选通路
        List<Edge> edges = new ArrayList<>();
        // 初始化候选通路
        addEdges(startX, startY, edges);

        // 循环处理候选通路，直至生成到终点的通路
        while (!edges.isEmpty()) {
            // 随机选择一个边并移除
            Edge edge = edges.remove(random.nextInt(edges.size())); // 在候选边中随机选择一条边来生成通路
            // 如果该位置是墙则表示没访问过
            if (maze[edge.y2][edge.x2] == 1) {
                // 设置一条通路
                maze[edge.y1][edge.x1] = 0;
                maze[edge.y2][edge.x2] = 0;
                // 添加新的候选边
                addEdges(edge.x2, edge.y2, edges);
            }
        }

        // 设置出口和入口
        maze[startY][startX] = 0;
        maze[goalY][goalX] = 0;
        // 打印迷宫结构
        System.out.println("Maze structure:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 用于添加候选边的方法
    private void addEdges(int x, int y, List<Edge> edges) {
        // 限制边际，确保添加的候选边不会越界
        if (x > 1 && maze[y][x - 2] == 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1 && maze[y - 2][x] == 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < cols - 2 && maze[y][x + 2] == 1) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < rows - 2 && maze[y + 2][x] == 1) edges.add(new Edge(x, y + 1, x, y + 2));
    }

    // 相关的 get 和 set 方法
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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
