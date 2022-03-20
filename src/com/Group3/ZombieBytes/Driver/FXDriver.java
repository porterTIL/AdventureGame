package com.Group3.ZombieBytes.Driver;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.Display.Doodler;
import com.Group3.ZombieBytes.Util.UserInput.Input;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXDriver extends Application {
    private static TextField userInput = new TextField("Enter your command here!");
    private static TextArea userOutput = new TextArea();
    public final static String appName = "ZombieBytes";
    static private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        this.stage=stage;
        //doodling text
        userInput.setAlignment(Pos.BOTTOM_CENTER);
        //Set scene background color
        //scene.setFill(Color.BLANCHEDALMOND);
        //Set title
        stage.setTitle(appName);
        //display scene
        stage.setScene(Doodler.drawStartScene());
        stage.show();
    }
    public static TextField getInputField(){
        return userInput;
    }
    public static TextArea getTextField(){
        return userOutput;
    }
    public static void setScene(Scene scene){
        if(stage!=null) stage.setScene(scene);
    }
    public void startGame(){
        setScene(Doodler.drawStartScene());
        Game.start(new Input());
    }
}
