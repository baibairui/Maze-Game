package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MazeView extends Pane implements IMazeView {
    private int cellSize;
    private IMazeModel maze;

    public MazeView(IMazeModel maze) {
        super();
        this.maze = maze;
        this.cellSize = 20; // 默认初始化为20
    }

    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void draw() {
        for (int y = 0; y < maze.getRows(); y++) {
            for (int x = 0; x < maze.getCols(); x++) {
                Rectangle rect = new Rectangle(x * cellSize, y * cellSize, cellSize, cellSize);
                rect.setFill(maze.getMaze()[y][x] == 1 ? Color.BLACK : Color.WHITE);
                rect.setStroke(Color.GRAY);
                getChildren().add(rect);
            }
        }
    }

    @Override
    public void reDraw() {
        getChildren().clear();
        draw();
    }
}
