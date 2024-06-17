package com.edu.xmum.cst206.Service.Interface;

import Constant.Difficulty;
import Constant.Direction;

import java.util.List;

public interface IGameService {
    void setDifficulty(Difficulty difficulty);

    void resetGame();

    boolean movePlayer(Direction direction);

    //获取子模块
    IPlayerService getPlayerService();

    IAiService getAiService();

    IMazeService getMazeService();

    IPlayerService getSecondPlayerService();

    //用来获得路径提示的方法
    List<int[]> getHint();

    boolean moveSecondPlayer(Direction direction);
}
