package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MazeView extends Pane implements IMazeView {
    private int cellSize;
    private IMazeModel maze;
    public MazeView(IMazeModel maze){
        super();
        this.maze=maze;
        this.cellSize=20;//默认初始化为20
        draw();
    }
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize=cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void draw() {
        getChildren().clear();
        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getCols(); col++) {
                Rectangle rect = new Rectangle(col * cellSize, row * cellSize, cellSize, cellSize);
                rect.setFill(maze.getMaze()[row][col] == 1 ? Color.BLACK : Color.WHITE);
                rect.setStroke(Color.GRAY);
                getChildren().add(rect);
            }
        }
    }

    @Override
    public void reDraw() {
        draw();
    }
}
