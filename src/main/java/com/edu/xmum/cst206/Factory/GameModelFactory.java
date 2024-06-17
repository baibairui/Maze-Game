package com.edu.xmum.cst206.Factory;

import Constant.Config;
import com.edu.xmum.cst206.Model.Entity.*;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class GameModelFactory extends AbstractFactory {
    @Override
    public IGameModel getGameModel(Skin playerModel) {
        if (playerModel.getSkin().equals("V3")) {
            return new GameModelVs();
        } else {
            return new GameModel();
        }
    }
    @Override
    public IPlayerModel getPlayerModel(String player,IMazeModel mazeModel){
        if(player.equals("Player")){
            return new PlayerModel(mazeModel);
        }else if(player.equals("AI")){
            return new AiModel(mazeModel);
        }
        return null;
    }
    @Override
    public IMazeModel getMazeModel(String maze){
        if(maze.equals("Maze")){
            return new MazeModel(Config.ROWS,Config.COLS);
        }
        return null;
    }
}
