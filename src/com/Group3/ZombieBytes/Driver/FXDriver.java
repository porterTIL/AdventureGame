package com.Group3.ZombieBytes.Driver;

import com.Group3.ZombieBytes.Game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class FXDriver extends Application {
    private static int xRes = 400;
    private static int yRes = 400;
    private static Paint backgroundColor = Color.WHITE; //!DON'T USE AWT
    private static String appName = "ZombieBytes";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Create group of images for scene
        Group root = new Group();
        //Create a scene
        Scene scene = new Scene(root, xRes, yRes);
        //Set scene background color
        scene.setFill(backgroundColor);
        //Set title
        stage.setTitle(appName);
        //display scene
        stage.setScene(scene);
        stage.show();
        Game.start();
    }
}
