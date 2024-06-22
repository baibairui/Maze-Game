package com.edu.xmum.CST210.Factory;

import Constant.Config;
import Constant.Skin;
import com.edu.xmum.CST210.Model.Entity.*;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;

/**
 * GameModelFactory is responsible for creating instances of game models, player models, and maze models.
 */
public class GameModelFactory extends AbstractFactory {

    /**
     * Creates and returns an instance of IGameModel based on the specified skin.
     *
     * @param playerModel The skin enumeration that determines which game model to create.
     * @return An instance of IGameModel.
     */
    @Override
    public IGameModel getGameModel(Skin playerModel) {
        if (playerModel.getSkin().equals("V3")) {
            return new GameModelVs();
        } else {
            return new GameModel();
        }
    }

    /**
     * Creates and returns an instance of IPlayerModel based on the specified player type and maze model.
     *
     * @param player    The type of player ("Player" or "AI").
     * @param mazeModel The maze model associated with the player.
     * @return An instance of IPlayerModel.
     */
    @Override
    public IPlayerModel getPlayerModel(String player, IMazeModel mazeModel) {
        if (player.equals("Player")) {
            return new PlayerModel(mazeModel);
        } else if (player.equals("AI")) {
            return new AiModel(mazeModel);
        }
        return null;
    }

    /**
     * Creates and returns an instance of IMazeModel based on the specified maze type.
     *
     * @param maze The type of maze.
     * @return An instance of IMazeModel.
     */
    @Override
    public IMazeModel getMazeModel(String maze) {
        if (maze.equals("Maze")) {
            return new MazeModel(Config.ROWS, Config.COLS);
        }
        return null;
    }
}
