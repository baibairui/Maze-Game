package com.edu.xmum.CST210.View.Interface;

import javafx.scene.layout.BorderPane;

/**
 * Interface for GameView.
 * Specifies the methods that the GameView should implement.
 */
public interface IGameView {
    /**
     * Gets the welcome view.
     *
     * @return The welcome view.
     */
    IWelcomeView getWelcomeView();

    /**
     * Sets the welcome view.
     *
     * @param welcomeView The welcome view to set.
     */
    void setWelcomeView(IWelcomeView welcomeView);

    /**
     * Gets the selection view.
     *
     * @return The selection view.
     */
    ISelectionView getSelectionView();

    /**
     * Sets the selection view.
     *
     * @param selectionView The selection view to set.
     */
    void setSelectionView(ISelectionView selectionView);

    /**
     * Gets the prepare view.
     *
     * @return The prepare view.
     */
    IPrepareView getPrepareView();

    /**
     * Sets the prepare view.
     *
     * @param prepareView The prepare view to set.
     */
    void setPrepareView(IPrepareView prepareView);

    /**
     * Gets the run view.
     *
     * @return The run view.
     */
    IRunView getRunView();

    /**
     * Sets the run view.
     *
     * @param runView The run view to set.
     */
    void setRunView(IRunView runView);

    /**
     * Gets the victory view.
     *
     * @return The victory view.
     */
    IVictoryView getVictoryView();

    /**
     * Sets the victory view.
     *
     * @param victoryView The victory view to set.
     */
    void setVictoryView(IVictoryView victoryView);

    /**
     * Gets the fail view.
     *
     * @return The fail view.
     */
    IFailView getFailView();

    /**
     * Sets the fail view.
     *
     * @param failView The fail view to set.
     */
    void setFailView(IFailView failView);

    /**
     * Gets the main view node.
     *
     * @return The BorderPane main view node.
     */
    BorderPane getView();

    /**
     * Shows the victory view.
     */
    void showVictoryView();

    /**
     * Shows the selection view.
     */
    void showSelectionView();

    /**
     * Shows the prepare view.
     */
    void showPrepareView();

    /**
     * Shows the run view.
     */
    void showRunView();

    /**
     * Shows the welcome view.
     */
    void showWelcomeView();

    /**
     * Shows the fail view.
     */
    void showFailView();
}
