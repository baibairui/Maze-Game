package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class PlayerModel extends GameObject implements IPlayerModel {
    private int startX;
    private int startY;

    public PlayerModel(IMazeModel mazeModel) {
        super(mazeModel.getStartX(), mazeModel.getStartY());
        this.startX = mazeModel.getStartX();
        this.startY = mazeModel.getStartY();
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
