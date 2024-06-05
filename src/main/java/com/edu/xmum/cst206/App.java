package com.edu.xmum.cst206;


import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.View.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {
    private GameController gameController;
    private GameView gameView;
    private GameService gameService;

    @Override
    public void start(Stage primaryStage) {
        // 初始化迷宫和玩家
        Maze maze = new Maze(0, 0, 800, 600, 21, 21);
        Player player = new Player(1, 1, 20);

        // 初始化控制器和视图


    }

    public static void main(String[] args) {
        launch(args);
    }
}
