package com.edu.xmum.cst206.View.Interface;

import javafx.scene.layout.Pane;

public interface IPlayerView {
    void draw();
    void reDraw();
    void setCellSize(int cellSize);
    Pane getNode();
}
