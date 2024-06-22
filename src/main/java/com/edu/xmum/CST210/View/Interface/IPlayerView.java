package com.edu.xmum.CST210.View.Interface;

import Constant.Direction;
import javafx.scene.layout.Pane;

/**
 * Interface for PlayerView.
 * Specifies the methods that the PlayerView should implement.
 */
public interface IPlayerView {

    /**
     * Draws the player view for the first time.
     */
    void draw();

    /**
     * Redraws the player view, updating any changes.
     */
    void reDraw();

    /**
     * Sets the cell size for the player view.
     *
     * @param cellSize The size of each cell in the view.
     */
    void setCellSize(int cellSize);

    /**
     * Gets the main node of the player view.
     *
     * @return The Pane containing the player view.
     */
    Pane getNode();

    /**
     * Sets the direction for the player movement.
     *
     * @param direction The direction to set.
     */
    void setDirection(Direction direction);
}
