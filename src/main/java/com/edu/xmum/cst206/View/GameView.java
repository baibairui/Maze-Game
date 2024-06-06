package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Model.GameModel;
import com.edu.xmum.cst206.Model.GameObject;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Service.GameService;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.layout.Pane;

/*
Controller层与View层进行交互
GameView是View层的主类
包含：
（1）各个游戏页面类
1.欢迎页面
2.难度页面
3.准备页面
4.游戏主页面
5.胜利页面
（2）GameController类
用来与Control层进行交互
 */
public class GameView extends BorderPane {
    private  GameController gameController;

    private WelcomeView welcomeView;
    private SelectionView selectionView;
    private PrepareView prepareView;
    private RunView runView;
    private VictoryView victoryView;
    public GameView(GameController gameController) {
        this.gameController=gameController;
        welcomeView = new WelcomeView();
        selectionView = new SelectionView();
        prepareView = new PrepareView();
        runView = new RunView(gameController);
        victoryView = new VictoryView();

        //设置初始视图
        showWelcomeView();
        //添加事件处理器
        addEventHandlers();
    }

    //添加事件处理器
    private void addEventHandlers() {
        /*
        addEventHandler需要传入事件类型和实现Handler接口的类
        1.事件类型
        这里我们要处理的事件类型是页面之间的切换->不是类中的原始事件类型->需要自己定义
        ->自定义事件ViewSwitchEvent
        2.实现Handler接口的类
        （1）匿名内部类的方法来实现
        （2）lamda表达式可以用来实现只有一个方法的接口
         */
        addEventHandler(ViewSwitchEvent.SWITCH_TO_WELCOME,event-> showWelcomeView());
        addEventHandler(ViewSwitchEvent.SWITCH_TO_PREPARE,event-> showPrepareView());
        addEventHandler(ViewSwitchEvent.SWITCH_TO_SELECTION, event-> showSelectionView());
        addEventHandler(ViewSwitchEvent.SWITCH_TO_RUN,event-> showRunView());
        addEventHandler(ViewSwitchEvent.SWITCH_TO_VICTIORY,event-> showVictoryView());
    }

    //用于事件绑定的函数
    public void showWelcomeView(){
        setCenter(welcomeView);
    }
    public void showSelectionView(){
        setCenter(selectionView);
    }
    public void showPrepareView(){
        setCenter(prepareView);
    }
    public void showRunView(){
        setCenter(runView);
    }
    public void showVictoryView(){
        setCenter(victoryView);
    }

    //相关的get和set方法
    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public WelcomeView getWelcomeView() {
        return welcomeView;
    }

    public void setWelcomeView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    public SelectionView getSelectionView() {
        return selectionView;
    }

    public void setSelectionView(SelectionView selectionView) {
        this.selectionView = selectionView;
    }

    public PrepareView getPrepareView() {
        return prepareView;
    }

    public void setPrepareView(PrepareView prepareView) {
        this.prepareView = prepareView;
    }

    public RunView getRunView() {
        return runView;
    }

    public void setRunView(RunView runView) {
        this.runView = runView;
    }

    public VictoryView getVictoryView() {
        return victoryView;
    }

    public void setVictoryView(VictoryView victoryView) {
        this.victoryView = victoryView;
    }
}