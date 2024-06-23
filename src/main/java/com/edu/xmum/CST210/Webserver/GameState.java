package com.edu.xmum.CST210.Webserver;

import com.edu.xmum.CST210.Model.Interface.IGameModel;
import com.edu.xmum.CST210.Model.Interface.IMazeModel;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;
import Constant.Direction;

public class GameState {
    private IGameModel gameModel;

    public GameState(IGameModel gameModel) {
        this.gameModel = gameModel;
    }
    public IGameModel getGameModel(){
        return  gameModel;
    }
    // 根据键盘输入更新游戏状态
    public void update(String keyCode) {
        Direction direction = null;
        boolean isPlayerOne = true;

        switch (keyCode.toUpperCase()) {
            case "W":
                direction = Direction.UP;
                break;
            case "A":
                direction = Direction.LEFT;
                break;
            case "S":
                direction = Direction.DOWN;
                break;
            case "D":
                direction = Direction.RIGHT;
                break;
            case "I":
                direction = Direction.UP;
                isPlayerOne = false;
                break;
            case "J":
                direction = Direction.LEFT;
                isPlayerOne = false;
                break;
            case "K":
                direction = Direction.DOWN;
                isPlayerOne = false;
                break;
            case "L":
                direction = Direction.RIGHT;
                isPlayerOne = false;
                break;
        }

        if (isPlayerOne) {
            gameModel.getPlayModel().move(direction.getDirectionX(),direction.getDirectionY());
        } else {
            gameModel.getSecondPlayModel().move(direction.getDirectionX(),direction.getDirectionY());
        }
    }

    // 序列化游戏状态为字符串
    @Override
    public String toString() {
        return gameModel.toString();
    }

    // 从字符串反序列化游戏状态
    public void fromString(String data) {
        gameModel.fromString(data);
    }
}
