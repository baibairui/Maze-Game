package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class GameController {
    private GameService gameService;
    private Pane pane;
    private Scene scene;

    public GameController(Pane pane, Scene scene) {
        this.pane = pane;
        this.scene = scene;
        this.gameService = new GameService(pane);
        initializeGame();
        setupSceneControls();
    }

    private void initializeGame() {
        int[] dimensions = getMazeDimensions();
        int rows = dimensions[0];
        int cols = dimensions[1];
        gameService.initializeGame(rows, cols);
    }

    private int[] getMazeDimensions() {
        // Simplified for brevity; you can use TextInputDialog as before to get user input.
        return new int[]{45, 55}; // Example dimensions
    }

    public void setupSceneControls() {
        scene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            switch (key) {
                case UP:
                    gameService.movePlayer(0, -1);
                    break;
                case DOWN:
                    gameService.movePlayer(0, 1);
                    break;
                case LEFT:
                    gameService.movePlayer(-1, 0);
                    break;
                case RIGHT:
                    gameService.movePlayer(1, 0);
                    break;
            }
        });
    }
}
