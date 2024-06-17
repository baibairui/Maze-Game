package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class AiModel extends GameObject implements IPlayerModel {
    private int startX;
    private int startY;

    public AiModel(IMazeModel mazeModel) {
        super(mazeModel.getStartX(), mazeModel.getRows() - 1);
        this.startX = mazeModel.getStartX();
        this.startY = mazeModel.getRows() - 1;
    }

    @Override
    public int getStartX() {
        return startX;
    }

    @Override
    public int getStartY() {
        return startY;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
}
