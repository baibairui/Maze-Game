// GameState.java
package com.edu.xmum.CST210.Webserver;

public class GameState {
    private static int player1X, player1Y;
    private static int player2X, player2Y;

    static {
        // 初始化静态属性
        player1X = 1;
        player1Y = 1;
        player2X = 1;
        player2Y = 1;
    }

    public static void update(String keyCode) {
        switch (keyCode) {
            case "W":
                player1Y -= 1;
                break;
            case "A":
                player1X -= 1;
                break;
            case "S":
                player1Y += 1;
                break;
            case "D":
                player1X += 1;
                break;
            case "I":
                player2Y -= 1;
                break;
            case "J":
                player2X -= 1;
                break;
            case "K":
                player2Y += 1;
                break;
            case "L":
                player2X += 1;
                break;
        }
    }

    @Override
    public String toString() {
        return player1X + "," + player1Y + "," + player2X + "," + player2Y;
    }
}
