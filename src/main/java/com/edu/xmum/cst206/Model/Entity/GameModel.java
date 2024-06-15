package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;

public class GameModel implements IGameModel {
    //组合各个subModel
    private IPlayerModel playerModel;
    private IMazeModel mazeModel;
    private IPlayerModel aiModel;

    public GameModel(){
        this.mazeModel=new MazeModel(60,60);//先初始化为60,60
        this.playerModel=new PlayerModel(mazeModel);
        this.aiModel=new AiModel(mazeModel);
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
    @Override
    public IPlayerModel getAiModel(){return aiModel;}
}
