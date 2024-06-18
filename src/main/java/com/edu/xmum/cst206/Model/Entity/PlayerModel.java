package com.edu.xmum.cst206.Model.Entity;

import com.edu.xmum.cst206.Model.AbstractClass.GameObject;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

/**
 * PlayerModel class representing a player in the game.
 * This class extends the GameObject class and implements the IPlayerModel interface.
 */
public class PlayerModel extends GameObject implements IPlayerModel {
    private final int startX;
    private final int startY;

    /**
     * Constructor to initialize the PlayerModel with the starting position based on the maze model.
     *
     * @param mazeModel The maze model containing the maze structure and start position.
     */
    public PlayerModel(IMazeModel mazeModel) {
        super(mazeModel.getStartX(), mazeModel.getStartY());
        this.startX = mazeModel.getStartX();
        this.startY = mazeModel.getStartY();
    }

    /**
     * Gets the starting x-coordinate of the player model.
     *
     * @return The starting x-coordinate.
     */
    @Override
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the starting y-coordinate of the player model.
     *
     * @return The starting y-coordinate.
     */
    @Override
    public int getStartY() {
        return startY;
    }

    /**
     * Moves the player model by the specified delta values.
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
     * Sets the position of the player model to the specified coordinates.
     *
     * @param x The x-coordinate to set.
     * @param y The y-coordinate to set.
     */
    @Override
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
}
