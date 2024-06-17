package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;

public class GameModel implements IGameModel {
    //组合各个subModel
    private IPlayerModel playerModel;
    private IMazeModel mazeModel;
    private IPlayerModel aiModel;

    public GameModel() {
        this.mazeModel = FactoryProducer.getFactory("GameModel").getMazeModel("Maze");
        this.playerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player",mazeModel);
        this.aiModel =FactoryProducer.getFactory("GameModel").getPlayerModel("AI",mazeModel);
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
    public IPlayerModel getAiModel() {
        return aiModel;
    }

    //该版本不需要
    @Override
    public IPlayerModel getSecondPlayModel() {
        return null;
    }
}
