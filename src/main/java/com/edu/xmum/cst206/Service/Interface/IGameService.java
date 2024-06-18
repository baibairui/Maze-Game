package com.edu.xmum.cst206.Service.Interface;

import Constant.Difficulty;
import Constant.Direction;

import java.util.List;

public interface IGameService {
    void setDifficulty(Difficulty difficulty);

    void resetGame();

    boolean movePlayer(Direction direction);

    //Get Submodule
    IPlayerService getPlayerService();

    IAiService getAiService();

    IMazeService getMazeService();

    IPlayerService getSecondPlayerService();

    //Methods used to get path hints
    List<int[]> getHint();

    boolean moveSecondPlayer(Direction direction);
}
