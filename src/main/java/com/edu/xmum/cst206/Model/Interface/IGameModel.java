package com.edu.xmum.cst206.Model.Interface;

import com.edu.xmum.cst206.Service.Interface.IAiService;

public interface IGameModel {
    IPlayerModel getPlayModel();

    IMazeModel getMazeModel();

    IPlayerModel getAiModel();

    IPlayerModel getSecondPlayModel();
}
