package com.edu.xmum.cst206.Controller;

/*
Control层用于接收View层的请求并与通过Service层处理相关逻辑

GameController is the main class of the Control layer.
contains:
The main class of the View layer gameView
The main class of the Service layer, gameService.

Used to process requests for front-end interactions and return back-end responses
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

    void showVictoryView(String winner);

    void showHint();

    void showFailureView();

    void setGameView(IGameView gameView);

    String getDiffculty();

    IGameService getGameService();

    void startAiMovement();
}
