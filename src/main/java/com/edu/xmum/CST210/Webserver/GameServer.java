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
            sendInitData();
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // 处理客户端发送的消息
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendInitData() {
            // 发送初始化数据到客户端
            out.println("INIT__" + gameState.getGameModel().toString());
        }

        public void sendGameState() {
            // 发送当前游戏状态到客户端
            out.println("MAZE__" + gameState.getGameModel().getMazeModel().toString());
        }
    }
}
