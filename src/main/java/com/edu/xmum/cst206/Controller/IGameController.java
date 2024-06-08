package com.edu.xmum.cst206.Controller;

/*
Control层用于接收View层的请求并与通过Service层处理相关逻辑

GameController是Control层的主类
包含：
View层的主类gameView
Service层的主类gameService

用于处理前端交互的请求并将后端的响应返回
*/

import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Interface.IGameView;

public interface IGameController {
    void startGame();
    void resetGame();
    void setDifficulty(String difficulty);
    void handleKeyPress(String key);
    void showSelectionView();
    void showPrepareView();
    void showRunView();
    void showVictoryView();
    void showHint();
    void setGameView(IGameView gameView);
    IGameService getGameService();
}
