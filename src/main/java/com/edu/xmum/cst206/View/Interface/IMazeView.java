package com.edu.xmum.cst206.View.Interface;

import javafx.scene.layout.Pane;

/**
 * Interface for MazeView.
 * Specifies the methods that the MazeView should implement.
 */
public interface IMazeView {

    /**
     * Sets the cell size for the maze view.
     *
     * @param cellSize The size of each cell in the view.
     */
    void setCellSize(int cellSize);

    /**
     * Gets the cell size for the maze view.
     *
     * @return The size of each cell in the view.
     */
    int getCellSize();

    /**
     * Gets the main node of the maze view.
     *
     * @return The Pane containing the maze view.
     */
    Pane getNode();

    /**
     * Draws the maze view for the first time.
     */
    void draw();

    /**
     * Redraws the maze view, updating any changes.
     */
    void reDraw();
}
