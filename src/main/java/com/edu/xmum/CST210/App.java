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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static Constant.Config.*;

/**
 * Main application class for the Maze Game.
 */
public class App extends Application {
    private IGameController gameController;
    private IGameView gameView;
    private IGameService gameService;
    private IGameModel gameModel;

    @Override
    public void start(Stage primaryStage) {
        showSkinSelectionView(primaryStage);
    }

    /**
     * Displays the skin selection view where the user can choose a skin for the game.
     *
     * @param primaryStage The primary stage of the application.
     */
    private void showSkinSelectionView(Stage primaryStage) {
        ISkinSelectionView skinSelectionView = new SkinSelectionView();
        ArrayList<Button> buttons = skinSelectionView.getButtons();
        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnAction(actionEvent -> {
                skin = Skin.valueOf("V" + (finalI + 1));
                // Sequence Adjustment
                if (skin.getSkin().equals("V1")) {
                    skin = Skin.V2;
                } else if (skin.getSkin().equals("V2")) {
                    skin = Skin.V1;
                }
                initLayer();
                // 启动客户端线程连接服务器并等待初始化数据
                new Thread(() -> {
                    javafx.application.Platform.runLater(() -> {
                        // Setting up the main scene and displaying it
                        // Dependency injection
                        gameView = new GameView();
                        gameController.setGameView(gameView);

                        Scene scene = new Scene(gameView.getView(), SCENE_HEIGHT, SCENE_WIDTH);
                        primaryStage.setScene(scene);
                        primaryStage.setTitle("Maze Game");
                        primaryStage.show();

                    });
                    GameClient.connectToServer();
                }).start();
            });
        }
        Scene scene = new Scene(skinSelectionView.getNode(), SCENE_HEIGHT, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Skin");
        primaryStage.show();
    }

    /**
     * Initializes the layers of the game (model, service, controller, view) based on the selected skin.
     */
    private void initLayer() {

        // Initialization
        gameModel = GameClient.getGameModel();
        gameService = FactoryProducer.getFactory("GameService").getGameService(skin,gameModel);
        gameController = FactoryProducer.getFactory("GameController").getGameController(Config.skin, gameService);

        // 设置客户端的视图、控制器和服务
        GameClient.setGameView(gameView);
    }

    public static void main(String[] args) {
        launch();
    }
}
