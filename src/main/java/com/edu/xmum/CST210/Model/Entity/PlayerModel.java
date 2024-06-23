package com.edu.xmum.CST210.Model.Entity;

import com.edu.xmum.CST210.Model.AbstractClass.GameObject;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;
import Constant.Direction;

/**
 * PlayerModel class representing a player in the game.
 * This class extends the GameObject class and implements the IPlayerModel interface.
 */
public class PlayerModel extends GameObject implements IPlayerModel {
    private final int startX;
    private final int startY;
    private Direction direction;

    /**
     * Constructor to initialize the PlayerModel with the starting position based on the maze model.
     *
     * @param mazeModel The maze model containing the maze structure and start position.
     */
    public PlayerModel(IMazeModel mazeModel) {
        super(mazeModel.getStartX(), mazeModel.getStartY());
        this.startX = mazeModel.getStartX();
        this.startY = mazeModel.getStartY();
        this.direction = Direction.UP; // Assuming default direction is UP
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

    /**
     * Gets the direction of the player model.
     *
     * @return The direction.
     */
    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the player model.
     *
     * @param direction The direction to set.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + direction.name();
    }

    @Override
    public void fromString(String data) {
        String[] parts = data.split(",");
        this.x = Integer.parseInt(parts[0]);
        this.y = Integer.parseInt(parts[1]);
        this.direction = Direction.valueOf(parts[2]);
    }
}
