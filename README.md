# CST206
基于JavaFx开发的迷宫游戏

---

## 1. 代码架构

游戏基于**MVC设计模式**并引入**Service层** 处理游戏中涉及的**相关逻辑**，以保证各层之间**高内聚和低耦合**

**M(游戏模型层):** 存储游戏中涉及的类对象

**V(游戏视图层):** 通过GUI库**JavaFx**给用户提供交互页面

**C(交换控制层):** 通过**JavaFx**中的事件响应功能与后端进行交互

**S(逻辑处理层):** 处理游戏中涉及碰撞移动等功能



## 2. 接口的设计
不同的游戏对象有不同的行为和相同的行为，我们将这些行为抽象出来定义为接口中的方法，通过**面向接口编程**维护了代码的规范性

**(1)Drawable**

需要显示在屏幕上的游戏对象都需要通过**JavaFx**的绘制方法
```java
public interface Drawable {
   Node draw();
}
```
**(2)Moveable**

需要移动的游戏对象都需要设计坐标更新的方法
```java
public interface Moveable {
    void move(double dx, double dy);
    void updateNodePosition();
}
```
--- 
## **3. Model层设计**
游戏模型是**基于XX模式**来设计的，定义了游戏中所有**游戏对象的抽象父类GameObject**

**GameModel**是**Model层**的聚合类用于封装**Model层**的所有类对象
```java
public class GameModel {
    private Maze maze;
    private Player player;

    public GameModel(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
    }
    //提供所有get和set方法
}

```


### 3.1 抽象父类

抽象父类**GameObject**中定义了游戏对象应有的**属性**并给出了相关的**get和set**方法以便其他层进行调用
```java
public abstract class GameObject {
    protected double x;//横坐标
    protected double y;//纵坐标
    protected double width;//宽
    protected double height;//高

    public GameObject(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    //每个游戏对象的绘制方法各自决定
    //每个游戏对象都应该实现对应的get和set方法，以便于其他层模块进行处理
    //对应的get和set方法
}
```


### 3.2 Player类

**Player类**需要玩家通过**JavaFx**的事件响应来移动并绘制在页面上，因此需要实现**Moveable**接口的功能

由于我们是基于**MVC模式** 设计的游戏，我们要保证各层之间的职责独立。因此**Model层**的类只需要提供对应的坐标属性，而相应的绘制方法则由**View层**负责。

```java
public class Player extends GameObject implements Moveablepublic class Player extends GameObject implements Moveable{
  private double radius;

  public Player(double x, double y, double radius) {
    super(x, y, radius * 2, radius * 2); // 宽度和高度为直径
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }
  public void setRadius(double radius){
    this.radius=radius;
  }

  /*玩家类的移动方法
  模型层只需要专注模型类的属性
  更新视图的方法由View层负责
   */
  @Override
  public void move(double dx, double dy) {
    x += dx;
    y += dy;
  }
}
```
### 3.3 Maze类

**迷宫类**需要被绘制在界面并且不可移动

这里我们使用一个二维数组来表示这个迷宫并设计可以通过前端的来选择这个迷宫类的行数和列数。

```java
public class Maze extends GameObject {
    private  int rows;//迷宫的行数
    private  int cols;//迷宫的列数
    private  int[][] maze;//用于表示迷宫，0表示通路，1表示墙
    //Maze的构造方法
    public Maze(int x,int y,int width,int hight,Color color,int rows, int cols) {
        super(x,y,width,hight,color);
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMazePrim();
    }
    //相关属性的get方法
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    public int[][] getMaze() {
        return maze;
    }
}
```

这里我们使用**随机化prim最小生成树算法**来根据玩家选择的行数和列数随机生成迷宫。

