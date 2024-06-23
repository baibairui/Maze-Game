package com.edu.xmum.CST210.Model.Interface;

/**
 * Interface for PlayerModel.
 * Specifies the methods that should be unique to the PlayerModel.
 * These include methods for movement, setting position, and getting start and current coordinates.
 */
public interface IPlayerModel {
    /**
     * Gets the starting x-coordinate of the player model.
     *
     * @return The starting x-coordinate.
     */
    int getStartX();

    /**
     * Gets the starting y-coordinate of the player model.
     *
     * @return The starting y-coordinate.
     */
    int getStartY();

    /**
     * Moves the player model by the specified delta values.
     *
     * @param dx The delta x value.
     * @param dy The delta y value.
     */
    void move(int dx, int dy);

    /**
     * Sets the position of the player model to the specified coordinates.
     *
     * @param x The x-coordinate to set.
     * @param y The y-coordinate to set.
     */
    void setPosition(int x, int y);

    /**
     * Gets the current x-coordinate of the player model.
     *
     * @return The current x-coordinate.
     */
    int getX();

    /**
     * Gets the current y-coordinate of the player model.
     *
     * @return The current y-coordinate.
     */
    int getY();
    String toString();
    void fromString(String data);
}
