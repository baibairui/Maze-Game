package com.edu.xmum.cst206.View.Interface;

import Constant.Direction;
import javafx.scene.layout.Pane;

public interface IPlayerView {
    void draw();

    void reDraw();

    void setCellSize(int cellSize);

    Pane getNode();

    //控制方向
    void setDirection(Direction direction);
}
