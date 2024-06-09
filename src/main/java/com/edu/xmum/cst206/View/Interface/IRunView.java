package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public interface IRunView {
    Button getResetButton();

    Button getHintButton();

    BorderPane getNode();

    IPlayerView getPlayerView();
    IMazeView getMazeView();

    void reSetView();
    public void adjustLayout();
}
