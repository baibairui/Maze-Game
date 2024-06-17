package Constant;

/*
Diffculty表示游戏的难度，全局只需要创建一次，通过枚举来实现单例模式

 */
public enum Difficulty {
    EASY, MEDIUM, HARD;

    public int getMazeSize() {
        switch (this) {
            case EASY:
                return 15; // 简单难度的迷宫大小
            case MEDIUM:
                return 25; // 中等难度的迷宫大小
            case HARD:
                return 35; // 困难难度的迷宫大小
            default:
                return 15;
        }
    }

}