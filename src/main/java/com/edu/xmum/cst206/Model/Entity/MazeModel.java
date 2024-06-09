package com.edu.xmum.cst206.Model.Entity;


import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
迷宫对象类
由于设计了View层，因此不需要实现Drawable接口
只需要专注模型层的相关属性问题
属性：

 */
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
        super(0, 0);
        this.rows = rows;
        this.cols = cols;
        this.startX = 1;
        this.startY = 1;
        this.maze = new int[rows][cols];
    }
    /*基于随机prim算法的迷宫生成
        1.先将用于表示迷宫的二维数组全部初始化为1
        2.将入口位置设置为0
        3.初始化一个邻接边的列表用来存储候选边
        4.从当前位置开始添加候选边
        5.在候选边列表中随机选择通路
        6.循环选择通路直至列表为空
         */
    public void generateMaze() {
        this.goalX = cols - 1; // 初始化的迷宫终点坐标（cols-1，rows-2）
        this.goalY = rows - 2;
        Random random = new Random();
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = 1; // 初始化迷宫的二维数组为1（墙）
            }
        }
        maze[startY][startX] = 0; // 设置入口
        //初始化一个边的列表 ，用于储存候选通路
        List<Edge> edges = new ArrayList<>();
        //初始化候选通路
        addEdges(startX, startY, edges);

        //循环处理候选通路，直至生成到终点的通路
        while (!edges.isEmpty()) {
            // 随机选择一个边并移除
            Edge edge = edges.remove(random.nextInt(edges.size()));//在候选边中随机选择一条边来生成通路
            //如果该位置是墙则表示没访问过
            if (maze[edge.x2][edge.y2] == 1) {
                //设置一条通路
                maze[edge.x1][edge.y1] = 0;
                maze[edge.x2][edge.y2] = 0;
                //添加新的候选边
                addEdges(edge.x2, edge.y2, edges);
            }
        }
        maze[goalY][goalX] = 0; // 设置出口

        // 打印迷宫结构
        System.out.println("Maze structure:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
    }

    //用于添加候选边的方法
    private void addEdges(int x, int y, List<Edge> edges) {
        // 限制边际，确保添加的候选边不会越界
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
