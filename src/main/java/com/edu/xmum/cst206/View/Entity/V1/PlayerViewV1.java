package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Represents the PlayerView for version 1.
 * Implements the IPlayerView interface.
 */
public class PlayerViewV1 extends Pane implements IPlayerView {
    private int cellSize;
    private final IPlayerModel player;
    private Direction direction;

    /**
     * Constructs the PlayerViewV1 with the specified player model.
     *
     * @param playerModel The player model associated with this view.
     */
    public PlayerViewV1(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN; // Default direction is down
    }

    /**
     * Draws the player view for the first time.
     * Uses the PlayerViewStyler to style the player based on the specified skin and direction.
     */
    @Override
    public void draw() {
        // Setting the Player View
        ImageView playerView = new ImageView();
        PlayerViewStyler.playerViewStyle(Skin.V1, playerView, cellSize, player, direction.toString());
        getChildren().clear();
        getChildren().add(playerView);
    }

    /**
     * Redraws the player view, updating any changes.
     */
    @Override
    public void reDraw() {
        draw();
    }

    /**
     * Sets the cell size for the player view.
     *
     * @param cellSize The size of each cell in the view.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Gets the root node of the player view.
     *
     * @return The Pane root node.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Sets the direction for the player movement and redraws the view.
     *
     * @param direction The direction to set.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
