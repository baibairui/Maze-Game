package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.VictoryViewV1;
import com.edu.xmum.cst206.View.Entity.V2.VictoryViewV2;
import com.edu.xmum.cst206.View.Entity.V3.VictoryViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class VictoryViewFactory extends AbstractFactory{

    @Override
    public IVictoryView getVictoryView(Skin victoryView) {
        if(victoryView.getSkin().equals("V1")){
            return new VictoryViewV1();
        } else if (victoryView.getSkin().equals("V2")) {
            return new VictoryViewV2();
        }else if(victoryView.getSkin().equals("V3")){
            return new VictoryViewV3();
        }
        return null;
    }
}
