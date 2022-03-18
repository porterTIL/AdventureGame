package com.Group3.ZombieBytes.Driver;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.Display.Doodler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXApp extends Application {
    public final static int xRes = 400;
    public final static int yRes = 400;
    private static Paint backgroundColor = Color.WHITE; //!DON'T USE AWT
    private static String appName = "ZombieBytes";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        //doodling text
        Text start = new Text("Start");
        start.setX(50);
        start.setY(50);
        start.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> Game.start());
        Text quit = new Text("Quit");
        quit.setX(200);
        quit.setY(50);
        //Create group of doodles for scene
        Group root = new Group(start, quit);
        //Create a scene
        Scene scene = new Scene(root, xRes, yRes);
        //Set scene background color
        //scene.setFill(Color.BLANCHEDALMOND);
        //Set title
        stage.setTitle(appName);
        //display scene
        stage.setScene(scene);
        stage.show();
    }
}
