package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public interface IPlayerService {
    //Check if the move is valid
    public boolean movePlayer(int dx, int dy);

    //Checking for customs clearance
    public boolean checkGoal();

    //Get Player object instance
    public IPlayerModel getPlayer();

    //Reset Player Position
    public void reset();

    //Get map example
    IMazeModel getMaze();
}
