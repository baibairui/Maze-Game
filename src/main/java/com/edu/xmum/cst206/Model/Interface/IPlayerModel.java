package com.edu.xmum.cst206.Model.Interface;

/*
PlayerModel的接口
规定了PlayModel应特有的方法：
1.move
2.setPosition

 */
public interface IPlayerModel {
    int getStartX();
    int getStartY();
    void move(int dx,int dy);
    void setPosition(int x,int y);
    int getX();
    int getY();
}
