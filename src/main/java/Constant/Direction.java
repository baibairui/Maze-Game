package Constant;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public int getDirectionX() {
        switch (this) {
            case LEFT:
                return -1; // 向左移动
            case RIGHT:
                return 1; // 向右移动
            default:
                return 0; // 向上或向下移动时，X方向不变
        }
    }

    public int getDirectionY() {
        switch (this) {
            case UP:
                return -1; // 向上移动
            case DOWN:
                return 1; // 向下移动
            default:
                return 0; // 向左或向右移动时，Y方向不变
        }
    }

    public String toString() {
        switch (this) {
            case UP -> {
                return "Up";
            }
            case DOWN -> {
                return "Down";
            }
            case LEFT -> {
                return "Left";
            }
            case RIGHT -> {
                return "Right";
            }
            default -> {
                return "Down"; // 默认向下
            }
        }
    }

}
