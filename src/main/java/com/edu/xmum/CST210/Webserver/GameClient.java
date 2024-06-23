package com.edu.xmum.CST210.Webserver;

import Constant.Config;
import com.edu.xmum.CST210.Controller.IGameController;
import com.edu.xmum.CST210.Service.Interface.IGameService;
import com.edu.xmum.CST210.View.Interface.IGameView;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Factory.FactoryProducer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient extends Application {
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static IGameView gameView;
    private static IGameController gameController;
    private static IGameService gameService;
    private static IGameModel gameModel;

    public static void setGameView(IGameView gameView) {
        GameClient.gameView = gameView;
    }

    public static void setGameController(IGameController gameController) {
        GameClient.gameController = gameController;
    }

    public static void setGameService(IGameService gameService) {
        GameClient.gameService = gameService;
    }

    public static IGameService getGameService() {
        return gameService;
    }

    public static IGameModel getGameModel() {
        return gameModel;
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(gameView.getView(), 800, 600);

        scene.setOnKeyPressed(this::handleKeyPress);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Game Client");
        primaryStage.show();

        new Thread(GameClient::connectToServer).start();
    }

    public static void connectToServer() {
        while (true) {
            try {
                socket = new Socket("10.70.115.250", 10080); // 替换为你的服务器地址
                System.out.println("Connected to server");

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.startsWith("INIT__")) {
                        handleInit(message.split("__")[1]);
                    } else if (message.startsWith("UPDATE__")) {
                        handleUpdate(message.split("__")[1]);
                    } else if (message.startsWith("MAZE__")) {
                        handleMazeData(message.split("__")[1]);
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection lost, retrying...");
                e.printStackTrace();
                try {
                    Thread.sleep(3000); // 等待3秒后重试连接
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public static void send(String message) {
        out.println(message);
    }

    private void handleKeyPress(KeyEvent event) {
        String key = event.getText().toUpperCase();
        if ("WASD".contains(key) || "IJKL".contains(key)) {
            send("KEYPRESS__" + key);
        }
    }

    private static void handleInit(String initData) {
        gameModel.fromString(initData);
    }

    private static void handleUpdate(String update) {
        // 处理接收到的更新消息，并更新游戏视图
        if (gameService != null) {
            gameService.getMazeService().initializeMaze(update);
            gameView.getRunView().reSetView();
        }
    }

    private static void handleMazeData(String mazeData) {
        // 处理接收到的迷宫数据
        if (gameService != null) {
            gameService.getMazeService().initializeMaze(mazeData);
            gameView.getRunView().reSetView();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
