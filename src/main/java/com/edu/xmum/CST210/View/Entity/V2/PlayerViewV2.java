package com.edu.xmum.CST210.View.Entity.V2;

import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.CST210.Model.Interface.IPlayerModel;
import com.edu.xmum.CST210.View.Interface.IPlayerView;
import com.edu.xmum.CST210.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Implementation of the player view for version 2.
 * This class is responsible for displaying the player using the specified skin and direction.
 */
public class PlayerViewV2 extends Pane implements IPlayerView {
    private final IPlayerModel player;
    private int cellSize;
    private Direction direction;

    /**
     * Constructs the PlayerViewV2 with the specified player model.
     *
     * @param playerModel The player model associated with this view.
     */
    public PlayerViewV2(IPlayerModel playerModel) {
        this.player = playerModel;
        direction = Direction.DOWN; // Default direction is down
    }

    /**
     * Draws the player view for the first time.
     * Uses the PlayerViewStyler to style the player based on the specified skin and direction.
     */
    @Override
    public void draw() {
        // Setting the Player View
        ImageView playerView = new ImageView();
        // Setting style
        PlayerViewStyler.playerViewStyle(Skin.V2, playerView, cellSize, player, direction.toString());

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
     * Sets the direction for the player movement.
     *
     * @param direction The direction to set.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
