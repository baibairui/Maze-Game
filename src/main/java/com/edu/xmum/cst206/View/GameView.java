package com.edu.xmum.cst206.View;

import com.edu.xmum.cst206.Model.GameObject;
import javafx.scene.layout.Pane;


import javafx.scene.layout.Pane;

public class GameView extends Pane {
    public GameView() {
        setPrefSize(800, 600);
    }

    public void addGameObject(GameObject gameObject) {
        System.out.println("Adding game object: " + gameObject);
        getChildren().add(gameObject.getNode());
    }

    public void removeGameObject(GameObject gameObject) {
        getChildren().remove(gameObject.getNode());
    }
}