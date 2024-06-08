package com.edu.xmum.cst206.Controller;


import com.edu.xmum.cst206.Service.GameService;
import com.edu.xmum.cst206.View.GameView;
import com.edu.xmum.cst206.View.ViewSwitchEvent;

import java.util.Map;


/*
Control层用于接收View层的请求并与通过Service层处理相关逻辑

GameController是Control层的主类
包含：
View层的主类gameView
Service层的主类gameService

用于处理前端交互的请求并将后端的响应返回
 */
public class GameController {
    private GameService gameService;
    private GameView gameView;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private void initialize() {
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        gameView.getWelcomeView().getStartButton().setOnAction(event -> showSelectionView());
        gameView.getSelectionView().getEasyButton().setOnAction(event -> startGame("Easy"));
        gameView.getSelectionView().getMediumButton().setOnAction(event -> startGame("Medium"));
        gameView.getSelectionView().getHardButton().setOnAction(event -> startGame("Hard"));
        gameView.getPrepareView().getStartGameButton().setOnAction(event -> startMazeGame());
        gameView.getRunView().getResetButton().setOnAction(event -> resetGame());
        gameView.getRunView().getHintButton().setOnAction(event -> showHint());

        gameView.getRunView().setOnKeyPressed(event -> {
            boolean hasWon=false;
            switch (event.getCode()) {
                case W -> hasWon=movePlayerUp();
                case A -> hasWon=movePlayerLeft();
                case S -> hasWon=movePlayerDown();
                case D -> hasWon=movePlayerRight();
            }
            gameView.getRunView().getPlayerView().draw();
            if(hasWon){
                handleVictory();
            }
        });

        gameView.getRunView().setFocusTraversable(true);
    }

    private void checkVictory(){
        if (gameService.getPlayerService().checkGoal()) {
            handleVictory();
        }
    }
    private boolean movePlayerUp() {
        return gameService.getPlayerService().movePlayer(0, -1);
    }

    private boolean movePlayerDown() {
       return gameService.getPlayerService().movePlayer(0, 1);
    }

    private boolean movePlayerRight() {
       return gameService.getPlayerService().movePlayer(1, 0);
    }

    private boolean movePlayerLeft() {
        return gameService.getPlayerService().movePlayer(-1, 0);
    }

    private void showSelectionView() {
        gameView.fireEvent(new ViewSwitchEvent(ViewSwitchEvent.SWITCH_TO_SELECTION));
    }

    private void startGame(String difficulty) {
        Map<String,Integer>newParm= gameService.setDifficulty(difficulty);
        /*
        //重新计算格子的大小
        double cellWidth=getGameView().getRunView().getWidth()/newParm.get("NEWCOLS");
        double cellHeight=getGameView().getRunView().getHeight()/newParm.get("NEWROWS");
        double cellSize=Math.min(cellWidth,cellHeight);
        
         */
        //重新设定格子大小
        gameView.getRunView().getMazeView().setCellSize(cellSize);
        gameView.getRunView().getPlayerView().setCellSize(cellSize);
        gameView.getRunView().getMazeView().redraw();
        gameView.getRunView().getPlayerView().redraw();


        gameView.fireEvent(new ViewSwitchEvent(ViewSwitchEvent.SWITCH_TO_PREPARE));
    }

    private void startMazeGame() {
        gameView.fireEvent(new ViewSwitchEvent(ViewSwitchEvent.SWITCH_TO_RUN));
    }

    private void resetGame() {
        gameService.resetGame();
        gameView.getRunView().resetView();
        gameView.showRunView();
    }

    private void showHint() {
        gameService.provideHint();
    }

    public GameService getGameService() {
        return gameService;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
        initialize();
    }
    // 胜利处理方法
    public void handleVictory() {
        System.out.println("Victory!");
        gameView.showVictoryView();
    }
}