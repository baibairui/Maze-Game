package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public interface IVictoryView {
    Button getBackButton();

    VBox getNode();

    void setWinner(String winner);
}
