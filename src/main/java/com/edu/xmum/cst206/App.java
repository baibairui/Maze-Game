package com.edu.xmum.cst206;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Entity.GameModel;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.GameView;
import com.edu.xmum.cst206.View.Interface.IGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.edu.xmum.cst206.Config.SCENE_HEIGHT;
import static com.edu.xmum.cst206.Config.SCENE_WIDTH;

public class App extends Application {
    private IGameController gameController;
    private IGameView gameView;
    private IGameService gameService;
    private IGameModel gameModel;
    @Override
    public void start(Stage primaryStage) {
        initLayer();
        //设置主场景并显示
        Scene scene =new Scene(gameView.getView(),SCENE_HEIGHT,SCENE_WIDTH);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Game");
        primaryStage.show();
    }

    private void initLayer() {
          /*
        初始化
        View Controller Service Model
        Model->Service<->Controller<->View
        这里要解决一下
        各层之间的依赖问题
        这里使用setter注入的方法来解决
         */

        // 初始化
        gameModel = new GameModel();
        gameService = new GameService(gameModel);
        gameController = new GameController(gameService);
        gameView = new GameView(gameController);

        // 依赖注入
        gameController.setGameView(gameView);
    }

}
