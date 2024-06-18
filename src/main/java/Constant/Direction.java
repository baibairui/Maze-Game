package Constant;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public int getDirectionX() {
        switch (this) {
            case LEFT:
                return -1; // turn left
            case RIGHT:
                return 1; // turn right
            default:
                return 0; // No change in X direction when moving up or down
        }
    }

    public int getDirectionY() {
        switch (this) {
            case UP:
                return -1; // upwards
            case DOWN:
                return 1; // move down
            default:
                return 0; // Y direction is unchanged when moving to the left or to the right
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
                return "Down"; // Default down
            }
        }
    }

}
