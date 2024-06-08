package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.GameService;

public interface IGameService {
    void setDifficulty(Difficulty difficulty);
    void resetGame();
    boolean checkGoal();
    boolean movePlayer(Direction direction);
    IPlayerService getPlayerService();
    IMazeService getMazeService();
    //用于依赖注入的方法
    void setGameController(IGameController gameController);
}
