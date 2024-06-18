package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.util.List;

/**
 * Interface for RunView.
 * Specifies the methods that the RunView should implement.
 */
public interface IRunView {

    /**
     * Gets the reset button in the RunView.
     *
     * @return The reset button.
     */
    Button getResetButton();

    /**
     * Gets the hint button in the RunView.
     *
     * @return The hint button.
     */
    Button getHintButton();

    /**
     * Gets the root node of the RunView.
     *
     * @return The BorderPane root node.
     */
    BorderPane getNode();

    /**
     * Gets the player view in the RunView.
     *
     * @return The player view.
     */
    IPlayerView getPlayerView();

    /**
     * Gets the maze view in the RunView.
     *
     * @return The maze view.
     */
    IMazeView getMazeView();

    /**
     * Gets the AI view in the RunView.
     *
     * @return The AI view.
     */
    IPlayerView getAiView();

    /**
     * Gets the second player view in the RunView.
     *
     * @return The second player view.
     */
    IPlayerView getSecondPlayerView();

    /**
     * Resets the view, updating any changes.
     */
    void reSetView();

    /**
     * Adjusts the layout of the RunView.
     */
    void adjustLayout();

    /**
     * Displays the hint path in the RunView.
     *
     * @param path The path to show as a hint.
     */
    void showHint(List<int[]> path);
}
