package com.edu.xmum.cst206.AlgorithmStrategy;

import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AstarStrategy implements IFindPathStrategy {

    public static class Node implements Comparable<Node> {
        int x, y; // coordinate
        int g; // The cost of moving from the starting point to the current coordinates
        int h; // The estimated cost of moving to the target point, the heuristic function

        public Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        // Criteria used for evaluation
        int f() {
            return g + h;
        }

        // Used to compare the size of the cost
        @Override
        public int compareTo(@NotNull Node o) {
            return Integer.compare(this.f(), o.f());
        }

        // For set de-duplication
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
    public boolean findPath(IMazeModel mazeModel, List<int[]> path, boolean[][] visited, int x, int y, int goalX, int goalY) {
        // Priority queue to ensure that the node with the smallest f value is processed every time
        PriorityQueue<Node> openList = new PriorityQueue<>();
        // Used to store nodes that have already been processed to prevent duplication
        Set<Node> closedList = new HashSet<>();
        // A container used to record paths, each time placing the point with the smallest cost from the goal into the container
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

    // heuristic function
    private int heuristic(int x, int y, int goalX, int goalY) {
        return Math.abs(x - goalX) + Math.abs(y - goalY);
    }

    //Retrospective construction routes
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
