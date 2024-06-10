package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.View.Entity.V2.WelcomeViewNew;
import com.edu.xmum.cst206.View.Interface.*;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane implements IGameView {
    IWelcomeView welcomeView;
    ISelectionView selectionView;
    IPrepareView prepareView;
    IRunView runView;
    IVictoryView victoryView;
    IGameController gameController;

    public GameView(IGameController gameController) {
        this.gameController = gameController;
        welcomeView = new WelcomeViewNew();
        /*
        selectionView = new SelectionView();
        prepareView = new PrepareView();
        runView = new RunView(gameController);
        victoryView = new VictoryView();
         */
        setCenter(welcomeView.getNode());
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