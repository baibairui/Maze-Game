package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.AlgorithmStrategy.AstarStrategy;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;
import com.edu.xmum.cst206.AlgorithmStrategy.IFindPathStrategy;

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
        // Finding paths using the AI algorithm
        if (findPathStrategy.findPath(mazeService.getMaze(), path, visited, ai.getX(), ai.getY(), player.getX(), player.getY())) {
            // If a path is found, move the AI to the next position in the path
            if (path.size() > 1) {
                int[] nextMove = path.get(1); // The first element of the path is the current AI position and the second element is the next position
                ai.setPosition(nextMove[1], nextMove[0]);
            }
        }
        System.out.println("X: " + ai.getX() + " Y " + ai.getY());
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
        ai.setPosition(mazeService.getMaze().getStartX(), mazeService.getMaze().getRows() - 2);
    }
}
