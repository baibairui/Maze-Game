package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.VBox;

public interface ISelectionView {
    Button getEasyButton();

    Button getMediumButton();

    Button getHardButton();

    VBox getNode();
}
