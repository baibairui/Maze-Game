package com.edu.xmum.cst206.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
迷宫对象类
由于设计了View层，因此不需要实现Drawable接口
只需要专注模型层的相关功能
 */
public class Maze extends GameObject {
    private int rows;//迷宫的行数
    private int cols;//迷宫的列数
    private int[][] maze;//用于表示迷宫，0表示通路，1表示墙

    public Maze(int x,int y,int width,int hight,int rows, int cols) {
        super(x,y,width,hight);
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMazePrim();
    }

    public int[][] getMaze() {
        return maze;
    }
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }


    //定义边的类
    private static class Edge {
        int x1, y1, x2, y2;

        Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    /*基于随机prim算法的迷宫生成
    1.先将用于表示迷宫的二维数组全部初始化为1
    2.将入口位置设置为0
    3.初始化一个邻接边的列表用来存储候选边
    4.从当前位置开始添加候选边
    5.在候选边列表中随机选择通路
    6.循环选择通路直至列表为空
     */
    public void generateMazePrim() {
        Random random = new Random();//用于随机选择一条候选边
        //将用于表示迷宫的二维数组全部初始化为1
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }
        //将入口位置设置为0
        int startX = 1;
        int startY = 1;
        maze[startX][startY] = 0;
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


        //设置出口和入口
        maze[1][0]=0;
        maze[1][1] = 0;
        maze[rows - 2][cols - 1] = 0;
    }
    //用于添加候选边的方法
    private void addEdges(int x, int y, List<Edge> edges) {
        // 限制边际，确保添加的候选边不会越界
        if (x > 1 && maze[x - 2][y] == 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1 && maze[x][y - 2] == 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < rows - 2 && maze[x + 2][y] == 1) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < cols - 2 && maze[x][y + 2] == 1) edges.add(new Edge(x, y + 1, x, y + 2));
    }
    //相关的get和set方法


    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }
}