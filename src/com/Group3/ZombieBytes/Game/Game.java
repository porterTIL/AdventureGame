package com.Group3.ZombieBytes.Game;
//import com.Group3.ZombieBytes.Game.Data.lifeforms.Character;
//import com.Group3.ZombieBytes.Game.Data.lifeforms.Zombie;

import com.Group3.ZombieBytes.Driver.FXDriver;
import com.Group3.ZombieBytes.Game.Data.Location;
import com.Group3.ZombieBytes.Util.Display.DisplayContent;
import com.Group3.ZombieBytes.Util.Display.Doodler;
import com.Group3.ZombieBytes.Util.Display.GameText;
import com.Group3.ZombieBytes.Util.Display.PrintContent;
import com.Group3.ZombieBytes.Util.UserInput.Input;
import com.Group3.ZombieBytes.Util.JsonParser.*;
//import com.Group3.ZombieBytes.Game.Data.lifeforms.Character;
//import com.Group3.ZombieBytes.Game.Data.lifeforms.Zombie;
import com.Group3.ZombieBytes.Game.Data.Lifeforms.Character;
import com.Group3.ZombieBytes.Util.UserInput.ReaderInput;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

import java.util.HashMap;

public class Game{
    // properties
    // set game map
    private static HashMap<String, Location> gameLocation;

    // constructors
    private Game(){

    }
        // business methods
    public static void start(Input input) throws InterruptedException {
        //if its a reader input it needs to print to console
        runParsers();  // gathers data from json files and installs our classes with its properties
        if((input instanceof ReaderInput)){
            GameText.printer= new PrintContent();
        } else { // else it needs to do jfx stuff
            Platform.runLater(() -> FXDriver.getStage().getScene().setRoot(Doodler.drawGameScene(Doodler.drawMap())));//draw the Map in the jfx thread
            GameText.printer = new DisplayContent();
            Thread.sleep(10);
        }
        // if false printer is DisplayContent(JFX) if true printer is PrintContent(console)
        Character.startGame(input);
        // game code
//        for (Map.Entry<String, Location> loc : gameLocation.entrySet()) {
//            String key = loc.getKey();
//            Location location = loc.getValue();
//            PrintContent.print("Location Name:" + key);
//            PrintContent.print("Location Items: " + location.getItems());
//            PrintContent.print("Location Zombies: " + location.getZombies());
//            PrintContent.print("");
//        }
    }

    // runs the parsers to fill the game properties
    private static void runParsers(){
        GameTextParser.run();
        LocationParser.run();
        ItemParser.run();
        ZombieParser.run();

//        for(Map.Entry<String, Location> loc : gameLocation.entrySet()) {
//            PrintContent.print("Location: " + loc.getKey());
//            PrintContent.print("Items: " + loc.getValue().getItems());
//            PrintContent.print("Total Items: " + loc.getValue().getItems().size());
//        }
    }

    public static void quit(){
        GameText.outro();
        System.exit(0);
    }

    // setters and getters
    public static HashMap<String, Location> getGameLocation() {
        return gameLocation;
    }

    public static void setGameLocation(HashMap<String, Location> gameLocation) {
        Game.gameLocation = gameLocation;
    }


    // toString
//    public String toString(){
//        return ;
//    }
}

