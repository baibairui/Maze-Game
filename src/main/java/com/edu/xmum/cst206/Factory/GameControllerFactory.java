package com.edu.xmum.cst206.Factory;

import Constant.Skin;
import com.edu.xmum.cst206.Controller.GameController;
import com.edu.xmum.cst206.Controller.GameControllerVs;
import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Service.Interface.IGameService;

/**
 * GameControllerFactory is responsible for creating instances of IGameController.
 */
public class GameControllerFactory extends AbstractFactory {

    /**
     * Creates and returns an instance of IGameController based on the specified skin.
     * @param gameController The skin enumeration that determines which controller to create.
     * @param gameService The game service to be used by the controller.
     * @return An instance of IGameController.
     */
    @Override
    public IGameController getGameController(Skin gameController, IGameService gameService) {
        if (gameController.getSkin().equals("V3")) {
            return new GameControllerVs(gameService);
        } else {
            return new GameController(gameService);
        }
    }
}
