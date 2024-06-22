package com.edu.xmum.CST210.View.Entity;

import Constant.Config;
import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.View.Interface.*;
import javafx.scene.layout.BorderPane;

/**
 * Implementation of the game view.
 * This class is responsible for managing and displaying different views of the game.
 */
public class GameView extends BorderPane implements IGameView {
    private IWelcomeView welcomeView;
    private ISelectionView selectionView;
    private IPrepareView prepareView;
    private IRunView runView;
    private IVictoryView victoryView;
    private IFailView failView;

    /**
     * Constructor to initialize the GameView components.
     */
    public GameView() {
        this.welcomeView = FactoryProducer.getFactory("GameView").getWelcomeView(Config.skin);
        setCenter(welcomeView.getNode());
    }

    @Override
    public IWelcomeView getWelcomeView() {
        return welcomeView;
    }

    /**
     * Sets the welcome view.
     *
     * @param welcomeView The welcome view to set.
     */
    @Override
    public void setWelcomeView(IWelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    @Override
    public ISelectionView getSelectionView() {
        return selectionView;
    }

    /**
     * Sets the selection view.
     *
     * @param selectionView The selection view to set.
     */
    @Override
    public void setSelectionView(ISelectionView selectionView) {
        this.selectionView = selectionView;
    }

    @Override
    public IPrepareView getPrepareView() {
        return prepareView;
    }

    /**
     * Sets the prepare view.
     *
     * @param prepareView The prepare view to set.
     */
    @Override
    public void setPrepareView(IPrepareView prepareView) {
        this.prepareView = prepareView;
    }

    @Override
    public IRunView getRunView() {
        return runView;
    }

    /**
     * Sets the run view.
     *
     * @param runView The run view to set.
     */
    @Override
    public void setRunView(IRunView runView) {
        this.runView = runView;
    }

    @Override
    public IVictoryView getVictoryView() {
        return victoryView;
    }

    /**
     * Sets the victory view.
     *
     * @param victoryView The victory view to set.
     */
    @Override
    public void setVictoryView(IVictoryView victoryView) {
        this.victoryView = victoryView;
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
}
