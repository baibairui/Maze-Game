package com.edu.xmum.CST210.Factory;

import Constant.Skin;
import com.edu.xmum.CST210.Controller.IGameController;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;
import com.edu.xmum.CST210.View.Entity.V1.*;
import com.edu.xmum.CST210.View.Entity.V2.*;
import com.edu.xmum.CST210.View.Entity.V3.*;
import com.edu.xmum.CST210.View.Interface.*;

/**
 * GameViewFactory is responsible for creating instances of different views (Victory, Maze, Run, Player, Prepare, Welcome, and Selection)
 * based on the specified skin.
 */
public class GameViewFactory extends AbstractFactory {

    /**
     * Creates and returns an instance of IVictoryView based on the specified skin.
     *
     * @param victoryView The skin enumeration that determines which victory view to create.
     * @return An instance of IVictoryView.
     */
    @Override
    public IVictoryView getVictoryView(Skin victoryView) {
        return switch (victoryView.getSkin()) {
            case "V1" -> new VictoryViewV1();
            case "V2" -> new VictoryViewV2();
            case "V3" -> new VictoryViewV3();
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of IMazeView based on the specified skin and maze model.
     *
     * @param maze      The skin enumeration that determines which maze view to create.
     * @param mazeModel The maze model associated with the maze view.
     * @return An instance of IMazeView.
     */
    @Override
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        return switch (maze.getSkin()) {
            case "V1" -> new MazeViewV1(mazeModel);
            case "V2" -> new MazeViewV2(mazeModel);
            case "V3" -> new MazeViewV3(mazeModel);
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of IRunView based on the specified skin and game controller.
     *
     * @param runView        The skin enumeration that determines which run view to create.
     * @param gameController The game controller associated with the run view.
     * @return An instance of IRunView.
     */
    @Override
    public IRunView getRunView(Skin runView, IGameController gameController) {
        return switch (runView.getSkin()) {
            case "V1" -> new RunViewV1(gameController);
            case "V2" -> new RunViewV2(gameController);
            case "V3" -> new RunViewV3(gameController);
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of IPlayerView based on the specified skin and player model.
     *
     * @param player      The skin enumeration that determines which player view to create.
     * @param playerModel The player model associated with the player view.
     * @return An instance of IPlayerView.
     */
    @Override
    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        return switch (player.getSkin()) {
            case "V1" -> new PlayerViewV1(playerModel);
            case "V2" -> new PlayerViewV2(playerModel);
            case "V3" -> new PlayerViewV3(playerModel);
            case "Vs" -> new SecondPlayerViewV3(playerModel);
            case "AI" -> new AiView(playerModel);
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of IPrepareView based on the specified skin.
     *
     * @param prepareView The skin enumeration that determines which prepare view to create.
     * @return An instance of IPrepareView.
     */
    @Override
    public IPrepareView getPrepareView(Skin prepareView) {
        return switch (prepareView.getSkin()) {
            case "V1" -> new PrepareViewV1();
            case "V2" -> new PrepareViewV2();
            case "V3" -> new PrepareViewV3();
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of IWelcomeView based on the specified skin.
     *
     * @param welcomeView The skin enumeration that determines which welcome view to create.
     * @return An instance of IWelcomeView.
     */
    @Override
    public IWelcomeView getWelcomeView(Skin welcomeView) {
        return switch (welcomeView.getSkin()) {
            case "V1" -> new WelComeViewV1();
            case "V2" -> new WelcomeViewV2();
            case "V3" -> new WelcomeViewV3();
            default -> null;
        };
    }

    /**
     * Creates and returns an instance of ISelectionView based on the specified skin.
     *
     * @param selectionView The skin enumeration that determines which selection view to create.
     * @return An instance of ISelectionView.
     */
    @Override
    public ISelectionView getSelectionView(Skin selectionView) {
        return switch (selectionView.getSkin()) {
            case "V1" -> new SelectionViewV1();
            case "V2" -> new SelectionViewV2();
            case "V3" -> new SelectionViewV3();
            default -> null;
        };
    }
}
