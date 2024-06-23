package com.edu.xmum.CST210.Model.Entity;

import Constant.Direction;
import com.edu.xmum.CST210.Model.AbstractClass.GameObject;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;

/**
 * AI Model class representing an AI player in the game.
 * This class extends the GameObject class and implements the IPlayerModel interface.
 */
public class AiModel extends GameObject implements IPlayerModel {
    private final int startX;
    private final int startY;

    /**
     * Constructor to initialize the AI model with the starting position based on the maze model.
     *
     * @param mazeModel The maze model containing the maze structure and start position.
     */
    public AiModel(IMazeModel mazeModel) {
        super(mazeModel.getStartX(), mazeModel.getRows() - 1);
        this.startX = mazeModel.getStartX();
        this.startY = mazeModel.getRows() - 1;
    }

    /**
     * Gets the starting x-coordinate of the AI model.
     *
     * @return The starting x-coordinate.
     */
    @Override
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the starting y-coordinate of the AI model.
     *
     * @return The starting y-coordinate.
     */
    @Override
    public int getStartY() {
        return startY;
    }

    /**
     * Moves the AI model by the specified delta values.
     *
     * @param dx The delta x value.
     * @param dy The delta y value.
     */
    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Sets the position of the AI model to the specified coordinates.
     *
     * @param x The x-coordinate to set.
     * @param y The y-coordinate to set.
     */
    @Override
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void fromString(String data) {
        return;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setDirection(Direction direction) {

    }
}
