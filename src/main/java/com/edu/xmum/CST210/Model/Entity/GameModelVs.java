package com.edu.xmum.CST210.Model.Entity;

import com.edu.xmum.CST210.Factory.FactoryProducer;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;

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

    /**
     * Serialize the game model to a string.
     *
     * @return The serialized game model.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Maze:").append(mazeModel.toString()).append(";");
        sb.append("Player:").append(playerModel.toString()).append(";");
        sb.append("SecondPlayer:").append(secondPlayerModel.toString());
        return sb.toString();
    }

    /**
     * Deserialize the game model from a string.
     *
     * @param data The serialized game model data.
     */
    @Override
    public void fromString(String data) {
        String[] parts = data.split(";");
        for (String part : parts) {
            if (part.startsWith("Maze:")) {
                mazeModel.fromString(part.substring(5));
            } else if (part.startsWith("Player:")) {
                playerModel.fromString(part.substring(7));
            } else if (part.startsWith("SecondPlayer:")) {
                secondPlayerModel.fromString(part.substring(13));
            }
        }
    }
}
