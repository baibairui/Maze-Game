package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

import java.util.List;

/*
用于处理地图相关的逻辑
 */
public interface IMazeService {
    //检查玩家是否走的是通路
    public boolean isValidMove(IPlayerModel player, int dx, int dy);
    //检查玩家是否在迷宫边界内
    public boolean isWithinBounds(int x, int y);
    //检查当前位置是否是墙
    public boolean isPath(int X,int Y);
    //检查玩家是否通关
    public boolean hasReachedGoal(IPlayerModel player);
    //重置迷宫
    public void reset();
    IMazeModel getMaze();
    //提示路线
    public List<List<int[]>> getPath(int x, int y);
}