```java
private void generateMazePrim() {
        Random random = new Random();//用于随机选择一条候选边
        //将用于表示迷宫的二维数组全部初始化为1
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }
        //将入口位置设置为0
        int startX = 1;
        int startY = 1;
        maze[startX][startY] = 0;
        //初始化一个边的列表 ，用于储存候选通路
        List<Edge> edges = new ArrayList<>();
        //初始化候选通路
        addEdges(startX, startY, edges);

        //循环处理候选通路，直至生成到终点的通路
        while (!edges.isEmpty()) {
            // 随机选择一个边并移除
            Edge edge = edges.remove(random.nextInt(edges.size()));//在候选边中随机选择一条边来生成通路
            //如果该位置是墙则表示没访问过
            if (maze[edge.x2][edge.y2] == 1) {
                //设置一条通路
                maze[edge.x1][edge.y1] = 0;
                maze[edge.x2][edge.y2] = 0;
                //添加新的候选边
                addEdges(edge.x2, edge.y2, edges);
            }
        }


        //设置出口和入口
        maze[1][0]=0;
        maze[1][1] = 0;
        maze[rows - 2][cols - 1] = 0;
    }
    //用于添加候选边的方法
    private void addEdges(int x, int y, List<Edge> edges) {
        //限制边际
        if (x > 1) edges.add(new Edge(x - 1, y, x - 2, y));
        if (y > 1) edges.add(new Edge(x, y - 1, x, y - 2));
        if (x < rows - 2) edges.add(new Edge(x + 1, y, x + 2, y));
        if (y < cols - 2) edges.add(new Edge(x, y + 1, x, y + 2));
    }
```
## 4. Service层设计

**Service层** 用于处理游戏相关逻辑的判断与处理，在迷宫游戏中需要判断**Controller层**传入的请求并对**Model层**进行操作

### 4.1 MazeService
**MazeService类**用于处理与**Maze**类相关的逻辑，包括检测玩家是否碰壁、是否在边界内以及是否到达终点。

```java
public class MazeService {
    private Maze maze;
    public MazeService(Maze maze){
        this.maze=maze;
    }
    //处理玩家是否碰壁的问题
    public boolean isValidMove(Player player,double dx,double dy){
        //获取新的坐标
        double newX= player.getX()+dx;
        double newY=player.getY()+dy;
        double radius=player.getRadius();

        //检查边际坐标
        int leftX=(int)(newX-radius);//左边界
        int rightX = (int) (newX + radius);//右边界
        int topY = (int) (newY - radius);//上边界
        int bottomY = (int) (newY + radius);//下边界
        boolean isInBounds=isWithinBounds(leftX, topY) && isWithinBounds(rightX, topY) &&
                isWithinBounds(leftX, bottomY) && isWithinBounds(rightX, bottomY);//检查是否在边界内
        boolean isInMaze=maze.getMaze()[leftX][topY] == 0 && maze.getMaze()[rightX][topY] == 0 &&
                maze.getMaze()[leftX][bottomY] == 0 && maze.getMaze()[rightX][bottomY] == 0;//检查是否是墙

        // 确保新的坐标在迷宫边界内并且不是墙
        return  isInBounds&&isInMaze;
    }
    // 检查坐标是否在迷宫边界内
    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getCols();
    }
    // 检查玩家是否到达终点
    public boolean hasReachedGoal(Player player) {
        return player.getX() == maze.getRows() - 2 && player.getY() == maze.getCols() - 1;
    }
}
```
### 4.2 PlayerService

**PlayerService** 类用于处理与玩家相关的逻辑，包括移动玩家并检查是否到达终点。

```java
public class PlayerService {
    private Player player;
    private MazeService mazeService;

    //检查移动是否有效
    public void movePlayer(double dx, double dy) {
        if (mazeService.isValidMove(player, dx, dy)) {
            player.move(dx, dy);
        }
    }
    //检查是否通关
    public boolean checkGoal() {
        return mazeService.hasReachedGoal(player);
    }
}
```
---

## 5. Controller层设计

**Controller层**用于与处理前端**View层** 发起的请求，返回后端**Service层**的响应

---

## 6. View层设计

**View层**用于负责前端页面的绘制和页面之间的切换，与**Control层进行交互**

**GameView** 是**View层** 的聚合父类用于封装**View层**的所有子类并负责页面的切换事件处理

