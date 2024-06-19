package Constant;

public class Config {
    public static final int SCENE_HEIGHT = 800;
    public static final int SCENE_WIDTH = 600;
    public static final int ROWS = 60;
    public static final int COLS = 60;
    // Define min and max speeds
    public static final double MIN_SPEED = 0.5; // Fastest
    public static final double MAX_SPEED = 1.0; // Slowest
    public static Difficulty diff = Difficulty.EASY;
    public static Skin skin = Skin.V3;
    public static String hint = "hint";
    // Calculate AI speed based on difficulty
    public static double AI_SPEED = calculateAISpeed();

    private static double calculateAISpeed() {
        double normalizedDiff = (diff.getMazeSize() - Difficulty.EASY.getMazeSize()) /
                (double) (Difficulty.HARD.getMazeSize() - Difficulty.EASY.getMazeSize());
        return MIN_SPEED + (MAX_SPEED - MIN_SPEED) * normalizedDiff;
    }
}
