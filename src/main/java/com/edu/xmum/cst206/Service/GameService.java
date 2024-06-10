package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Difficulty;
import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IGameModel;
import com.edu.xmum.cst206.Service.Interface.IGameService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IPlayerService;

import java.util.ArrayList;
import java.util.List;

public class GameService implements IGameService {
    IGameModel gameModel;
    IMazeService mazeService;
    IPlayerService playerService;
    IGameController gameController;

    public GameService(IGameModel gameModel) {
        this.gameModel = gameModel;
        mazeService = new MazeService(gameModel.getMazeModel());
        playerService = new PlayerService(mazeService, gameModel.getPlayModel());
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        gameModel.getMazeModel().setRows(difficulty.getMazeSize());
        gameModel.getMazeModel().setCols(difficulty.getMazeSize());
    }

    @Override
    public void resetGame() {
        playerService.reset();
        mazeService.reset();
    }

    @Override
    public boolean checkGoal() {
        return playerService.checkGoal();
    }

    @Override
    public boolean movePlayer(Direction direction) {
        return playerService.movePlayer(direction.getDirectionX(), direction.getDirectionY());
    }

    @Override
    public IMazeService getMazeService() {
        return mazeService;
    }

    /*
    使用DFS来提示迷宫路线
     */

    private List<int[]> getPath(int x, int y) {
        /*
        path.get(i)[0]:纵坐标
        path.get(i)[1]:横坐标
         */
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[mazeService.getMaze().getRows()][mazeService.getMaze().getCols()];
        int startX = mazeService.getMaze().getStartX();
        int startY = mazeService.getMaze().getStartY();
        if (dfs(path, visited, startX, startY)) {
            path.add(new int[]{mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY()});
        }
        return path;
    }

    private boolean dfs(List<int[]> path, boolean[][] visited, int x, int y) {
        // 如果越界或已经访问过或是墙，则返回 false
        if (x < 0 || x >= mazeService.getMaze().getCols() || y < 0 || y >= mazeService.getMaze().getRows() || visited[y][x] || mazeService.getMaze().getMaze()[y][x] == 1) {
            return false;
        }

        // 标记为已访问
        visited[y][x] = true;

        // 添加当前点到路径
        path.add(new int[]{y, x});

        // 如果到达目标点，则返回 true
        if (x == mazeService.getMaze().getGoalX() && y == mazeService.getMaze().getGoalY()) {
            return true;
        }

        // 尝试四个方向的递归调用
        if (dfs(path, visited, x - 1, y) || dfs(path, visited, x + 1, y) || dfs(path, visited, x, y - 1) || dfs(path, visited, x, y + 1)) {
            return true;
        }

        // 如果没有找到路径，回溯并从路径中移除当前点
        path.remove(path.size() - 1);
        return false;
    }

    @Override
    public List<int[]> getHint() {
        return getPath(mazeService.getMaze().getGoalX(), mazeService.getMaze().getGoalY());
    }

    @Override
    public void setGameController(IGameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public IPlayerService getPlayerService() {
        return playerService;
    }
}
