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
public class MazeView extends Pane {
    private Maze maze;
    private double cellSize;

    public MazeView(Maze maze) {
        this.maze = maze;
        this.cellSize = CELL_SIZE; // 初始设定
        draw();
    }

    public void setCellSize(double cellSize) {
        this.cellSize = cellSize;
        redraw();
    }

    public Maze getMaze() {
        return maze;
    }

    public void draw() {
        Pane pane = new Pane();
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                Rectangle rect = new Rectangle(j * cellSize, i * cellSize, cellSize, cellSize);
                rect.setFill(maze.getMaze()[i][j] == 1 ? Color.BLACK : Color.WHITE);
                rect.setStroke(Color.GRAY);
                pane.getChildren().add(rect);
            }
        }
        getChildren().setAll(pane);
    }

    public void redraw() {
        draw();
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public double getCellSize() {
        return cellSize;
    }
}

