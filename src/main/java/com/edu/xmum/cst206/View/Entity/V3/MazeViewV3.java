package com.edu.xmum.cst206.View.Entity.V3;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.View.Interface.IMazeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MazeViewV3 extends Pane implements IMazeView {
    private int cellSize;
    private IMazeModel maze;

    public MazeViewV3(IMazeModel maze) {
        super();
        this.maze = maze;
        this.cellSize = 20; // Default initialisation is 20
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
        Image pathImage = new Image("com/edu/xmum/cst206/maze/path.png");
        Image wallImage = new Image("com/edu/xmum/cst206/maze/wall.png");

        // Clearing previous drawings
        getChildren().clear();

        // Drawing a labyrinth
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

    public int getCellSize() {
        return this.cellSize;
    }

    @Override
    public void reDraw() {
        getChildren().clear();
        draw();
    }

}
