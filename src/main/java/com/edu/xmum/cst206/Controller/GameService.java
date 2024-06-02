package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Optional;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;


public class GameService {
    private Maze maze;
    private Player player;
    private Pane pane;

    public GameService(Pane pane) {
        this.pane = pane;
    }

    public void initializeGame(int rows, int cols) {
        maze = new Maze(rows, cols);
        player = new Player(0, 1*CELL_SIZE, 20, Color.BLUE);

        pane.getChildren().clear();
        pane.getChildren().add(maze.draw());
        pane.getChildren().add(player.draw());

        updatePlayerPosition();
    }

    public void movePlayer(int dx, int dy) {
        int newX = (int) player.getX() + dx;
        int newY = (int) player.getY() + dy;

        if (isValidMove(newX, newY)) {
            player.setX(newX);
            player.setY(newY);
            updatePlayerPosition();
            checkWin();
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < maze.getMaze()[0].length && y >= 0 && y < maze.getMaze().length && maze.getMaze()[y][x] == 0;
    }

    private void checkWin() {
        if (player.getX() == maze.getMaze()[0].length - 1 && player.getY() == maze.getMaze().length - 1) {
            Text winText = new Text("You Win!");
            winText.setX(100);
            winText.setY(200);
            winText.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-fill: #006d80;");
            pane.getChildren().add(winText);
            System.out.println("You Win!");
        }
    }

    private void updatePlayerPosition() {
        double cellSize = 20.0;
        double mazeWidth = maze.getMaze()[0].length * cellSize;
        double mazeHeight = maze.getMaze().length * cellSize;

        double offsetX = (pane.getWidth() - mazeWidth) / 2;
        double offsetY = (pane.getHeight() - mazeHeight) / 2;

        player.getNode().setTranslateX(player.getX() * cellSize + offsetX);
        player.getNode().setTranslateY(player.getY() * cellSize + offsetY);
    }
}
