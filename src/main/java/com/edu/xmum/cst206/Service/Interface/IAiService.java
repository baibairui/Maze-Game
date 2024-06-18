package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

/**
 * Interface for AI service.
 * Specifies the methods that the AI service should implement.
 * These include methods for moving the AI, checking if the player is caught, getting the AI model, and resetting the AI.
 */
public interface IAiService {
    /**
     * Moves the AI according to its algorithm.
     */
    void moveAi();

    /**
     * Checks if the AI has caught the player.
     *
     * @return True if the player is caught, false otherwise.
     */
    boolean isPlayerCaught();

    /**
     * Gets the AI model.
     *
     * @return The AI model.
     */
    IPlayerModel getAiModel();

    /**
     * Resets the AI to its initial state.
     */
    void reset();
}
