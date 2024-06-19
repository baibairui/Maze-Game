package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Implementation of the maze view for version 3.
 * This class is responsible for displaying the maze with graphical representations of paths and walls.
 */
public class MazeViewV3 extends Pane implements IMazeView {
    private final IMazeModel maze;
    private int cellSize;

    /**
     * Constructor to initialize the MazeViewV3 components.
     *
     * @param maze The maze model to be displayed.
     */
    public MazeViewV3(IMazeModel maze) {
        super();
        this.maze = maze;
        this.cellSize = 20; // Default initialization is 20
    }

    /**
     * Gets the root node of the MazeView.
     *
     * @return The Pane root node.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Draws the maze using graphical representations of paths and walls.
     */
    @Override
    public void draw() {
        Image pathImage = new Image("com/edu/xmum/cst206/maze/path.png");
        Image wallImage = new Image("com/edu/xmum/cst206/maze/wall.png");

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
     * Gets the size of each cell in the maze.
     *
     * @return The cell size.
     */
    public int getCellSize() {
        return this.cellSize;
    }

    /**
     * Sets the size of each cell in the maze.
     *
     * @param cellSize The size of each cell.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Redraws the maze by clearing the previous drawings and drawing again.
     */
    @Override
    public void reDraw() {
        getChildren().clear();
        draw();
    }
}
