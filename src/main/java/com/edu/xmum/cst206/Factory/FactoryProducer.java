package com.edu.xmum.cst206.Factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        switch (choice){
            case "Maze":
                return new MazeViewFactory();
            case "Player":
                return new PlayerViewFactory();
            case "Prepare":
                return new PrepareViewFactory();
            case "Run":
                return new RunVIewFactory();
            case "Select":
                return new SelectionFactory();
            case "Victory":
                return new VictoryViewFactory();
        }
        return null;
    }
}
