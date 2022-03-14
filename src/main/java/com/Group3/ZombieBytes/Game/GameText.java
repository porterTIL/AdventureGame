package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;

import java.util.HashMap;

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
        PrintContent.print("HELLO THIS IS INTRO");
    }
    public static void outro(){
        PrintContent.print("THANKS FOR QUITTING");

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
