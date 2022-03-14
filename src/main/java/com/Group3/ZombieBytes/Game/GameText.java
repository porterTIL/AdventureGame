package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameText {
//    String name;
//    String text;
//
//    public GameText(){}
//
//    public GameText(String name, String text){
//        this.name = name;
//        this.text = text;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    @Override
//    public String toString() {
//        return text;
//    }
// properties
private static HashMap<String, String> gameText;

    //methods
    // business methods
    public static void intro(){
        PrintContent.print(gameText.get("Intro"));
    }
    public static void outro(){
        PrintContent.print(gameText.get("Outro"));

    }
    public static void dead(){
        PrintContent.print("You have died");

    }
    // getters and setters
    public static HashMap<String, String> getGameText() {
        return gameText;
    }

    public static void setGameText(HashMap<String, String> gameText) {
        GameText.gameText = gameText;
    }
}
