package com.edu.xmum.CST210.Webserver;

import java.io.*;
import java.net.*;

public class GameServer {
    public static void main(String[] args) {
        int port = 12345; // 使用你的游戏端口
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("服务器已启动，等待客户端连接...");
            while (true) {
                Socket clientSocket = serverSocket.accept(); // 等待客户端连接
                System.out.println("客户端已连接");

                // 启动新线程处理客户端连接
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("收到客户端消息: " + message);
                out.println("服务器响应: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