```java
/*
Controller层与View层进行交互
GameView是View层的主类
包含：
（1）各个游戏页面类
1.欢迎页面
2.难度页面
3.准备页面
4.游戏主页面
5.胜利页面
（2）GameController类
用来与Control层进行交互
 */
public class GameView extends BorderPane {
    private  GameController gameController;

    private WelcomeView welcomeView;
    private SelectionView selectionView;
    private PrepareView prepareView;
    private RunView runView;
    private VictoryView victoryView;
    public GameView( GameController gameController) {
        this.gameController=gameController;
        welcomeView = new WelcomeView();
        selectionView = new SelectionView();
        prepareView = new PrepareView();
        runView = new RunView(gameController);
        victoryView = new VictoryView();
        setTop(new Label("迷宫游戏")); // 设置一个简单的页眉

        //设置初始视图
        showWelcomeView();
        //添加事件处理器
        addEventHandlers();
    }

    //添加事件处理器
    private void addEventHandlers() {
        /*
        addEventHandler需要传入事件类型和实现Handler接口的类
        1.事件类型
        这里我们要处理的事件类型是页面之间的切换->不是类中的原始事件类型->需要自己定义
        ->自定义事件ViewSwitchEvent
        2.实现Handler接口的类
        （1）匿名内部类的方法来实现
        （2）lamda表达式可以用来实现只有一个方法的接口
         */
        addEventHandler(ViewSwitchEvent.SWITCH_TO_WELCOME,event->{showWelcomeView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_PREPARE,event->{showPrepareView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_SELECTION, event->{showSelectionView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_RUN,event->{showRunView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_VICTIORY,event->{showVictoryView();});
    }

    //用于事件绑定的函数
    public void showWelcomeView(){
        setCenter(welcomeView);
    }
    public void showSelectionView(){
        setCenter(selectionView);
    }
    public void showPrepareView(){
        setCenter(prepareView);
    }
    public void showRunView(){
        setCenter(runView);
    }
    public void showVictoryView(){
        setCenter(victoryView);
    }
}
```
### 6.1 WelcomeView

**WelcomeView** 负责绘制游戏的初始进入页面,使用**VBox**作为布局容器自上而下的布局。

![img.png](assets/img.png)
```java
public class WelcomeView extends VBox {
    private Button startButton;

    public WelcomeView() {
        setAlignment(Pos.CENTER);//居中显示
        setSpacing(20);
        
        //设计UI控件
        /*
                1.文本框 label
                2.按钮 Button
         */
        Label titleLabel = new Label("欢迎来到迷宫游戏");
        titleLabel.setFont(new Font(24));

        startButton = new Button("开始游戏!");

        getChildren().addAll(titleLabel, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }
}
```
### 6.2 SelectionView

**SelectionView** 负责绘制游戏的难度页面，使用**VBox**作为布局容器自上而下的布局。

![img_1.png](assets/img_1.png)

```java
public class SelectionView extends VBox {
    private final Button easyButton=new Button("Easy");
    private final Button mediumButton=new Button("Medium");
    private final Button hardButton=new Button("Hard");
    public SelectionView(){
        setAlignment(Pos.CENTER);
        setSpacing(15);
        //添加UI控件
      /*
              1.文本框 label
              2.按钮 Button
       */
        Label difficultyLabel = new Label("选择难度");
        difficultyLabel.setFont(new Font(18));

        getChildren().addAll(difficultyLabel,easyButton,mediumButton,hardButton);

    }

}
```
### 6.3 PrepareView

**PrepareView** 负责游戏准备页面的设计，使用**VBox**作为布局容器自上而下的布局。

```java
public class PrepareView extends VBox{
    private final Button startGameButton = new Button("开始游戏");

    public PrepareView() {
        setAlignment(Pos.CENTER);
        setSpacing(15);
        //添加UI控件
      /*
              1.文本框 label
              2.按钮 Button
       */
        Label prepareLabel = new Label("准备好开始游戏!");
        prepareLabel.setFont(new Font(18));


        getChildren().addAll(prepareLabel, startGameButton);
    }

    public Button getStartGameButton() {
        return startGameButton;
    }
}
```

### 6.4 RunView

**RunView** 负责游戏主页面的绘制,使用 **VBox** 作为主控局组件，自上而下的添加组件

![img_2.png](assets/img_2.png)

