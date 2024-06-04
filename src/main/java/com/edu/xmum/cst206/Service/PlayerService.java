package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Player;

public class PlayerService {
    private Player player;
    private MazeService mazeService;

    //检查移动是否有效
    public void movePlayer(double dx, double dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
        }
    }
    //检查是否通关
    public boolean checkGoal() {
        return mazeService.hasReachedGoal(player);
    }
}
