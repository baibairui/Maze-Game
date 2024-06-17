package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.AiView;
import com.edu.xmum.cst206.View.Entity.V1.PlayerViewV1;
import com.edu.xmum.cst206.View.Entity.V2.PlayerViewV2;
import com.edu.xmum.cst206.View.Entity.V3.PlayerViewV3;
import com.edu.xmum.cst206.View.Entity.V3.SecondPlayerViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class PlayerViewFactory extends AbstractFactory{
    @Override
    public IPlayerView getPlayerView(Skin player, IPlayerModel playerModel) {
        if(player.getSkin().equals("V1")){
            return new PlayerViewV1(playerModel);
        }else if(player.getSkin().equals("V2")){
            return new PlayerViewV2(playerModel);
        }else if(player.getSkin().equals("V3")){
            return new PlayerViewV3(playerModel);
        }else if(player.getSkin().equals("Vs")){
            return new SecondPlayerViewV3(playerModel);
        }else if(player.getSkin().equals("AI")){
            return new AiView(playerModel);
        }
        return null;
    }

}
