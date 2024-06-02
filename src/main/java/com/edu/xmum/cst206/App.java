package com.edu.xmum.cst206;


import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.View.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameView gameView = new GameView();
        Scene scene = new Scene(gameView, 800, 600);
        GameController gameController = new GameController(gameView,scene);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Tank Battle Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
