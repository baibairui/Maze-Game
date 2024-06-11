package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.View.Entity.V2.WelcomeViewV2;
import com.edu.xmum.cst206.View.Interface.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameView extends BorderPane implements IGameView {
    IWelcomeView welcomeView;
    ISelectionView selectionView;
    IPrepareView prepareView;
    IRunView runView;
    IVictoryView victoryView;
    IGameController gameController;
    private VBox SkinSelectionView;
    private void initSkin(){
        SkinSelectionView=new VBox();
        SkinSelectionView.setAlignment(Pos.CENTER);
        SkinSelectionView.setSpacing(20);
        Label label=new Label("选择你想用的皮肤");
        Button v1=new Button("V1");
        Button v2=new Button("V2");
        v1.setOnAction(e->{gameController.setSkinVision("V1");setCenter(welcomeView.getNode());});
        v2.setOnAction(e->{gameController.setSkinVision("V2");setCenter(welcomeView.getNode());});
        SkinSelectionView.getChildren().addAll(label,v1,v2);
    }
    public GameView(IGameController gameController) {
        this.gameController = gameController;
        initSkin();
        welcomeView = new WelcomeViewV2();
        /*
        selectionView = new SelectionView();
        prepareView = new PrepareView();
        runView = new RunView(gameController);
        victoryView = new VictoryView();
         */
        setCenter(SkinSelectionView);
    }

    @Override
    public void setGameController(IGameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public IWelcomeView getWelcomeView() {
        return welcomeView;
    }

    @Override
    public ISelectionView getSelectionView() {
        return selectionView;
    }

    @Override
    public IPrepareView getPrepareView() {
        return prepareView;
    }

    @Override
    public IRunView getRunView() {
        return runView;
    }

    @Override
    public IVictoryView getVictoryView() {
        return victoryView;
    }

    @Override
    public BorderPane getView() {
        return this;
    }

    @Override
    public void showVictoryView() {
        setCenter(victoryView.getNode());
    }

    @Override
    public void showSelectionView() {
        setCenter(selectionView.getNode());
    }

    @Override
    public void showPrepareView() {
        setCenter(prepareView.getNode());
    }

    @Override
    public void showRunView() {
        setCenter(runView.getNode());
    }
    //set注入

    public void setWelcomeView(IWelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    public void setSelectionView(ISelectionView selectionView) {
        this.selectionView = selectionView;
    }

    public void setPrepareView(IPrepareView prepareView) {
        this.prepareView = prepareView;
    }

    public void setRunView(IRunView runView) {
        this.runView = runView;
    }

    public void setVictoryView(IVictoryView victoryView) {
        this.victoryView = victoryView;
    }
}