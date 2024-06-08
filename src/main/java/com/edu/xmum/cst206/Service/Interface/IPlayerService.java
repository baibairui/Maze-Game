package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public interface IPlayerService {
    //检查移动是否有效
    public boolean movePlayer(int dx, int dy);
    //检查是否通关
    public boolean checkGoal();
    //获取Player对象实例
    public IPlayerModel getPlayer();
    //重置玩家位置
    public void reset();
    //获取地图实例
    IMazeModel getMaze();
}
