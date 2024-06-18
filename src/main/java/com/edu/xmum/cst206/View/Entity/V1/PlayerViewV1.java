package com.edu.xmum.cst206.View.Entity.V1;

import Constant.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import Constant.Skin;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayerViewV1 extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    private Direction direction;

    public PlayerViewV1(IPlayerModel playerModel) {
        this.player = playerModel;
        this.direction = Direction.DOWN;//Default down
    }

    @Override
    public void draw() {
        //Setting the Player View
        ImageView playerView = new ImageView();
        PlayerViewStyler.playerViewStyle(Skin.V1, playerView, cellSize, player, direction.toString());
        getChildren().clear();
        getChildren().add(playerView);
    }

    @Override
    public void reDraw() {
        draw();
    }

    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        draw();
    }
}
