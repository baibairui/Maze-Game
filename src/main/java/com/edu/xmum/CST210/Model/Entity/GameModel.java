package com.edu.xmum.CST210.Model.Entity;

import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;

/**
 * GameModel class that implements IGameModel.
 * This class combines different sub-models such as the player model, maze model, and AI model.
 */
public class GameModel implements IGameModel {
    // Combining sub-models
    private final IPlayerModel playerModel;
    private final IMazeModel mazeModel;
    private final IPlayerModel aiModel;

    /**
     * Constructor to initialize the GameModel with player, maze, and AI models.
     */
    public GameModel() {
        this.mazeModel = FactoryProducer.getFactory("GameModel").getMazeModel("Maze");
        this.playerModel = FactoryProducer.getFactory("GameModel").getPlayerModel("Player", mazeModel);
        this.aiModel = FactoryProducer.getFactory("GameModel").getPlayerModel("AI", mazeModel);
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
     * Gets the AI model.
     *
     * @return The AI model.
     */
    @Override
    public IPlayerModel getAiModel() {
        return aiModel;
    }

    /**
     * This method is not needed in this version and returns null.
     *
     * @return Null.
     */
    @Override
    public IPlayerModel getSecondPlayModel() {
        return null;
    }
}
