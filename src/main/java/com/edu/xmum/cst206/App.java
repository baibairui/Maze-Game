package com.edu.xmum.cst206;


import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.GameModel;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.View.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.edu.xmum.cst206.Model.ConstantConfig.CELL_SIZE;


public class App extends Application {
    private GameController gameController;
    private GameView gameView;
    private GameService gameService;
    private GameModel gameModel;
    @Override
    public void start(Stage primaryStage) {
        initLayer();
       //设置主场景并显示
        Scene scene =new Scene(gameView,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Game");
        primaryStage.show();

    }
    private void initLayer(){
        // 初始化迷宫和玩家

        Maze maze = new Maze(0, 0, 800, 600, 21, 21);
        Player player = new Player(0, 1, CELL_SIZE/2);

        /*
        初始化
        View Controller Service Model
        Model->Service<->Controller<->View
        这里要解决一下
        各层之间的依赖问题
        这里使用setter注入的方法来解决
         */

        //初始化
        gameModel=new GameModel(maze,player);
        gameService=new GameService(gameModel);
        gameController=new GameController(gameService);
        gameView=new GameView(gameController);

        //依赖注入
        gameService.setGameController(gameController);
        gameController.setGameView(gameView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
