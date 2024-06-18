package com.edu.xmum.cst206.Model.Interface;

/*
PlayerModel's interface
Specifies the methods that should be unique to the PlayModel：
1.move
2.setPosition

 */
public interface IPlayerModel {
    int getStartX();

    int getStartY();

    void move(int dx, int dy);

    void setPosition(int x, int y);

    int getX();

    int getY();
}
