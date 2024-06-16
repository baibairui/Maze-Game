package com.edu.xmum.cst206.View.Entity;

import com.edu.xmum.cst206.Config;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.View.Interface.*;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane implements IGameView {
    private IWelcomeView welcomeView;
    private ISelectionView selectionView;
    private IPrepareView prepareView;
    private IRunView runView;
    private IVictoryView victoryView;
    private IGameController gameController;
    private IFailView failView;

    public GameView(IGameController gameController) {
        this.gameController = gameController;
        this.welcomeView=FactoryProducer.getFactory("Welcome").getWelcomeView(Config.skin);
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

    @Override
    public void showWelcomeView() {
        setCenter(welcomeView.getNode());
    }

    @Override
    public IFailView getFailView() {
        return failView;
    }

    @Override
    public void setFailView(IFailView failView) {
        this.failView = failView;
    }

    @Override
    public void showFailView() {
        setCenter(failView.getNode());
    }

    // Setters for other views
    @Override
    public void setWelcomeView(IWelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    @Override
    public void setSelectionView(ISelectionView selectionView) {
        this.selectionView = selectionView;
    }

    @Override
    public void setPrepareView(IPrepareView prepareView) {
        this.prepareView = prepareView;
    }

    @Override
    public void setRunView(IRunView runView) {
        this.runView = runView;
    }

    @Override
    public void setVictoryView(IVictoryView victoryView) {
        this.victoryView = victoryView;
    }
}
