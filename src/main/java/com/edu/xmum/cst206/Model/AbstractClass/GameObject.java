package com.edu.xmum.cst206.Model.AbstractClass;

/**
 * The superclass of all objects in the game.
 * Specifies properties that all game objects should have:
 * 1. Horizontal coordinate: x
 * 2. Vertical coordinate: y
 *
 * Specifies the methods that all game objects should have:
 * 1. Getter and setter methods for x and y coordinates
 */
public abstract class GameObject {
    protected int x;
    protected int y;

    /**
     * Constructor to initialize the coordinates of the game object.
     *
     * @param x The horizontal coordinate.
     * @param y The vertical coordinate.
     */
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the horizontal coordinate.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the horizontal coordinate.
     *
     * @param x The x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the vertical coordinate.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the vertical coordinate.
     *
     * @param y The y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
}
