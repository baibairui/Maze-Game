package com.edu.xmum.cst206.View.Interface;

import javafx.scene.layout.Pane;

public interface IMazeView {
    void setCellSize(int cellSize);
    Pane getNode();
    void draw();
    void reDraw();
}
