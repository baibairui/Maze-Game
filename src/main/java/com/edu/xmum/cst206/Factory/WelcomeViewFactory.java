package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.WelComeViewV1;
import com.edu.xmum.cst206.View.Entity.V2.WelcomeViewV2;
import com.edu.xmum.cst206.View.Entity.V3.WelcomeViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public class WelcomeViewFactory extends AbstractFactory{
    @Override
    public IWelcomeView getWelcomeView(Skin welcomeVIew) {
        if(welcomeVIew.getSkin().equals("V1")){
            return new WelComeViewV1();
        } else if (welcomeVIew.getSkin().equals("V2")) {
            return new WelcomeViewV2();
        }else if (welcomeVIew.getSkin().equals("V3")){
            return new WelcomeViewV3();
        }
        return null;
    }
}
