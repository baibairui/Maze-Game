package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.PrepareViewV1;
import com.edu.xmum.cst206.View.Entity.V2.PrepareViewV2;
import com.edu.xmum.cst206.View.Entity.V3.MazeViewV3;
import com.edu.xmum.cst206.View.Entity.V3.PrepareViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class PrepareViewFactory extends AbstractFactory{

    @Override
    public IPrepareView getPrepareView(Skin prepareView) {
        if(prepareView.getSkin().equals("V1")){
            return new PrepareViewV1();
        }else if(prepareView.getSkin().equals("V2")){
            return new PrepareViewV2();
        }else if(prepareView.getSkin().equals("V3")){
            return new PrepareViewV3();
        }
        return null;
    }
}
