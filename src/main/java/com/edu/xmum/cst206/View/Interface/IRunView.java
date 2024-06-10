package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.util.List;

public interface IRunView {
    Button getResetButton();

    Button getHintButton();

    BorderPane getNode();

    IPlayerView getPlayerView();
    IMazeView getMazeView();

    void reSetView();
    public void adjustLayout();
    public void showHint(List<int[]> path);
}
