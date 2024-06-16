package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.MazeViewV1;
import com.edu.xmum.cst206.View.Entity.V3.MazeViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class MazeViewFactory extends AbstractFactory{
    @Override
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        if(maze.getSkin().equals("V1")){
            return new MazeViewV1(mazeModel);
        } else if (maze.getSkin().equals("V2")) {
            return new MazeViewV1(mazeModel);
        }else if(maze.getSkin().equals("V3")){
            return new MazeViewV3(mazeModel);
        }
        return null;
    }
}
