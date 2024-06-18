package com.edu.xmum.cst206.View.Styler;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import Constant.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
Beautification of PlayerView based on Appearance Pattern Design - equivalent css file

 */
public class PlayerViewStyler {
    public static void playerViewStyle(Skin skin, ImageView playerView, int cellSize, IPlayerModel player, String playerDir) {
        if (playerView == null) return;
        switch (skin) {
            //Setting up V1 player skins
            case V1 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/豌豆" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            //Setting up the player skin for V2
            case V2 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/hhh.gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            //Setting up V3 player skins
            case V3 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/皮卡丘" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            case Vs -> {
                //Tentatively designed as a pea
                Image playImg = new Image("com/edu/xmum/cst206/player/小黄人" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
        }
    }
}
