package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Implementation of the player view for version 3.
 * This class is responsible for displaying the player with graphical representations based on the chosen skin and direction.
 */
public class PlayerViewV3 extends Pane implements IPlayerView {
    private final IPlayerModel player;
    private int cellSize;
    private Direction direction;

    /**
     * Constructor to initialize the PlayerViewV3 components.
     *
     * @param playerModel The player model to be displayed.
     */
    public PlayerViewV3(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN; // Default direction is down
    }

    /**
     * Draws the player using graphical representations based on the chosen skin and direction.
     */
    @Override
    public void draw() {
        ImageView playerView = new ImageView();
        // Setting style
        PlayerViewStyler.playerViewStyle(Skin.V3, playerView, cellSize, player, direction.toString());

        getChildren().clear();
        getChildren().add(playerView);
    }

    /**
     * Redraws the player by calling the draw method.
     */
    @Override
    public void reDraw() {
        draw();
    }

    /**
     * Sets the size of each cell in the player view.
     *
     * @param cellSize The size of each cell.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Gets the root node of the PlayerView.
     *
     * @return The Pane root node.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Sets the direction of the player and redraws the player view.
     *
     * @param direction The new direction of the player.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
