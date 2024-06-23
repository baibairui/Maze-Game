package Webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 22; // 服务器监听的端口号
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("服务器已启动，等待客户端连接...");
            Socket clientSocket = serverSocket.accept(); // 等待客户端连接
            System.out.println("客户端已连接");

            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 从客户端接收消息并发送响应
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
