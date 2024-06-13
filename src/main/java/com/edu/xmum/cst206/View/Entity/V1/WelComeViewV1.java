package com.edu.xmum.cst206.View.Entity.V1;

import com.edu.xmum.cst206.View.Interface.IWelcomeView;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;

import static com.edu.xmum.cst206.Config.SCENE_HEIGHT;
import static com.edu.xmum.cst206.Config.SCENE_WIDTH;

public class WelComeViewV1 extends StackPane implements IWelcomeView {
    private final Button startButton = new Button("开始游戏");

    public WelComeViewV1() {
        super();



        // 加载css样式
        URL cssURL = getClass().getResource("/v1.css");
        if (cssURL == null) {
            System.err.println("CSS file not found");
        } else {
            System.out.println("CSS file found: " + cssURL.toExternalForm());
            getStylesheets().add(cssURL.toExternalForm());
        }

        //内容盒子,通过css样式美化
        VBox contentBox=new VBox();
        Label titleLabel = new Label("欢迎来到迷宫游戏");

        titleLabel.setFont(new Font(50));
        titleLabel.setStyle("-fx-font-size: 50px; " +
                "-fx-font-weight: bold;" +
                " -fx-text-fill: #667fe3;" +
                " -fx-effect: dropshadow(gaussian, rgba(117, 26, 26, 0.75), 10, 0.5, 0, 0);");

        startButton.setStyle("-fx-background-color: #3f4b57; /* 按钮背景颜色为蓝色 */" +
                "    -fx-text-fill: white; /* 按钮文本颜色为白色 */" +
                "    -fx-font-size: 16px;" +
                "    -fx-padding: 10px 20px;" +
                "    -fx-border-radius: 5; /* 按钮圆角 */" +
                "    -fx-cursor: hand; /* 鼠标悬停时显示为手型光标 */" +
                "    -fx-effect: dropshadow(gaussian, rgba(38, 6, 6, 0.75), 5, 0.5, 0, 0); /* 添加阴影效果 */");

        contentBox.getChildren().addAll(titleLabel,startButton);

        contentBox.setSpacing(20);
        contentBox.setAlignment(Pos.CENTER);

        //背景设置


        getChildren().addAll(contentBox);
    }

    public Button getStartButton() {
        return startButton;
    }

    @Override
    public Node getNode() {
        return this;
    }
}