# Maze Game (CST206)

## 简介

这是一个使用JavaFX开发的迷宫游戏，实现了基本功能，并采用了多种设计模式来确保代码的简洁性和可扩展性。

**具体API说明请见**

[JavaDoc]([htmlpreview.github.io/?https://github.com/baibairui/CST210-Game/blob/master/JavaDoc/index.html](https://github.com/baibairui/CST210-Game/blob/master/htmlpreview.github.io/JavaDoc/index.html))


## 设计模式

1. **MVC模式**：整个游戏架构采用了MVC（Model-View-Controller）设计模式。
    - **Model**：负责存储游戏状态和业务逻辑（如`GameModel`、`MazeModel`、`PlayerModel`等）。
    - **View**：负责展示游戏界面（如`GameView`、`MazeView`、`PlayerView`等）。
    - **Controller**：负责处理用户输入并更新Model和View（如`GameController`）。

2. **抽象工厂模式**：用于创建一系列相关或依赖对象，而无需指定它们的具体类。你在工厂类（如`GameViewFactory`、`GameModelFactory`、`GameServiceFactory`、`GameControllerFactory`）中实现了这一模式，通过不同的皮肤枚举值来生成相应的视图、模型和服务实例。
    - **AbstractFactory**：提供了多个创建对象的方法，每个方法创建一个类型的对象。
    - **FactoryProducer**：用于获取具体的工厂实例。
    - **具体工厂类**：如`GameViewFactory`、`GameModelFactory`、`GameServiceFactory`和`GameControllerFactory`，实现了创建不同版本对象的方法。

3. **策略模式**：
    - **皮肤选择模式**
在游戏服务层中，通过根据不同的皮肤类型创建不同的服务实现（如`GameService`和`GameServiceVs`），实现了策略模式。这个模式允许你在运行时改变算法或逻辑。
    - **算法策略模式**：在迷宫生成算法和路径提示算法中，通过不同的策略实现（如随机化Prim算法和深度优先搜索算法），实现了动态选择和切换不同的算法。
      在游戏中，算法策略模式用于实现不同的迷宫生成和路径提示算法。

4. **组合模式**：在View层，使用组合模式将不同的子视图（如MazeView、PlayerView等）组合成一个完整的游戏视图（如RunView）。这使得可以方便地管理和更新视图的各个部分。

5. **外观模式**：在View层，使用外观模式封装了美化组件的功能

## 代码架构

**Main Application (App.java)**

- **职责**：启动应用程序，显示皮肤选择视图，初始化游戏层次。
- **流程**：
    1. 显示皮肤选择视图，让用户选择皮肤。
    2. 根据用户选择的皮肤，初始化游戏模型、服务、控制器和视图。
    3. 将视图展示给用户。

**Factory层 (如AbstractFactory.java, FactoryProducer.java)**

- **职责**：提供创建对象的接口，通过具体工厂实现类创建不同类型和版本的对象。
- **流程**：
    1. `FactoryProducer`根据传入的类型返回相应的工厂实例。
    2. 各具体工厂实现类根据皮肤枚举值创建相应的对象实例。

**Model层 (如GameModel.java, MazeModel.java)**

- **职责**：定义游戏中的数据结构和业务逻辑。
- **流程**：
    1. 定义各种模型接口和实现类。
    2. 提供数据访问和操作方法。

**Service层 (如GameService.java, MazeService.java)**

- **职责**：处理游戏的具体业务逻辑。
- **流程**：
    1. 根据传入的模型数据进行逻辑处理。
    2. 提供对模型数据的操作接口。

**Controller层 (如GameController.java)**

- **职责**：接收用户输入并调用相应的服务层处理逻辑。
- **流程**：
    1. 监听用户输入事件。
    2. 调用服务层进行相应的业务逻辑处理。
    3. 更新视图。

**View层 (如GameView.java, SkinSelectionView.java)**

- **职责**：负责用户界面的展示和交互。
- **流程**：
    1. 定义各种视图接口和实现类。
    2. 通过组合模式将各个子视图组合成完整的界面。

## 算法策略模式

### 寻路算法

#### **1.AstarStrategy**

用于ai追踪玩家，效率比dfs高

```java
package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Implementation of the A* algorithm for pathfinding in a maze.
 * This class uses the A* algorithm to find the shortest path from the starting position to the goal position.
 */
public class AstarStrategy implements IFindPathStrategy {

    /**
     * Inner class representing a node in the A* algorithm.
     */
    public static class Node implements Comparable<Node> {
        final int x;
        final int y; // Coordinate
        final int g; // The cost of moving from the starting point to the current coordinates
        final int h; // The estimated cost of moving to the target point, the heuristic function

        /**
         * Constructor to initialize a node.
         *
         * @param x The x-coordinate of the node.
         * @param y The y-coordinate of the node.
         * @param g The cost from the start to this node.
         * @param h The estimated cost from this node to the goal.
         */
        public Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        /**
         * Calculates the f value (total cost) for this node.
         *
         * @return The total cost.
         */
        int f() {
            return g + h;
        }

        /**
         * Compares this node to another node based on their f values.
         *
         * @param o The other node to compare to.
         * @return The comparison result.
         */
        @Override
        public int compareTo(@NotNull Node o) {
            return Integer.compare(this.f(), o.f());
        }

        /**
         * Checks if this node is equal to another object.
         *
         * @param o The object to compare to.
         * @return True if the objects are equal, false otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        /**
         * Generates a hash code for this node.
         *
         * @return The hash code.
         */
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * Finds a path using the A* algorithm.
     *
     * @param mazeModel The maze model containing the maze structure.
     * @param path      A list to store the path found from start to goal.
     * @param visited   A 2D boolean array to keep track of visited positions in the maze.
     * @param x         The x-coordinate of the current position.
     * @param y         The y-coordinate of the current position.
     * @param goalX     The x-coordinate of the goal position.
     * @param goalY     The y-coordinate of the goal position.
     * @return True if a path is found, false otherwise.
     */
    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // Priority queue to ensure that the node with the smallest f value is processed first
        PriorityQueue<Node> openList = new PriorityQueue<>();
        // Set to store nodes that have already been processed to prevent duplication
        Set<Node> closedList = new HashSet<>();
        // Map to record paths, placing the point with the smallest cost from the goal into the map
        Map<Node, Node> pathRecord = new HashMap<>();

        Node startNode = new Node(x, y, 0, heuristic(x, y, goalX, goalY));
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            if (currentNode.x == goalX && currentNode.y == goalY) {
                path.clear();
                path.addAll(buildPath(currentNode, pathRecord));
                return true;
            }
            closedList.add(currentNode);
            for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                int neighborX = currentNode.x + dir[0];
                int neighborY = currentNode.y + dir[1];

                if (neighborX < 0 || neighborY < 0 || neighborX >= mazeModel.getCols() || neighborY >= mazeModel.getRows() || mazeModel.getMaze()[neighborY][neighborX] == 1) {
                    continue;
                }

                Node neighborNode = new Node(neighborX, neighborY, currentNode.g + 1, heuristic(neighborX, neighborY, goalX, goalY));
                if (closedList.contains(neighborNode)) {
                    continue;
                }
                if (!openList.contains(neighborNode)) {
                    openList.add(neighborNode);
                    pathRecord.put(neighborNode, currentNode);
                }
            }
        }
        return false;
    }

    /**
     * Heuristic function to estimate the cost from the current position to the goal.
     *
     * @param x     The x-coordinate of the current position.
     * @param y     The y-coordinate of the current position.
     * @param goalX The x-coordinate of the goal position.
     * @param goalY The y-coordinate of the goal position.
     * @return The estimated cost.
     */
    private int heuristic(int x, int y, int goalX, int goalY) {
        return Math.abs(x - goalX) + Math.abs(y - goalY);
    }

    /**
     * Builds the path from the end node to the start node by backtracking.
     *
     * @param endNode The end node of the path.
     * @param record  The map containing the path record.
     * @return The list of coordinates representing the path.
     */
    private List<int[]> buildPath(Node endNode, Map<Node, Node> record) {
        List<int[]> path = new ArrayList<>();
        Node curr = endNode;
        while (curr != null) {
            path.add(new int[]{curr.y, curr.x});
            curr = record.get(curr);
        }
        Collections.reverse(path);
        return path;
    }
}

```

#### **2.DfsStrategy**

用于给玩家提示路径

```java
package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;

import java.util.List;

/**
 * Implementation of the depth-first search (DFS) strategy for pathfinding in a maze.
 * This class uses a DFS algorithm to find a path from the starting position to the goal position without recording the backtracking process.
 */
public class DfsStrategy implements IFindPathStrategy {

    /**
     * Finds a path using DFS without recording the backtracking process.
     *
     * @param mazeModel The maze model containing the maze structure.
     * @param path      A list to store the path found from start to goal.
     * @param visited   A 2D boolean array to keep track of visited positions in the maze.
     * @param x         The x-coordinate of the current position.
     * @param y         The y-coordinate of the current position.
     * @param goalX     The x-coordinate of the goal position.
     * @param goalY     The y-coordinate of the goal position.
     * @return True if a path is found, false otherwise.
     */
    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // Returns false if it is out of bounds or has already been accessed or is walled.
        if (x < 0 || x >= mazeModel.getCols() || y < 0 || y >= mazeModel.getRows() || visited[y][x] || mazeModel.getMaze()[y][x] == 1) {
            return false;
        }

        // Mark the current cell as visited
        visited[y][x] = true;

        // Add the current point to the path
        path.add(new int[]{y, x});

        // Returns true if the target point is reached
        if (x == goalX && y == goalY) {
            return true;
        }

        // Try recursive calls in all four directions
        if (findPath(mazeModel, path, visited, x - 1, y, goalX, goalY) ||
                findPath(mazeModel, path, visited, x + 1, y, goalX, goalY) ||
                findPath(mazeModel, path, visited, x, y - 1, goalX, goalY) ||
                findPath(mazeModel, path, visited, x, y + 1, goalX, goalY)) {
            return true;
        }

        // If no path is found, backtrack and remove the current point from the path
        path.remove(path.size() - 1);

        return false;
    }
}
```


--- 
## **2. Model层设计**

### 2.1 GameModel

游戏的 **Model层** 是基于 **组合模式** 来设计的，由一个 **IGameModel** 类型来组合一组相似的对象

**接口设计**
```java
/**
 * Interface for the game model, which combines different sub-models such as player models and maze models.
 */
public interface IGameModel {
    /**
     * Gets the player model.
     *
     * @return The player model.
     */
    IPlayerModel getPlayModel();

    /**
     * Gets the maze model.
     *
     * @return The maze model.
     */
    IMazeModel getMazeModel();

    /**
     * Gets the AI model.
     *
     * @return The AI model, or null if not applicable.
     */
    IPlayerModel getAiModel();

    /**
     * Gets the second player model.
     *
     * @return The second player model, or null if not applicable.
     */
    IPlayerModel getSecondPlayModel();
}

```


### 2.2 GameObject

定义了游戏中所有**游戏对象的抽象父类GameObject**, 抽象出游戏对象都应该有的基本属性.

**具体实现**
```java
/*
游戏中所有对象的超类
规定了所有的游戏对象都应该有的属性：
1.横坐标：x
2.纵坐标：y
---
规定了所有游戏对象都应该有的方法：
1.get和set方法
 */
public abstract class GameObject {
  protected int x;
  protected int y;
  //构造函数
  public GameObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  //相关get和set方法
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}


```

### 2.3 PlayerModel

**Player**

**接口设计**
```java
package com.edu.xmum.cst206.Model.Interface;

/**
 * Interface for PlayerModel.
 * Specifies the methods that should be unique to the PlayerModel.
 * These include methods for movement, setting position, and getting start and current coordinates.
 */
public interface IPlayerModel {
    /**
     * Gets the starting x-coordinate of the player model.
     *
     * @return The starting x-coordinate.
     */
    int getStartX();

    /**
     * Gets the starting y-coordinate of the player model.
     *
     * @return The starting y-coordinate.
     */
    int getStartY();

    /**
     * Moves the player model by the specified delta values.
     *
     * @param dx The delta x value.
     * @param dy The delta y value.
     */
    void move(int dx, int dy);

    /**
     * Sets the position of the player model to the specified coordinates.
     *
     * @param x The x-coordinate to set.
     * @param y The y-coordinate to set.
     */
    void setPosition(int x, int y);

    /**
     * Gets the current x-coordinate of the player model.
     *
     * @return The current x-coordinate.
     */
    int getX();

    /**
     * Gets the current y-coordinate of the player model.
     *
     * @return The current y-coordinate.
     */
    int getY();
}
```

### 2.4 Maze类

**迷宫类**需要被绘制在界面并且不可移动

这里我们使用一个二维数组来表示这个迷宫并设计可以通过前端的来选择这个迷宫类的行数和列数。

**接口设计**
```java
package com.edu.xmum.cst206.Model.Interface;

/**
 * Interface for MazeModel.
 * Specifies the methods that the MazeModel should implement.
 * These include methods for getting and setting rows, columns, goal coordinates,
 * and methods for generating and accessing the maze structure.
 */
public interface IMazeModel {
    /**
     * Gets the number of rows in the maze.
     *
     * @return The number of rows.
     */
    int getRows();

    /**
     * Gets the number of columns in the maze.
     *
     * @return The number of columns.
     */
    int getCols();

    /**
     * Gets the x-coordinate of the goal position in the maze.
     *
     * @return The x-coordinate of the goal.
     */
    int getGoalX();

    /**
     * Gets the y-coordinate of the goal position in the maze.
     *
     * @return The y-coordinate of the goal.
     */
    int getGoalY();

    /**
     * Gets the x-coordinate of the start position in the maze.
     *
     * @return The x-coordinate of the start.
     */
    int getStartX();

    /**
     * Gets the y-coordinate of the start position in the maze.
     *
     * @return The y-coordinate of the start.
     */
    int getStartY();

    /**
     * Gets the maze structure as a two-dimensional array.
     * 0 means the cell is accessible, 1 means the cell is a wall.
     *
     * @return The maze structure.
     */
    int[][] getMaze();

    /**
     * Sets the number of rows in the maze.
     *
     * @param rows The number of rows to set.
     */
    void setRows(int rows);

    /**
     * Sets the number of columns in the maze.
     *
     * @param cols The number of columns to set.
     */
    void setCols(int cols);

    /**
     * Generates the maze using the randomized Prime's algorithm.
     */
    void generateMaze();
}

```
这里我们使用 **随机化prim生成树算法**来生成迷宫

---
## 3. Service层设计

**Service层** 用于处理游戏相关逻辑的判断与处理，在迷宫游戏中需要判断**Controller层**传入的请求并对**Model层**进行操作

### 3.1 GameService

**GameService** 同样是基于 **组合模式** 来设计的，用来组合 **Service层** 的其他接口

**接口设计**
```java
public interface IAiService{
/**
 * Moves the AI according to its algorithm.
 */
void moveAi();

/**
 * Checks if the AI has caught the player.
 *
 * @return True if the player is caught, false otherwise.
 */
boolean isPlayerCaught();

/**
 * Gets the AI model.
 *
 * @return The AI model.
 */
IPlayerModel getAiModel();

/**
 * Resets the AI to its initial state.
 */
void reset();
}
```


### 3.2 MazeService
**MazeService类**用于处理与**Maze**类相关的逻辑
**包括**
1.检测玩家是否碰壁
2.是否在边界内以及是否到达终点。
3.获得路径提示(这里我们使用DFS算法来实现寻路的算法逻辑)

**接口设计**
```java
public interface IMazeService{

/**
 * Checks if the player's move to the specified direction (dx, dy) is valid within the maze.
 *
 * @param player The player model instance.
 * @param dx     The delta x value for the move.
 * @param dy     The delta y value for the move.
 * @return True if the move is valid, false otherwise.
 */
boolean isValidMove(IPlayerModel player, int dx, int dy);

/**
 * Checks if the specified coordinates (x, y) are within the maze boundaries.
 *
 * @param x The x coordinate to check.
 * @param y The y coordinate to check.
 * @return True if the coordinates are within bounds, false otherwise.
 */
boolean isWithinBounds(int x, int y);

/**
 * Checks if the specified coordinates (X, Y) are a path and not a wall.
 *
 * @param X The x coordinate to check.
 * @param Y The y coordinate to check.
 * @return True if the coordinates represent a path, false otherwise.
 */
boolean isPath(int X, int Y);

/**
 * Checks if the player has reached the goal position in the maze.
 *
 * @param player The player model instance.
 * @return True if the player has reached the goal, false otherwise.
 */
boolean hasReachedGoal(IPlayerModel player);

/**
 * Resets the maze to its initial state.
 */
void reset();

/**
 * Gets the current maze model instance.
 *
 * @return The maze model instance.
 */
IMazeModel getMaze();

/**
 * Gets the path from the current position (x, y) to the goal as a list of coordinate pairs.
 *
 * @param x The starting x coordinate.
 * @param y The starting y coordinate.
 * @return The list of coordinate pairs representing the path.
 */
List<int[]> getPath(int x, int y);
}
```


### 3.3 PlayerService

**PlayerService** 类用于处理与玩家相关的逻辑，包括移动玩家并检查是否到达终点。

**接口设计**
```java
/**
 * Interface for PlayerService.
 * Specifies the methods that the PlayerService should implement.
 */
public interface IPlayerService {
    /**
     * Checks if the move is valid and moves the player.
     *
     * @param dx The delta x value for the move.
     * @param dy The delta y value for the move.
     * @return True if the move is valid and the player is moved, false otherwise.
     */
    boolean movePlayer(int dx, int dy);

    /**
     * Checks if the player has reached the goal.
     *
     * @return True if the player has reached the goal, false otherwise.
     */
    boolean checkGoal();

    /**
     * Gets the Player model instance.
     *
     * @return The Player model instance.
     */
    IPlayerModel getPlayer();

    /**
     * Resets the player's position to the starting point.
     */
    void reset();

    /**
     * Gets the maze model associated with the player.
     *
     * @return The maze model.
     */
    IMazeModel getMaze();
}

```

---

## 4. Controller层设计

**Controller层**用于与处理前端**View层** 发起的请求，返回后端**Service层**的响应

**接口设计**
```java

/*
Control layer is used to receive requests from the View layer and process related logic through the Service layer.

GameController is the main class of the Control layer.
Contains:
- The main class of the View layer: gameView
- The main class of the Service layer: gameService

Used to process requests for front-end interactions and return back-end responses.
*/
public interface IGameController {

    /**
     * Starts the game by initializing necessary components and setting up the initial state.
     */
    void startGame();

    /**
     * Resets the game to its initial state.
     */
    void resetGame();

    /**
     * Sets the difficulty level of the game.
     *
     * @param difficulty The difficulty level to set (e.g., Easy, Medium, Hard).
     */
    void setDifficulty(String difficulty);

    /**
     * Handles key press events to control game actions.
     *
     * @param key The key pressed by the user.
     */
    void handleKeyPress(String key);

    /**
     * Displays the selection view where users can choose game settings.
     */
    void showSelectionView();

    /**
     * Displays the preparation view before starting the game.
     */
    void showPrepareView();

    /**
     * Displays the main game view where the game is played.
     */
    void showRunView();

    /**
     * Displays the victory view when the player wins the game.
     *
     * @param winner The winner of the game.
     */
    void showVictoryView(String winner);

    /**
     * Displays a hint to the player during the game.
     */
    void showHint();

    /**
     * Displays the failure view when the player loses the game.
     */
    void showFailureView();

    /**
     * Sets the game view, which is responsible for the user interface.
     *
     * @param gameView The game view to set.
     */
    void setGameView(IGameView gameView);

    /**
     * Gets the current difficulty level of the game.
     *
     * @return The current difficulty level.
     */
    String getDifficulty();

    /**
     * Gets the game service, which handles game logic and operations.
     *
     * @return The game service.
     */
    IGameService getGameService();

    /**
     * Starts the AI movement in the game.
     */
    void startAiMovement();
}

```



---

## 5. View层设计

**View层**用于负责前端页面的绘制和页面之间的切换，与**Control层进行交互**

### 5.1 GameView

**GameView**同样是基于 **组合模式** 设计的

**GameView** 是**View层** 的聚合父类用于封装**View层**的所有子类并负责页面的切换事件处理

**接口设计**
```java
public interface IGameView {

    void setGameController(IGameController gameController);
    IWelcomeView getWelcomeView();

    ISelectionView getSelectionView();

    IPrepareView getPrepareView();

    IRunView getRunView();

    BorderPane getView();

    void showVictoryView();

    void showSelectionView();

    void showPrepareView();

    void showRunView();
    public void setWelcomeView(IWelcomeView welcomeView) ;

    public void setSelectionView(ISelectionView selectionView);

    public void setPrepareView(IPrepareView prepareView);

    public void setRunView(IRunView runView);

    public void setVictoryView(IVictoryView victoryView);

}
```

### 5.2 WelcomeView

**WelcomeView** 负责绘制游戏的初始进入页面,使用**VBox**作为布局容器自上而下的布局。

![img.png](assets/img.png)

**接口设计**
```java
/**
 * Interface for WelcomeView.
 * Specifies the methods that the WelcomeView should implement.
 */
public interface IWelcomeView {

    /**
     * Gets the start button in the WelcomeView.
     *
     * @return The start button.
     */
    Button getStartButton();

    /**
     * Gets the root node of the WelcomeView.
     *
     * @return The root node.
     */
    Node getNode();
}
```

### 5.3 SelectionView

**SelectionView** 负责绘制游戏的难度页面，使用**VBox**作为布局容器自上而下的布局。

![img_1.png](assets/img_1.png)

**接口设计**
```java
package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for SelectionView.
 * Specifies the methods that the SelectionView should implement.
 */
public interface ISelectionView {

    /**
     * Gets the easy button in the SelectionView.
     *
     * @return The easy button.
     */
    Button getEasyButton();

    /**
     * Gets the medium button in the SelectionView.
     *
     * @return The medium button.
     */
    Button getMediumButton();

    /**
     * Gets the hard button in the SelectionView.
     *
     * @return The hard button.
     */
    Button getHardButton();

    /**
     * Gets the root node of the SelectionView.
     *
     * @return The VBox root node.
     */
    VBox getNode();
}
```

### 5.4 PrepareView

**PrepareView** 负责游戏准备页面的设计，使用**VBox**作为布局容器自上而下的布局。
![img.png](img.png)
**接口设计**
```java
/**
 * Interface for PrepareView.
 * Specifies the methods that the PrepareView should implement.
 */
public interface IPrepareView {

    /**
     * Gets the start game button in the PrepareView.
     *
     * @return The start game button.
     */
    Button getStartGameButton();

    /**
     * Gets the root node of the PrepareView.
     *
     * @return The VBox root node.
     */
    VBox getNode();
}

```

### 5.5 RunView

**RunView** 负责游戏主页面的绘制,使用 **BoardPane** 作为主控局组件，自上而下的添加组件

![img_2.png](assets/img_2.png)

**接口设计**
```java
package com.edu.xmum.cst206.View.Interface;

import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.util.List;
import java.util.Timer;

/**
 * Interface for RunView.
 * Specifies the methods that the RunView should implement.
 */
public interface IRunView {

    /**
     * Gets the reset button in the RunView.
     *
     * @return The reset button.
     */
    Button getResetButton();

    /**
     * Gets the hint button in the RunView.
     *
     * @return The hint button.
     */
    Button getHintButton();

    /**
     * Gets the root node of the RunView.
     *
     * @return The BorderPane root node.
     */
    BorderPane getNode();

    /**
     * Gets the player view in the RunView.
     *
     * @return The player view.
     */
    IPlayerView getPlayerView();

    /**
     * Gets the maze view in the RunView.
     *
     * @return The maze view.
     */
    IMazeView getMazeView();

    /**
     * Gets the AI view in the RunView.
     *
     * @return The AI view.
     */
    IPlayerView getAiView();

    /**
     * Gets the second player view in the RunView.
     *
     * @return The second player view.
     */
    IPlayerView getSecondPlayerView();

    /**
     * Resets the view, updating any changes.
     */
    void reSetView();

    /**
     * Adjusts the layout of the RunView.
     */
    void adjustLayout();

    /**
     * Displays the hint path in the RunView.
     *
     * @param path The path to show as a hint.
     */
    void showHint(List<int[]> path);
}
```

### 5.6 VictoryView

**VictoryView** 用来显示游戏胜利的页面，使用 **VBox** 作为主控局容器

![img_3.png](assets/img_3.png)

**接口设计**
```java
package com.edu.xmum.cst206.View.Interface;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Interface for VictoryView.
 * Specifies the methods that the VictoryView should implement.
 */
public interface IVictoryView {

    /**
     * Gets the back button in the VictoryView.
     *
     * @return The back button.
     */
    Button getBackButton();

    /**
     * Gets the root node of the VictoryView.
     *
     * @return The VBox root node.
     */
    VBox getNode();

    /**
     * Sets the winner's name to be displayed in the VictoryView.
     *
     * @param winner The name of the winner.
     */
    void setWinner(String winner);
}
```
### 5.7 FailView

**FailView** 用来显示游戏胜利的页面，使用 **VBox** 作为主控局容器

**接口设计**
```java
/**
 * Interface for FailView.
 * Specifies the methods that the FailView should implement.
 */
public interface IFailView {

    /**
     * Gets the root node of the FailView.
     *
     * @return The VBox root node.
     */
    VBox getNode();

    /**
     * Gets the back button in the FailView.
     *
     * @return The back button.
     */
    Button getBackButton();
}
```
---
## 6.组件美化
由于JavaFx使用外部css绑定样式并不好用，这里我使用**外观模式**封装了用来绑定CSS样式美化类，**View**层只需要调用 **Styler** 就可以完成美化组件

**以 PrepareViewStyler 为例子，这个类就是模拟了CSS，View层的布局就是在模拟Html**

```java
package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * Beautification of PrepareView based on Appearance Pattern Design.
 * Applies styles to the VBox, Label, and Button based on the selected skin.
 */
public class PrepareViewStyler {

    /**
     * Styles the VBox based on the specified skin.
     *
     * @param skin The skin to apply to the VBox.
     * @param vBox The VBox to style.
     */
    public static void VboxStyle(Skin skin, VBox vBox) {
        if (vBox == null) return;
        switch (skin) {
            case V1 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #f7f8fa, #e2e2e2); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"
                );
            }
            case V2 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #a1c4fd, #c2e9fb); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                );
            }
            case V3 -> {
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(40));
                vBox.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #ffecd2, #fcb69f); " +
                                "-fx-padding: 20px; " +
                                "-fx-border-radius: 10; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                );
            }
        }
    }

    /**
     * Styles the Label based on the specified skin.
     *
     * @param skin         The skin to apply to the Label.
     * @param prepareLabel The Label to style.
     */
    public static void LabelStyle(Skin skin, Label prepareLabel) {
        if (prepareLabel == null) return;
        switch (skin) {
            case V1 -> {
                prepareLabel.setFont(new Font(18));
                prepareLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
            }
            case V2 -> {
                prepareLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                prepareLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #444;");
            }
            case V3 -> {
                prepareLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                prepareLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #222;");
            }
        }
        // Adds floating animation to the label
        addTextFloatingAnimation(prepareLabel);
    }

    /**
     * Styles the Button based on the specified skin.
     *
     * @param skin   The skin to apply to the Button.
     * @param button The Button to style.
     */
    public static void ButtonStyle(Skin skin, Button button) {
        if (button == null) return;
        switch (skin) {
            case V1 -> {
                button.setStyle(
                        "-fx-background-color: #4CAF50; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                );
                addButtonAnimation(button, "#4CAF50", "#45a049", "#3e8e41");
            }
            case V2 -> {
                button.setStyle(
                        "-fx-background-color: #007BFF; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-border-radius: 5; " +
                                "-fx-cursor: hand;"
                );
                addButtonAnimation(button, "#007BFF", "#0056b3", "#004085");
            }
            case V3 -> {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                button.setTextFill(Color.WHITE);
                button.setStyle(
                        "-fx-background-color: #FF5722; " +
                                "-fx-background-radius: 10; " +
                                "-fx-padding: 10px 20px; " +
                                "-fx-cursor: hand;"
                );
                addButtonAnimation(button, "#FF5722", "#E64A19", "#D84315");
            }
        }
    }

    /**
     * Adds floating animation to the specified Label.
     *
     * @param label The Label to animate.
     */
    private static void addTextFloatingAnimation(Label label) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), label);
        translateTransition.setFromY(0);
        translateTransition.setToY(-10);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();
    }

    /**
     * Adds hover and press animations to the specified Button.
     *
     * @param button       The Button to animate.
     * @param normalColor  The normal background color of the Button.
     * @param hoverColor   The background color of the Button when hovered.
     * @param pressedColor The background color of the Button when pressed.
     */
    private static void addButtonAnimation(Button button, String normalColor, String hoverColor, String pressedColor) {
        button.setOnMouseEntered(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        button.setOnMouseExited(event -> {
            button.setStyle(
                    "-fx-background-color: " + normalColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        button.setOnMousePressed(event -> {
            button.setStyle(
                    "-fx-background-color: " + pressedColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(2);
            tt.play();
        });

        button.setOnMouseReleased(event -> {
            button.setStyle(
                    "-fx-background-color: " + hoverColor + "; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-radius: 5; " +
                            "-fx-cursor: hand;"
            );
            TranslateTransition tt = new TranslateTransition(Duration.millis(100), button);
            tt.setByY(-2);
            tt.play();
        });
    }
}
```

## 7.皮肤选择功能的改进

这里我选择使用 **抽象工厂模式** 来设计皮肤的选择功能

抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。通过使用抽象工厂模式，可以在游戏中灵活地切换不同的视图皮肤，增强用户的体验。

### 7.1 抽象工厂父类的设计

这个游戏中的视图层我们设计了许多不同的版本，这里使用抽象工厂来与用户交互选择皮肤

```java
public abstract class AbstractFactory {
    public IMazeView getMazeView(Skin maze, IMazeModel mazeModel) {
        return null;
    }

    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        return null;
    }

    public IPrepareView getPrepareView(Skin prepareView) {
        return null;
    }

    public IRunView getRunView(Skin runView, IGameController gameController) {
        return null;
    }

    public ISelectionView getSelectionView(Skin selectionView) {
        return null;
    }

    public IVictoryView getVictoryView(Skin victoryView) {
        return null;
    }

    public IWelcomeView getWelcomeView(Skin welcomeVIew) {
        return null;
    }

    public IGameModel getGameModel(Skin playerModel) {
        return null;
    }

    public IGameService getGameService(Skin gameService, IGameModel gameModel) {
        return null;
    }

    public IGameController getGameController(Skin gameController, IGameService gameService) {
        return null;
    }

    public IMazeModel getMazeModel(String maze) {
        return null;
    }

    public IPlayerModel getPlayerModel(String player, IMazeModel mazeModel) {
        return null;
    }

    public IPlayerService getPlayerService(String vision, IPlayerModel mazeModel, IMazeService mazeService) {
        return null;
    }

    public IMazeService getMazeService(String vision, IMazeModel mazeModel) {
        return null;
    }

    public IAiService getAiService(String vision, IMazeService mazeService, IPlayerModel playModel, IPlayerModel aiModel) {
        return null;
    }
}

```

### 7.2 工厂生产者

工厂生产者用于简化工厂的创建过程，根据用户的选择返回相应的工厂实例。

```java
public class FactoryProducer {
    private static final Map<String, AbstractFactory> factoryMap = new HashMap<>();
    private static final int size = 3;//Number of skins

    static {
        factoryMap.put("GameView", new GameViewFactory());
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
```

### 7.3 具体工厂

具体工厂类用于创建不同类型的视图对象。 每个具体工厂类负责创建其对应类型的视图对象，并且每个具体工厂可以创建不同版本或风格的视图对象。这样做可以将视图对象的创建逻辑集中到具体工厂类中，简化客户端代码，并提高代码的可维护性和可扩展性。

**这里以GameModel的具体工厂实现为例**
```java
/**
 * GameModelFactory is responsible for creating instances of game models, player models, and maze models.
 */
public class GameModelFactory extends AbstractFactory {

    /**
     * Creates and returns an instance of IGameModel based on the specified skin.
     * @param playerModel The skin enumeration that determines which game model to create.
     * @return An instance of IGameModel.
     */
    @Override
    public IGameModel getGameModel(Skin playerModel) {
        if (playerModel.getSkin().equals("V3")) {
            return new GameModelVs();
        } else {
            return new GameModel();
        }
    }

    /**
     * Creates and returns an instance of IPlayerModel based on the specified player type and maze model.
     * @param player The type of player ("Player" or "AI").
     * @param mazeModel The maze model associated with the player.
     * @return An instance of IPlayerModel.
     */
    @Override
    public IPlayerModel getPlayerModel(String player, IMazeModel mazeModel) {
        if (player.equals("Player")) {
            return new PlayerModel(mazeModel);
        } else if (player.equals("AI")) {
            return new AiModel(mazeModel);
        }
        return null;
    }

    /**
     * Creates and returns an instance of IMazeModel based on the specified maze type.
     * @param maze The type of maze.
     * @return An instance of IMazeModel.
     */
    @Override
    public IMazeModel getMazeModel(String maze) {
        if (maze.equals("Maze")) {
            return new MazeModel(Config.ROWS, Config.COLS);
        }
        return null;
    }
}

```
