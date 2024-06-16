package com.edu.xmum.cst206;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Entity.GameView;
import com.edu.xmum.cst206.View.Entity.SkinSelectionView;
import com.edu.xmum.cst206.View.Interface.IGameView;
import com.edu.xmum.cst206.View.Interface.ISkinSelectionView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.edu.xmum.cst206.Config.SCENE_HEIGHT;
import static com.edu.xmum.cst206.Config.SCENE_WIDTH;

public class App extends Application {
    private IGameController gameController;
    private IGameView gameView;
    private IGameService gameService;
    private IGameModel gameModel;

    @Override
    public void start(Stage primaryStage) {
        showSkinSelectionView(primaryStage);
    }

    private void showSkinSelectionView(Stage primaryStage) {
        ISkinSelectionView skinSelectionView = new SkinSelectionView();
        ArrayList<Button> buttons = skinSelectionView.getButtons();
        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnAction(actionEvent -> {
                Config.skin = Skin.valueOf("V" + (finalI + 1));
                initLayer();
                //设置主场景并显示
                Scene scene = new Scene(gameView.getView(), SCENE_HEIGHT, SCENE_WIDTH);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Maze Game");
                primaryStage.show();
            });
        }
        Scene scene = new Scene(skinSelectionView.getNode(), SCENE_HEIGHT, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Skin");
        primaryStage.show();
    }

    private void initLayer() {
        // 初始化
        gameModel = FactoryProducer.getFactory("GameModel").getGameModel(Config.skin);
        gameService = FactoryProducer.getFactory("GameService").getGameService(Config.skin, gameModel);
        gameController = FactoryProducer.getFactory("GameController").gameController(Config.skin, gameService);
        gameView = new GameView(gameController);

        // 依赖注入
        gameController.setGameView(gameView);
    }
}
