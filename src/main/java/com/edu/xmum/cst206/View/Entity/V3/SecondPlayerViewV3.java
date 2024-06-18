package com.edu.xmum.cst206.View.Entity.V3;

import Constant.Direction;
import Constant.Skin;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Implementation of the second player view for version 3.
 * This class is responsible for displaying the second player with graphical representations
 * based on the chosen skin and direction.
 */
public class SecondPlayerViewV3 extends Pane implements IPlayerView {
    private int cellSize;
    private final IPlayerModel player;
    private Direction direction;

    /**
     * Constructor to initialize the SecondPlayerViewV3 components.
     *
     * @param playerModel The player model to be displayed.
     */
    public SecondPlayerViewV3(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN; // Default direction is down
    }

    /**
     * Draws the second player using graphical representations based on the chosen skin and direction.
     */
    @Override
    public void draw() {
        // Determine the direction of the player
        String playerDir;
        switch (direction) {
            case UP -> playerDir = "Up";
            case DOWN -> playerDir = "Down";
            case LEFT -> playerDir = "Left";
            case RIGHT -> playerDir = "Right";
            default -> playerDir = "Down"; // Default down
        }

        // Setting the Player View
        ImageView playerView = new ImageView();
        PlayerViewStyler.playerViewStyle(Skin.Vs, playerView, cellSize, player, playerDir);
        getChildren().clear();
        getChildren().add(playerView);

        // Debugging Information
        System.out.println("x: " + player.getX() + " Y: " + player.getY());
        System.out.println("Second player draw done");
    }

    /**
     * Redraws the second player by calling the draw method.
     */
    @Override
    public void reDraw() {
        draw();
    }

    /**
     * Sets the size of each cell in the second player view.
     *
     * @param cellSize The size of each cell.
     */
    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Gets the root node of the SecondPlayerView.
     *
     * @return The Pane root node.
     */
    @Override
    public Pane getNode() {
        return this;
    }

    /**
     * Sets the direction of the second player and redraws the player view.
     *
     * @param direction The new direction of the second player.
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
