package com.edu.xmum.cst206.View.Entity.V2;

import com.edu.xmum.cst206.Model.Direction;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Interface.IPlayerView;
import com.edu.xmum.cst206.View.Styler.PlayerViewStyler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlayerViewV2 extends Pane implements IPlayerView {
    private int cellSize;
    private IPlayerModel player;
    private Direction direction;

    public PlayerViewV2(IPlayerModel playerModel){
        this.player=playerModel;
        direction=Direction.DOWN;//默认向下
    }

    @Override
    public void draw() {
        //设置玩家视图
        ImageView playerView = new ImageView();
        PlayerViewStyler.playerViewStyle(Skin.V1,playerView,cellSize,player,direction.toString());
        getChildren().clear();
        getChildren().add(playerView);
    }

    @Override
    public void reDraw() {
        draw();
    }

    @Override
    public void setCellSize(int cellSize) {
        this.cellSize=cellSize;
    }

    @Override
    public Pane getNode() {
        return this;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction=direction;
    }
}
