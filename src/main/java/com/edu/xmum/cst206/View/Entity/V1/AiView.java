package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Represents the AI view in the game.
 * Implements the IPlayerView interface.
 */
public class AiView extends Pane implements IPlayerView {
    private int cellSize;
    private final IPlayerModel player;
    private Direction direction;

    /**
     * Constructs the AiView with the specified player model.
     *
     * @param playerModel The player model associated with the AI.
     */
    public AiView(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN; // Default direction is down
    }

    /**
     * Draws the AI view for the first time.
     * Loads the AI image and positions it based on the player's coordinates.
     */
    @Override
    public void draw() {
        Image playImg = new Image("com/edu/xmum/cst206/player/僵尸4.gif");
        ImageView playerView = new ImageView(playImg);
        playerView.setFitHeight(cellSize);
        playerView.setFitWidth(cellSize); // Set the width instead of the height again
        playerView.setX(player.getX() * cellSize);
        playerView.setY(player.getY() * cellSize);

        getChildren().clear();
        getChildren().add(playerView);
    }

    /**
     * Redraws the AI view, updating any changes.
     */
    @Override
    public void reDraw() {
        draw();
    }

    /**
     * Sets the cell size for the AI view.
     *
     * @param cellSize The size of each cell in the view.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Gets the main node of the AI view.
     *
     * @return The Pane containing the AI view.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Sets the direction for the AI movement and redraws the view.
     *
     * @param direction The direction to set.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
