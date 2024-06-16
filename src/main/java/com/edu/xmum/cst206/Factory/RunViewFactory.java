package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.RunViewV1;
import com.edu.xmum.cst206.View.Entity.V2.RunViewV2;
import com.edu.xmum.cst206.View.Entity.V3.RunViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class RunViewFactory extends AbstractFactory{

    @Override
    public IRunView getRunView(Skin runView, IGameController gameController) {
        if(runView.getSkin().equals("V1")){
            return new RunViewV1(gameController);
        }else if(runView.getSkin().equals("V2")){
            return new RunViewV2(gameController);
        }else if(runView.getSkin().equals("V3")){
            return new RunViewV3(gameController);
        }
        return null;
    }
}
