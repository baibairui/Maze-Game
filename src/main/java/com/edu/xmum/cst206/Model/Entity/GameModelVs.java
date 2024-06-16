package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class GameModelVs implements IGameModel {
    //组合各个subModel
    private IPlayerModel playerModel;
    private IMazeModel mazeModel;
    private IPlayerModel secondPlayerModel;

    public GameModelVs(){
        this.mazeModel=new MazeModel(60,60);//先初始化为60,60
        this.playerModel=new PlayerModel(mazeModel);
        this.secondPlayerModel=new PlayerModel(mazeModel);
    }
    //获取playerModel和MazeModel
    @Override
    public IPlayerModel getPlayModel() {
        return playerModel;
    }
    @Override
    public IMazeModel getMazeModel() {
        return mazeModel;
    }
    //该版本不需要ai
    @Override
    public IPlayerModel getAiModel(){return null;}
    @Override
    public IPlayerModel getSecondPlayModel() {
        return secondPlayerModel;
    }
}
