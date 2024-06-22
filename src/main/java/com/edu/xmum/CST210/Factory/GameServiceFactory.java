package com.edu.xmum.CST210.Factory;

import Constant.Skin;
import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;
import com.edu.xmum.CST210.Service.*;
import com.edu.xmum.CST210.Service.Interface.IAiService;
import com.edu.xmum.CST210.Service.Interface.IGameService;
import com.edu.xmum.CST210.Service.Interface.IMazeService;
import com.edu.xmum.CST210.Service.Interface.IPlayerService;

/**
 * GameServiceFactory is responsible for creating instances of game services, player services, AI services, and maze services.
 */
public class GameServiceFactory extends AbstractFactory {

    /**
     * Creates and returns an instance of IGameService based on the specified skin.
     *
     * @param gameService The skin enumeration that determines which game service to create.
     * @param gameModel   The game model associated with the game service.
     * @return An instance of IGameService.
     */
    @Override
    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        if (gameService.getSkin() == null) return null;
        if (gameService.getSkin().equals("V3")) {
            return new GameServiceVs(gameModel);
        } else {
            return new GameService(gameModel);
        }
    }

    /**
     * Creates and returns an instance of IPlayerService based on the specified vision, player model, and maze service.
     *
     * @param vision      The type of player service ("Player").
     * @param playerModel The player model associated with the player service.
     * @param mazeService The maze service associated with the player service.
     * @return An instance of IPlayerService.
     */
    @Override
    public IPlayerService getPlayerService(String vision, IPlayerModel playerModel, IMazeService mazeService) {
        if (vision.equals("Player")) {
            return new PlayerService(mazeService, playerModel);
        }
        return null;
    }

    /**
     * Creates and returns an instance of IAiService based on the specified vision, maze service, player model, and AI model.
     *
     * @param vision      The type of AI service ("AI").
     * @param mazeService The maze service associated with the AI service.
     * @param playModel   The player model associated with the AI service.
     * @param aiModel     The AI model associated with the AI service.
     * @return An instance of IAiService.
     */
    @Override
    public IAiService getAiService(String vision, IMazeService mazeService, IPlayerModel playModel, IPlayerModel aiModel) {
        if (vision.equals("AI")) {
            return new AiService(mazeService, playModel, aiModel);
        }
        return null;
    }

    /**
     * Creates and returns an instance of IMazeService based on the specified vision and maze model.
     *
     * @param vision    The type of maze service ("Maze").
     * @param mazeModel The maze model associated with the maze service.
     * @return An instance of IMazeService.
     */
    @Override
    public IMazeService getMazeService(String vision, IMazeModel mazeModel) {
        if (vision.equals("Maze")) {
            return new MazeService(mazeModel);
        }
        return null;
    }
}
