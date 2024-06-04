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
}
