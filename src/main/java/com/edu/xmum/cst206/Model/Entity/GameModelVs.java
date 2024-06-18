package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class GameModelVs implements IGameModel {
    //Combining subModels
    private IPlayerModel playerModel;
    private IMazeModel mazeModel;
    private IPlayerModel secondPlayerModel;

    public GameModelVs() {
        this.mazeModel = FactoryProducer.getFactory("GameModel").getMazeModel("Maze");
        this.playerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player",mazeModel);
        this.secondPlayerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player",mazeModel);
    }

    //Get playerModel and MazeModel
    @Override
    public IPlayerModel getPlayModel() {
        return playerModel;
    }

    @Override
    public IMazeModel getMazeModel() {
        return mazeModel;
    }

    //This version does not require ai
    @Override
    public IPlayerModel getAiModel() {
        return null;
    }

    @Override
    public IPlayerModel getSecondPlayModel() {
        return secondPlayerModel;
    }
}