```java
public class RunView extends VBox {
    //玩家和迷宫视图
    private PlayerView playerView;
    private MazeView mazeView;
    //难度显示和计时器
    private Label currentDifficulty;
    private Label currentTime;
    //重置游戏和提示按钮
    private Button resetButton;
    private Button hintButton;

    public RunView(GameController gameController) {
        setSpacing(20);
        setAlignment(Pos.CENTER);
        /*游戏页面分割为三部分，自上而下的布局
                1.HBox:添加计时器和难度显示->平行布局
                2.Maze视图和Player视图
                3.HBox:添加重置游戏和提示交互按钮->平行布局
         */
        currentDifficulty = new Label("当前难度:");
        currentTime = new Label("当前用时:");

        mazeView = new MazeView(gameController.getGameService().getGameModel().getMaze());
        playerView = new PlayerView(gameController.getGameService().getGameModel().getPlayer());

        resetButton = new Button("重置游戏");
        hintButton = new Button("提示");

        //HBox->infoBox:计时器和难度显示
        HBox infoBox = new HBox(20, currentTime, currentDifficulty);
        infoBox.setAlignment(Pos.CENTER);
        //HBox->controlBox:重置游戏和提示交互按钮
        HBox controlBox = new HBox(20, resetButton, hintButton);
        controlBox.setAlignment(Pos.CENTER);

        getChildren().addAll(infoBox, mazeView, playerView.getNode(), controlBox);
    }
}
```
### 6.5 VictoryView

**VictoryView** 用来显示游戏胜利的页面，使用 **VBox** 作为主控局容器

![img_3.png](assets/img_3.png)

```java
public class VictoryView extends VBox {
    public VictoryView(){
        setAlignment(Pos.CENTER);
        setSpacing(20);
        Label victoryLabel = new Label("恭喜通关!");
        victoryLabel.setFont(new Font(24));

        getChildren().add(victoryLabel);
    }

}
```
### 6.6 自定义事件类型 ViewSwitchEvent

使用 **JavaFx** 的事件响应机制来设计游戏页面的切换

```java
//添加事件处理器
    private void addEventHandlers() {
        /*
        addEventHandler需要传入事件类型和实现Handler接口的类
        1.事件类型
        这里我们要处理的事件类型是页面之间的切换->不是类中的原始事件类型->需要自己定义
        ->自定义事件ViewSwitchEvent
        2.实现Handler接口的类
        （1）匿名内部类的方法来实现
        （2）lamda表达式可以用来实现只有一个方法的接口
         */
        addEventHandler(ViewSwitchEvent.SWITCH_TO_WELCOME,event->{showWelcomeView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_PREPARE,event->{showPrepareView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_SELECTION, event->{showSelectionView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_RUN,event->{showRunView();});
        addEventHandler(ViewSwitchEvent.SWITCH_TO_VICTIORY,event->{showVictoryView();});
    }
```

由于我们的事件不是原始事件类型，我们还需要设计对应的自定义事件类型

```java
public class ViewSwitchEvent extends Event {
    //自定义的事件类，都需要实现抽象父类的构造方法
    public ViewSwitchEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
    /*自定义的事件类型
    事件类型的构造器需要传入一个event的子类和String来表示这个事件类型的名字
    这里使用的ANY是任意事件类型
     */
    public static final EventType<ViewSwitchEvent>SWITCH_TO_WELCOME=new EventType<>(ANY,"SWITCH_TO_WELCOME");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_SELECTION=new EventType<>(ANY,"SWITCH_TO_SELECTION");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_PREPARE=new EventType<>(ANY,"SWITCH_TO_PREPARE");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_RUN=new EventType<>(ANY,"SWITCH_TO_RUN");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_VICTIORY=new EventType<>(ANY,"SWITCH_TO_VICTIORY");

}
```

---
**未完待续**

2024/06/05:

把Model层的的**Draw()** 移动至View层，进一步保证了各层之间的职责独立，今天的README没来得及改

2024/06/06

README里面的代码有改动，基本的游戏移动判断逻辑已经完成，就差页面排版和难度选择的一些小功能

**Model层**职责分离完成

---

**Todo:**
- **Controller层设计**
  - view层交互选择游戏难度
  
- **View层设计**
    - ~~游戏页面的设计~~
    - ~~地图绘制位置设计~~
    - ~~考虑添加难度选择设计~~
    - ~~添加交互设计~~
    - ~~添加计时器设计~~
- **App主程序入口设计**