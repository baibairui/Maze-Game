package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Service.Interface.IFindPathStrategy;

import java.util.List;

/*
策略模式
选择不同的算法
 */
public class PathfindingContext {
    private IFindPathStrategy strategy;

    public PathfindingContext(IFindPathStrategy strategy){
        this.strategy=strategy;
    }


    public boolean findPath(IMazeModel mazeModel,List<int[]> path, boolean[][] visited, int x, int y,int goalX,int goalY) {
        return strategy.findPath(mazeModel,path,visited,x,y,goalX,goalY);
    }
}
