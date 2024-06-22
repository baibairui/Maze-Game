package com.edu.xmum.CST210.AlgorithmStrategy;

import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Implementation of the A* algorithm for pathfinding in a maze.
 * This class uses the A* algorithm to find the shortest path from the starting position to the goal position.
 */
public class AstarStrategy implements IFindPathStrategy {

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
}
