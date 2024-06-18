package com.edu.xmum.cst206.Factory;

import java.util.HashMap;
import java.util.Map;


/**
 * FactoryProducer is responsible for providing the appropriate factory instance based on the choice provided.
 */
public class FactoryProducer {
    private static final Map<String, AbstractFactory> factoryMap = new HashMap<>();
    private static final int size = 3; // Number of skins

    static {
        factoryMap.put("GameView", new GameViewFactory());
        factoryMap.put("GameModel", new GameModelFactory());
        factoryMap.put("GameService", new GameServiceFactory());
        factoryMap.put("GameController", new GameControllerFactory());
    }

    /**
     * Returns the appropriate factory instance based on the choice provided.
     * @param choice the type of factory required.
     * @return the corresponding AbstractFactory instance.
     */
    public static AbstractFactory getFactory(String choice) {
        return factoryMap.get(choice);
    }

    /**
     * Returns the number of skins available.
     * @return the number of skins.
     */
    public static int getSkinSize() {
        return size;
    }
}
