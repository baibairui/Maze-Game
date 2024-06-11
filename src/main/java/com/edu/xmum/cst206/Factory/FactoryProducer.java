package com.edu.xmum.cst206.Factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryProducer {
    private static final Map<String, AbstractFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("Maze", new MazeViewFactory());
        factoryMap.put("Player", new PlayerViewFactory());
        factoryMap.put("Prepare", new PrepareViewFactory());
        factoryMap.put("Run", new RunViewFactory());
        factoryMap.put("Select", new SelectionFactory());
        factoryMap.put("Victory", new VictoryViewFactory());
    }

    public static AbstractFactory getFactory(String choice) {
        return factoryMap.get(choice);
    }
}
