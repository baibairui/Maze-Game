package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

import java.util.List;

/*
Used to handle map-related logic
 */
public interface IMazeService {
    //Check if the player is taking the pathway
    public boolean isValidMove(IPlayerModel player, int dx, int dy);

    //Check if the player is within the maze boundary
    public boolean isWithinBounds(int x, int y);

    //Check if the current position is a wall
    public boolean isPath(int X, int Y);

    //Checking if the player has cleared the level
    public boolean hasReachedGoal(IPlayerModel player);

    //Reset Labyrinth
    public void reset();

    IMazeModel getMaze();

    //Cue Route
    public List<int[]> getPath(int x, int y);
}
