package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Implementation of the maze view for version 2.
 * This class is responsible for displaying the maze using simple colored rectangles.
 */
public class MazeViewV2 extends Pane implements IMazeView {
    private int cellSize;
    private final IMazeModel maze;

    /**
     * Constructs the MazeViewV2 with the specified maze model.
     *
     * @param maze The maze model to use.
     */
    public MazeViewV2(IMazeModel maze) {
        super();
        this.maze = maze;
        this.cellSize = 20; // Default initialization is 20
    }

    /**
     * Sets the cell size for the maze view.
     *
     * @param cellSize The size of each cell in the view.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Gets the root node of the maze view.
     *
     * @return The Pane root node.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Draws the maze view for the first time.
     * Uses colored rectangles to represent the maze cells.
     */
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

    /**
     * Gets the cell size for the maze view.
     *
     * @return The size of each cell in the view.
     */
    @Override
    public int getCellSize() {
        return this.cellSize;
    }

    /**
     * Redraws the maze view, updating any changes.
     */
    @Override
    public void reDraw() {
        getChildren().clear();
        draw();
    }
}
