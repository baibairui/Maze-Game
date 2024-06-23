package Webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameServer {
    private static ServerSocket serverSocket;
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private static GameState gameState = new GameState(); // GameState类来管理游戏状态

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(10080);
        System.out.println("Server started, waiting for client connections...");

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
                client.sendGameState(gameState);
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
            GameState.update(keyCode);
            GameServer.broadcastGameState(); // 广播更新后的游戏状态
        }

        public void sendGameState(GameState gameState) {
            out.println("UPDATE__" + gameState.toString()); // 将游戏状态转换为字符串发送
        }
    }
}
