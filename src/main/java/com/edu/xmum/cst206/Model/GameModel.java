package com.edu.xmum.cst206.Model;

public class GameModel {
    private Maze maze;
    private Player player;

    public GameModel(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
