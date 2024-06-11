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
    IVictoryView getVictoryView();
    BorderPane getView();


    void showVictoryView();

    void showSelectionView();

    void showPrepareView();

    void showRunView();
    public void setWelcomeView(IWelcomeView welcomeView) ;

    public void setSelectionView(ISelectionView selectionView);

    public void setPrepareView(IPrepareView prepareView);

    public void setRunView(IRunView runView);

    public void setVictoryView(IVictoryView victoryView);

}
