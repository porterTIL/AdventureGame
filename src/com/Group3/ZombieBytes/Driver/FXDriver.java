package com.Group3.ZombieBytes.Driver;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.Display.Doodler;
import com.Group3.ZombieBytes.Util.UserInput.ReaderInput;
import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXDriver extends Application {
    private static TextField userInput = new TextField();
    private static TextArea userOutput = new TextArea();
    public final static String appName = "ZombieBytes";
    static private Stage stage;

    public static void main(String[] args) {
        // starts the game
        System.out.println("Would you like to play with graphics Y/N");
        ReaderInput reader = new ReaderInput();
        if(reader.readLine().equalsIgnoreCase("y")){
            launch(args);
        } else {
            try {
                Game.start(reader);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    //starts game launcher, see Doodler::drawStartScene
    public void start(Stage stage) {
        stage.setTitle(appName); //set title to app name
        stage.setScene(Doodler.drawStartScene()); //display scene
        stage.show(); //I hate that you have to do this, but it makes sense
        this.stage = stage;//keep a reference for changing later I hate that you have to do this even more, because it doesn't make sense
    }
    //accessors
    public static TextField getInputField(){
        return userInput;
    }
    public static TextArea getTextField() {
        return userOutput;
    }
    public static Stage getStage() {
        return stage;
    }
}
