package com.edu.xmum.cst206.Controller;

/*
Control layer is used to receive requests from the View layer and process related logic through the Service layer.

GameController is the main class of the Control layer.
Contains:
- The main class of the View layer: gameView
- The main class of the Service layer: gameService

Used to process requests for front-end interactions and return back-end responses.
*/

import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.View.Interface.IGameView;

public interface IGameController {

    /**
     * Starts the game by initializing necessary components and setting up the initial state.
     */
    void startGame();

    /**
     * Resets the game to its initial state.
     */
    void resetGame();

    /**
     * Handles key press events to control game actions.
     *
     * @param key The key pressed by the user.
     */
    void handleKeyPress(String key);

    /**
     * Displays the selection view where users can choose game settings.
     */
    void showSelectionView();

    /**
     * Displays the preparation view before starting the game.
     */
    void showPrepareView();

    /**
     * Displays the main game view where the game is played.
     */
    void showRunView();

    /**
     * Displays the victory view when the player wins the game.
     *
     * @param winner The winner of the game.
     */
    void showVictoryView(String winner);

    /**
     * Displays a hint to the player during the game.
     */
    void showHint();

    /**
     * Displays the failure view when the player loses the game.
     */
    void showFailureView();

    /**
     * Sets the game view, which is responsible for the user interface.
     *
     * @param gameView The game view to set.
     */
    void setGameView(IGameView gameView);

    /**
     * Gets the current difficulty level of the game.
     *
     * @return The current difficulty level.
     */
    String getDifficulty();

    /**
     * Sets the difficulty level of the game.
     *
     * @param difficulty The difficulty level to set (e.g., Easy, Medium, Hard).
     */
    void setDifficulty(String difficulty);

    /**
     * Gets the game service, which handles game logic and operations.
     *
     * @return The game service.
     */
    IGameService getGameService();

    /**
     * Starts the AI movement in the game.
     */
    void startAiMovement();
}
