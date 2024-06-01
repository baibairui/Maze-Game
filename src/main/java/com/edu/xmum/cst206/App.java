package com.edu.xmum.cst206;


import com.edu.xmum.cst206.Model.Tank.PlayerTank;
import com.edu.xmum.cst206.Model.Tank.TankObject;
import com.edu.xmum.cst206.View.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.edu.xmum.cst206.*;
import javafx.scene.paint.Color;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameView gameView = new GameView();

        // 创建一个坦克对象
        TankObject tank = new PlayerTank(200, 200, 50, 50, Color.GREEN, 5);
        gameView.addGameObject(tank);
        System.out.println("done");
        Scene scene = new Scene(gameView, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tank Battle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
