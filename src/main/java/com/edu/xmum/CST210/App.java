package com.edu.xmum.CST210;

import Constant.Config;
import Constant.Skin;
import com.edu.xmum.CST210.Controller.IGameController;
import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Service.Interface.IGameService;
import com.edu.xmum.CST210.View.Entity.GameView;
import com.edu.xmum.CST210.View.Entity.SkinSelectionView;
import com.edu.xmum.CST210.View.Interface.IGameView;
import com.edu.xmum.CST210.View.Interface.ISkinSelectionView;
import com.edu.xmum.CST210.Webserver.GameClient;
import com.edu.xmum.CST210.Webserver.GameServer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Constant.Config.*;

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
                skin = Skin.valueOf("V" + (finalI + 1));
                if (skin.getSkin().equals("V1")) {
                    skin = Skin.V2;
                } else if (skin.getSkin().equals("V2")) {
                    skin = Skin.V1;
                }
                initLayer(primaryStage);
            });
        }
        Scene scene = new Scene(skinSelectionView.getNode(), SCENE_HEIGHT, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Skin");
        primaryStage.show();
    }

    private void initLayer(Stage primaryStage) {
        gameModel = FactoryProducer.getFactory("GameModel").getGameModel(Config.skin);
        gameService = FactoryProducer.getFactory("GameService").getGameService(Config.skin, gameModel);
        gameController = FactoryProducer.getFactory("GameController").getGameController(Config.skin, gameService);
        gameView = new GameView();

        gameController.setGameView(gameView);

        new Thread(() -> {
            try {
                GameServer.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                GameClient.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Scene scene = new Scene(gameView.getView(), SCENE_HEIGHT, SCENE_WIDTH);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
