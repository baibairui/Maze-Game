package com.edu.xmum.cst206.Model.AbstractClass;

/*
The superclass of all objects in the game
Specifies properties that all game objects should have:
1. Horizontal coordinates: x
2. Vertical coordinate: y
---
Specifies the methods that all game objects should have：
1. get and set methods
 */
public abstract class GameObject {
    protected int x;
    protected int y;

    //constructor
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Related get and set methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
