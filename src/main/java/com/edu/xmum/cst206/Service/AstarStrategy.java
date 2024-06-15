package com.edu.xmum.cst206.Service;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Service.Interface.IFindPathStrategy;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AstarStrategy implements IFindPathStrategy {

    public static class Node implements Comparable<Node> {
        int x, y; // 坐标
        int g; // 从起点移动到当前坐标的代价
        int h; // 移动到目标点的估算代价，启发函数

        public Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        // 用于评价的标准
        int f() {
            return g + h;
        }

        // 用于比较代价的大小
        @Override
        public int compareTo(@NotNull Node o) {
            return Integer.compare(this.f(), o.f());
        }

        // 用于set去重
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    @Override
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y,int goalX,int goalY) {
        // 优先级队列，用来保证每次都是处理f值最小的节点
        PriorityQueue<Node> openList = new PriorityQueue<>();
        // 用来储存已经处理过的节点，防止重复
        Set<Node> closedList = new HashSet<>();
        // 用来记录路径的容器，每次都将距离目标代价最小的点放入容器
        Map<Node, Node> pathRecord = new HashMap<>();

        Node startNode = new Node(x, y, 0, heuristic(x, y,goalX, goalY));
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

                Node neighborNode = new Node(neighborX, neighborY, currentNode.g + 1, heuristic(neighborX, neighborY, goalX,goalY));
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

    // 启发函数
    private int heuristic(int x, int y, int goalX, int goalY) {
        return Math.abs(x - goalX) + Math.abs(y - goalY);
    }
    //回溯构建路线
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
