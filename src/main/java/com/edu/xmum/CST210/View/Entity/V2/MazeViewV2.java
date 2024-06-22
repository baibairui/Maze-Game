package com.edu.xmum.CST210.View.Entity.V2;

import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.View.Interface.IMazeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Implementation of the maze view for version 2.
 * This class is responsible for displaying the maze using simple colored rectangles.
 */
public class MazeViewV2 extends Pane implements IMazeView {
    private final IMazeModel maze;
    private int cellSize;

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
        Image pathImage = new Image("com/edu/xmum/CST210/maze/path2.gif");
        Image wallImage = new Image("com/edu/xmum/CST210/maze/wall2.gif");

        // Clearing previous drawings
        getChildren().clear();

        // Drawing the maze
        for (int y = 0; y < maze.getRows(); y++) {
            for (int x = 0; x < maze.getCols(); x++) {
                ImageView imageView;
                if (maze.getMaze()[y][x] == 1) {
                    imageView = new ImageView(wallImage);
                } else {
                    imageView = new ImageView(pathImage);
                }
                imageView.setFitWidth(cellSize);
                imageView.setFitHeight(cellSize);
                imageView.setX(x * cellSize);
                imageView.setY(y * cellSize);
                getChildren().add(imageView);
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
     * Sets the cell size for the maze view.
     *
     * @param cellSize The size of each cell in the view.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
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
