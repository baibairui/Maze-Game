package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Interferce.Drawable;
import com.edu.xmum.cst206.Model.Maze;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;

/*
迷宫视图类
负责迷宫的显示
 */
public class MazeView extends Node implements Drawable {
    private Maze maze;
    private Node node;
    public MazeView(Maze maze){
        this.maze=maze;
        this.node=draw();
    }
    public Node getNode(){
        return node;
    }

    /*这里我们用方形来绘制迷宫地图，二维矩阵中
    1是墙壁——>用白色方块来表示
    0是通路——>用黑色方块来表示
     */
    @Override
    public Node draw() {
        Pane pane = new Pane();
        int cellSize = CELL_SIZE;
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                Rectangle rect = new Rectangle(j * cellSize, i * cellSize, cellSize, cellSize);
                rect.setFill(maze.getMaze()[i][j] == 1 ? Color.BLACK : Color.WHITE);//1是墙壁，0是通路
                rect.setStroke(Color.GRAY);
                pane.getChildren().add(rect);
            }
        }
        return pane;
    }

}
