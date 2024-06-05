package com.edu.xmum.cst206.Controller;

import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;
import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.Service.MazeService;
import com.edu.xmum.cst206.Service.PlayerService;
import com.edu.xmum.cst206.View.GameView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/*
Control层用于接收View层的请求并与通过Service层处理相关逻辑

GameController是Control层的主类
包含：
View层的主类gameView
Service层的主类gameService

用于处理前端交互的请求并将后端的响应返回
 */
public class GameController {
    private GameView gameView;
    private GameService gameService;
    public GameController(GameService gameService, GameView gameView){
        this.gameService=gameService;
        this.gameView=gameView;
        //初始化地图

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

    // 检查玩家是否到达终点
    public boolean checkGoal() {
        return gameService.playerService.checkGoal();
    }
    public GameService getGameService(){
        return gameService;
    }
}
