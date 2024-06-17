package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import Constant.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
基于外观模式设计对PlayerView的美化——相当于css文件

 */
public class PlayerViewStyler {
    public static void playerViewStyle(Skin skin, ImageView playerView, int cellSize, IPlayerModel player, String playerDir) {
        if (playerView == null) return;
        switch (skin) {
            //设置V1的玩家皮肤
            case V1 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/豌豆" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize); // 修正这里，应该设置宽度而不是再设置一次高度
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            //设置V2的玩家皮肤
            case V2 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/皮卡丘" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize); // 修正这里，应该设置宽度而不是再设置一次高度
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            //设置V3的玩家皮肤
            case V3 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/皮卡丘" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize); // 修正这里，应该设置宽度而不是再设置一次高度
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            case Vs -> {
                //暂时设计为豌豆
                Image playImg = new Image("com/edu/xmum/cst206/player/小黄人" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize); // 修正这里，应该设置宽度而不是再设置一次高度
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
        }
    }
}
