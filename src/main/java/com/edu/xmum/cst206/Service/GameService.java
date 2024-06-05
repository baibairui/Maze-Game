package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.GameObject;
import com.edu.xmum.cst206.Model.Maze;
import com.edu.xmum.cst206.Model.Player;

public class GameService {
    public MazeService mazeService;
    public PlayerService playerService;

    public GameService(Maze maze, Player player){
        this.mazeService=new MazeService(maze);
        this.playerService=new PlayerService(player,mazeService);
    }
}
