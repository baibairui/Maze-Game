package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Factory.FactoryProducer;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

/**
 * GameModelVs class that implements IGameModel.
 * This class combines different sub-models such as the player model, maze model, and second player model for a versus game mode.
 */
public class GameModelVs implements IGameModel {
    // Combining sub-models
    private final IPlayerModel playerModel;
    private final IMazeModel mazeModel;
    private final IPlayerModel secondPlayerModel;

    /**
     * Constructor to initialize the GameModelVs with player, maze, and second player models.
     */
    public GameModelVs() {
        this.mazeModel = FactoryProducer.getFactory("GameModel").getMazeModel("Maze");
        this.playerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player", mazeModel);
        this.secondPlayerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player", mazeModel);
    }

    /**
     * Gets the player model.
     *
     * @return The player model.
     */
    @Override
    public IPlayerModel getPlayModel() {
        return playerModel;
    }

    /**
     * Gets the maze model.
     *
     * @return The maze model.
     */
    @Override
    public IMazeModel getMazeModel() {
        return mazeModel;
    }

    /**
     * This version does not require an AI model.
     *
     * @return Null.
     */
    @Override
    public IPlayerModel getAiModel() {
        return null;
    }

    /**
     * Gets the second player model.
     *
     * @return The second player model.
     */
    @Override
    public IPlayerModel getSecondPlayModel() {
        return secondPlayerModel;
    }
}
