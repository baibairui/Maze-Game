package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.Service.Interface.IFindPathStrategy;

import java.util.ArrayList;
import java.util.List;

public class AiService implements IAiService {
    private final IMazeService mazeService;
    private final IPlayerModel player;
    private final IPlayerModel ai;

    public AiService(IMazeService mazeService, IPlayerModel playerModel, IPlayerModel aiModel) {
        this.mazeService = mazeService;
        this.player = playerModel;
        this.ai = aiModel;
    }

    @Override
    public void moveAi() {
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[mazeService.getMaze().getRows()][mazeService.getMaze().getCols()];
        IFindPathStrategy findPathStrategy = new AstarStrategy();
        // 使用A*算法找到路径
        if (findPathStrategy.findPath(mazeService.getMaze(), path, visited, ai.getX(), ai.getY(), player.getX(), player.getY())) {
            // 如果找到路径，移动AI到路径的下一个位置
            if (path.size() > 1) {
                int[] nextMove = path.get(1); // 路径的第一个元素是当前AI的位置，第二个元素是下一个位置
                ai.setPosition(nextMove[1], nextMove[0]);
            }
        }
        System.out.println("X: "+ai.getX()+" Y "+ai.getY());
    }

    @Override
    public boolean isPlayerCaught() {
        return ai.getX() == player.getX() && ai.getY() == player.getY();
    }

    @Override
    public IPlayerModel getAiModel() {
        return ai;
    }

    @Override
    public void reset() {
        ai.setPosition(mazeService.getMaze().getStartX(), mazeService.getMaze().getRows()-2);
    }
}
