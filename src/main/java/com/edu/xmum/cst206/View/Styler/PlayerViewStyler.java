package com.edu.xmum.cst206.View.Styler;

import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Beautification of PlayerView based on Appearance Pattern Design.
 * Applies styles to the player view based on the selected skin.
 */
public class PlayerViewStyler {

    /**
     * Styles the player view based on the specified skin.
     *
     * @param skin       The skin to apply to the player view.
     * @param playerView The ImageView representing the player.
     * @param cellSize   The size of each cell in the maze.
     * @param player     The player model instance.
     * @param playerDir  The direction the player is facing.
     */
    public static void playerViewStyle(Skin skin, ImageView playerView, int cellSize, IPlayerModel player, String playerDir) {
        if (playerView == null) return;
        switch (skin) {
            // Setting up V1 player skins
            case V1 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/豌豆" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            // Setting up the player skin for V2
            case V2 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/hhh.gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            // Setting up V3 player skins
            case V3 -> {
                Image playImg = new Image("com/edu/xmum/cst206/player/皮卡丘" + playerDir + ".gif");
                playerView.setImage(playImg);
                playerView.setFitHeight(cellSize);
                playerView.setFitWidth(cellSize);
                playerView.setX(player.getX() * cellSize);
                playerView.setY(player.getY() * cellSize);
            }
            // Setting up Vs player skins
            case Vs -> {
                // Tentatively designed as a pea
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
