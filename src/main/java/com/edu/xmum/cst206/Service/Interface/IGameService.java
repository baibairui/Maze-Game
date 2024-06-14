package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.GameService;

import java.util.List;

public interface IGameService {
    void setDifficulty(Difficulty difficulty);
    void resetGame();
    boolean movePlayer(Direction direction);
    IPlayerService getPlayerService();
    IMazeService getMazeService();
    //用来获得路径提示的方法
    List<List<int[]>> getHint();
    //用于依赖注入的方法
    void setGameController(IGameController gameController);
}
