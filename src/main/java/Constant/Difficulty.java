package Constant;

/*
Diffculty indicates the difficulty of the game, globally it only needs to be created once, and the singleton pattern is implemented through enumeration

 */
public enum Difficulty {
    EASY, MEDIUM, HARD;

    public int getMazeSize() {
        switch (this) {
            case EASY:
                return 15; // Easy difficulty maze size
            case MEDIUM:
                return 25; // Medium difficulty maze size
            case HARD:
                return 35; // Labyrinth size on hard difficulty
            default:
                return 15;
        }
    }

}