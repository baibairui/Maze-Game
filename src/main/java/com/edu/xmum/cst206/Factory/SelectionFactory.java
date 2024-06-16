package com.edu.xmum.cst206.Factory;

import com.edu.xmum.cst206.Controller.IGameController;
import com.edu.xmum.cst206.Model.Interface.IMazeModel;
import com.edu.xmum.cst206.Model.Interface.IPlayerModel;
import com.edu.xmum.cst206.Model.Skin;
import com.edu.xmum.cst206.View.Entity.V1.SelectionViewV1;
import com.edu.xmum.cst206.View.Entity.V2.SelectionViewV2;
import com.edu.xmum.cst206.View.Entity.V3.SelectionViewV3;
import com.edu.xmum.cst206.View.Interface.*;

public  class SelectionFactory extends AbstractFactory{

    @Override
    public ISelectionView getSelectionView(Skin selectionView) {
        if(selectionView.getSkin().equals("V1")){
            return new SelectionViewV1();
        }else if(selectionView.getSkin().equals("V2")){
            return new SelectionViewV2();
        }else if(selectionView.getSkin().equals("V3")){
            return new SelectionViewV3();
        }
        return null;
    }
}
