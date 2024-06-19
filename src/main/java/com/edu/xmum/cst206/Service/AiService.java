package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.AlgorithmStrategy.AstarStrategy;
import com.edu.xmum.cst206.AlgorithmStrategy.IFindPathStrategy;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Service.Interface.IAiService;
import com.edu.xmum.cst206.Service.Interface.IMazeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IAiService interface.
 * Provides methods to handle AI-related logic within the maze.
 */
public class  AiService implements IAiService {
    private final IMazeService mazeService;
    private final IPlayerModel player;
    private final IPlayerModel ai;

    /**
     * Constructor for AiService.
     * Uses dependency injection to initialize the maze service, player model, and AI model.
     *
     * @param mazeService The maze service instance.
     * @param playerModel The player model instance.
     * @param aiModel     The AI model instance.
     */
    public AiService(IMazeService mazeService, IPlayerModel playerModel, IPlayerModel aiModel) {
        this.mazeService = mazeService;
        this.player = playerModel;
        this.ai = aiModel;
    }

    /**
     * Moves the AI towards the player using the A* algorithm.
     */
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

    /**
     * Checks if the AI has caught the player.
     *
     * @return True if the AI has caught the player, false otherwise.
     */
    @Override
    public boolean isPlayerCaught() {
        return ai.getX() == player.getX() && ai.getY() == player.getY();
    }

    /**
     * Gets the AI model instance.
     *
     * @return The AI model instance.
     */
    @Override
    public IPlayerModel getAiModel() {
        return ai;
    }

    /**
     * Resets the AI's position to its initial start position.
     */
    @Override
    public void reset() {
        ai.setPosition(mazeService.getMaze().getStartX(), mazeService.getMaze().getRows() - 2);
    }
}
