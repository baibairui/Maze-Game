package com.edu.xmum.cst206.Model.Interface;

/**
 * Interface for the game model, which combines different sub-models such as player models and maze models.
 */
public interface IGameModel {
    /**
     * Gets the player model.
     *
     * @return The player model.
     */
    IPlayerModel getPlayModel();

    /**
     * Gets the maze model.
     *
     * @return The maze model.
     */
    IMazeModel getMazeModel();

    /**
     * Gets the AI model.
     *
     * @return The AI model, or null if not applicable.
     */
    IPlayerModel getAiModel();

    /**
     * Gets the second player model.
     *
     * @return The second player model, or null if not applicable.
     */
    IPlayerModel getSecondPlayModel();
}
