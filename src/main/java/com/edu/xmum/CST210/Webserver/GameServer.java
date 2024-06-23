package com.edu.xmum.CST210.Webserver;

import Constant.Config;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Factory.FactoryProducer;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    private static ServerSocket serverSocket;
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private static GameState gameState; // 用于存储游戏状态

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(10080);
        System.out.println("Server started, waiting for client connections...");

        // 初始化游戏状态
        IGameModel gameModel = FactoryProducer.getFactory("GameModel").getGameModel(Config.skin);
        gameState = new GameState(gameModel);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clients.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    public static void broadcastGameState() {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                client.sendGameState();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);

            // 发送初始化的迷宫数据
            sendMazeData();
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.startsWith("KEYPRESS__")) {
                        handleKeyPress(message.split("__")[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(this);
            }
        }

        private void handleKeyPress(String keyCode) {
            // 根据键盘输入更新游戏状态
            gameState.update(keyCode);
            GameServer.broadcastGameState(); // 广播更新后的游戏状态
        }

        public void sendGameState() {
            out.println("UPDATE__" + gameState.toString()); // 将游戏状态转换为字符串发送
        }

        public void sendMazeData() {
            // 发送初始化的迷宫数据
            out.println("MAZE__" + gameState.toString()); // 假设 gameModel 有 toString 方法用于序列化
        }
    }
}
