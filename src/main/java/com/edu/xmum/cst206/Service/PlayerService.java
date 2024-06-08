package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
public class PlayerService implements IPlayerService {
    private IPlayerModel player;
    private IMazeService mazeService;

    // 依赖注入
    public PlayerService(IMazeService maze, IPlayerModel playerModel) {
        this.player = playerModel;
        this.mazeService = maze;
    }

    @Override
    public boolean movePlayer(int dx, int dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
            System.out.println("X: " + player.getX() + " Y: " + player.getY());
            return checkGoal(); // 返回是否到达终点
        }
        return false; // 移动无效
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
