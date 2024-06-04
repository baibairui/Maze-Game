# CST206
基于JavaFx开发的迷宫游戏

---

## 1. 代码架构

游戏基于**MVC设计模式**并引入**Service层** 处理游戏中涉及的**相关逻辑**，以保证各层之间**高内聚和低耦合**

**M(游戏模型层):** 存储游戏中涉及的类对象

**V(游戏视图层):** 通过GUI库**JavaFx**给用户提供交互页面

**C(交换控制层):** 通过**JavaFx**中的事件响应功能与后端进行交互

**S(逻辑处理层):** 处理游戏中涉及碰撞移动等功能

### **1.1 Model**

#### 1.1.1 接口的设计
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

#### 1.1.2 对象的设计
游戏模型是**基于XX模式**来设计的，定义了游戏中所有**游戏对象的抽象父类GameObject**

**(1)抽象父类**

抽象父类中定义了游戏对象应有的**属性**并给出了相关的**get和set**方法以便其他层进行调用
```java
 public abstract class GameObject{
    protected double x;//横坐标
    protected double y;//纵坐标
    protected double width;//宽
    protected double height;//高
    protected Color color;//颜色
    protected Node node;//绑定的节点

    public GameObject(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.node = null;//如何绘制对象以及是否需要显示由具体类决定
    }
 }
```


**(2) Player**

**Player类**需要玩家通过**JavaFx**的事件响应来移动并绘制在页面上，因此需要实现**Moveable和Drawable**接口的功能

这里我们设定玩家操控的是球形

```java
public class Player extends GameObject implements Moveable, Drawable {
    private double radius;

    public Player(double x, double y, double radius, Color color) {
        super(x, y, radius * 2, radius * 2, color); // 宽度和高度为直径
        this.radius = radius;
        this.node = draw();
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    // 绘制玩家的方法
    @Override
    public Node draw() {
        Circle circle = new Circle(x, y, radius, color);
        return circle;
    }

    // 玩家类的移动方法
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        updateNodePosition();
    }

    @Override
    public void updateNodePosition() {
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
}

```
**(3) Maze**

**迷宫类**需要被绘制在界面并且不可移动，因此需要实现 **Drawable** 接口

这里我们使用一个二维数组来表示这个迷宫并设计可以通过前端的来选择这个迷宫类的行数和列数。

```java
public class Maze extends GameObject implements Drawable {
    private final int rows;//迷宫的行数
    private final int cols;//迷宫的列数
    private final int[][] maze;//用于表示迷宫，0表示通路，1表示墙
    //Maze的构造方法
    public Maze(int x,int y,int width,int hight,Color color,int rows, int cols) {
        super(x,y,width,hight,color);
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMazePrim();
        this.node=draw();
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
    
    /*实现的draw方法
    这里我们用方形来绘制迷宫地图，二维矩阵中
    1是墙壁——>用白色方块来表示
    0是通路——>用黑色方块来表示
     */
    public Node draw() {
        Pane pane = new Pane();
        int cellSize = CELL_SIZE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Rectangle rect = new Rectangle(j * cellSize, i * cellSize, cellSize, cellSize);
                rect.setFill(maze[i][j] == 1 ? Color.BLACK : Color.WHITE);//1是墙壁，0是通路
                rect.setStroke(Color.GRAY);
                pane.getChildren().add(rect);
            }
        }
        return pane;
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

### **1.2 Service**

**Service层** 用于处理游戏相关逻辑的判断与处理，在迷宫游戏中需要判断**Controller层**传入的请求并对**Model层**进行操作

#### 1.2.1 MazeService
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
#### 1.2.2 PlayerService

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

### **1.3 Controller**

**Controller层**用于与处理前端发起的请求，返回后端的响应

