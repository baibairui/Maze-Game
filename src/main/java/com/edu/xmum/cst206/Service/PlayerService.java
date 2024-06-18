package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public class PlayerService implements IPlayerService {
    private IPlayerModel player;
    private IMazeService mazeService;

    // dependency injection
    public PlayerService(IMazeService maze, IPlayerModel playerModel) {
        this.player = playerModel;
        this.mazeService = maze;
    }

    @Override
    public boolean movePlayer(int dx, int dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
            System.out.println("X: " + player.getX() + " Y: " + player.getY());
            return checkGoal(); // Returns whether or not the end point has been reached
        }
        return false; // Mobile Invalid
    }

    @Override
    public boolean checkGoal() {
        return mazeService.hasReachedGoal(player);
    }

    @Override
    public IPlayerModel getPlayer() {
        return player;
    }

    @Override
    public void reset() {
        player.setPosition(player.getStartX(), player.getStartY());
    }

    @Override
    public IMazeModel getMaze() {
        return mazeService.getMaze();
    }
}

