package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Player;

public class PlayerService {
    private Player player;
    private MazeService mazeService;

    public PlayerService(Player player, MazeService mazeService) {
        this.player = player;
        this.mazeService = mazeService;
    }
    public Player getPlayer(){
        return player;
    }
    //检查移动是否有效
    //检查移动是否有效
    public boolean movePlayer(int dx, int dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
            System.out.println("X: "+player.getX()+" Y: "+player.getY());
            return checkGoal(); // 返回是否到达终点
        }
        return false; // 移动无效
    }
    //检查是否通关
    public boolean checkGoal() {
        return mazeService.hasReachedGoal(player);
    }
}
