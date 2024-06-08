package com.edu.xmum.cst206.View.Interface;

import com.edu.xmum.cst206.Controller.IGameController;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public interface IGameView {

    void setGameController(IGameController gameController);
    IWelcomeView getWelcomeView();

    ISelectionView getSelectionView();

    IPrepareView getPrepareView();

    IRunView getRunView();

    BorderPane getView();

    void showVictoryView();

    void showSelectionView();

    void showPrepareView();

    void showRunView();

}
