package com.edu.xmum.cst206.Service.Interface;

import com.edu.xmum.cst206.Model.Interface.IPlayerModel;

public interface IAiService {
   void moveAi();
   boolean isPlayerCaught();
   IPlayerModel getAiModel();
   void reset();
}
