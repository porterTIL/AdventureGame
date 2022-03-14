package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.JSONParser.*;
import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;
//import com.Group3.ZombieBytes.lifeforms.Character;
//import com.Group3.ZombieBytes.lifeforms.Zombie;
import com.Group3.ZombieBytes.Items.*;
import com.Group3.ZombieBytes.JSONParser.*;

import java.util.*;

public class Game {
    // properties
    private static String zombieGameText = "This is a zombie game";

    // set game map
    private static HashMap<String, Location> gameLocation;

    // constructors
    private Game(){

    }
    // methods
    // business methods
    public static void start(){
        runParsers();
        GameText.intro();
        PrintContent.print(gameLocation.size());
        // game code
        GameText.dead();
        GameText.outro();
//        PrintContent.print(gameText.get("intro"));
//        PrintContent.print(gameText.size());
//        PrintContent.print(gameLocation.size());
//        PrintContent.print(gameText.get("outro"));

    }
    // run the parsers to fill the game properties
    public static void runParsers(){
        com.Group3.ZombieBytes.JsonParser.GameTextParser.run();
        com.Group3.ZombieBytes.JsonParser.LocationParser.run();
//        ItemParser.run();

//        for(Map.Entry<String, Location> loc : gameLocation.entrySet()) {
//            PrintContent.print("Location: " + loc.getKey());
//            PrintContent.print("Items: " + loc.getValue().getItems());
//            PrintContent.print("Total Items: " + loc.getValue().getItems().size());
//        }
    }
    // setters and getters
    public static HashMap<String, Location> getGameLocation() {
        return gameLocation;
    }

    public static void setGameLocation(HashMap<String, Location> gameLocation) {
        Game.gameLocation = gameLocation;
    }
    // toString
    public String toString(){
        return zombieGameText;
    }
}

