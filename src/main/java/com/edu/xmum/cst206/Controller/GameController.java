package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import com.edu.xmum.cst206.Service.MazeService;
import com.edu.xmum.cst206.Service.PlayerService;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/*
GameController类用于处理前端交互的请求并将后端的响应返回
 */
public class GameController {
    private PlayerService playerService;
    private MazeService mazeService;
    private Maze maze;
    private Player player;
    public GameController(Player player,Maze maze){
        this.maze=maze;
        this.player=player;
        this.mazeService=new MazeService(maze);
        this.playerService=new PlayerService(this.player,mazeService);
    }
    // 处理用户的移动输入
    public void handleKeyPress(KeyCode code) {
        switch (code) {
            case UP:
                playerService.movePlayer(0, -1);
                break;
            case DOWN:
                playerService.movePlayer(0, 1);
                break;
            case LEFT:
                playerService.movePlayer(-1, 0);
                break;
            case RIGHT:
                playerService.movePlayer(1, 0);
                break;
            default:
                break;
        }
    }

    // 检查是否到达终点
    public boolean checkGoal() {
        return playerService.checkGoal();
    }
}
