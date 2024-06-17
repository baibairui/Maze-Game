package com.edu.xmum.cst206.Factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryProducer {
    private static final Map<String, AbstractFactory> factoryMap = new HashMap<>();
    private static final int size = 3;//皮肤数量

    static {
        factoryMap.put("GameView",new GameViewFactory());
        factoryMap.put("GameModel", new GameModelFactory());
        factoryMap.put("GameService", new GameServiceFactory());
        factoryMap.put("GameController", new GameControllerFactory());
    }

    public static AbstractFactory getFactory(String choice) {
        return factoryMap.get(choice);
    }

    public static int getSkinSize() {
        return size;
    }
}
