package com.edu.xmum.CST210.Webserver;

import Constant.Config;
import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.Model.Entity.GameModel;
import com.edu.xmum.CST210.Model.Interface.IGameModel;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    private static final int PORT = 10080;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static IGameModel gameModel;

    public static void main(String[] args) {
        System.out.println("The game server is running...");
        gameModel = initializeGameModel(); // 初始化游戏模型
        try (ServerSocket listener = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                sendInitData(out); // 发送初始化数据

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.startsWith("KEYPRESS__")) {
                        handleKeyPress(message.split("__")[1]);
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }

        private void sendInitData(PrintWriter out) {
            // 游戏模型有一个 toString 方法将其序列化为字符串
            String initData = "INIT__" + gameModel.toString();
            out.println(initData);
        }

        private void handleKeyPress(String keyPress) {
            // 更新游戏状态
            GameState gameState = new GameState(gameModel);
            gameState.update(keyPress);
            String updateData = "UPDATE__" + gameModel.toString();
            broadcast(updateData);
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }

    private static IGameModel initializeGameModel() {
        // 初始化游戏模型的逻辑
        return FactoryProducer.getFactory("GameModel").getGameModel(Config.skin);
    }
}
