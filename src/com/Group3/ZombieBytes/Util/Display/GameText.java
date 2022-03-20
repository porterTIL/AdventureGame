package com.Group3.ZombieBytes.Util.Display;

import java.util.HashMap;

public class GameText {
// properties
    public static PrintContent printer;
    private static HashMap<String, String> gameText;

    //methods
    // business methods
    public static void intro(){
        printer.print(gameText.get("intro"));
    }
    public static void outro(){
        printer.print(gameText.get("outro"));
    }
    public static void punch(){
        printer.print(gameText.get("punch"));
    }
    public static void alreadyDefeated(){
        printer.print(gameText.get("alreadyDefeated"));
    }
    public static void defaultStart(){
        printer.print(gameText.get("defaultStart"));
    }
    public static void username(){
        printer.print(gameText.get("username"));
    }
    public static void death(){
        printer.print(gameText.get("death"));
    }
    public static void bite(){
        printer.print(gameText.get("bite"));
    }
    public static void chooseAction(){
        printer.print(gameText.get("chooseAction"));
    }
    public static void noZombies(){
        printer.print(gameText.get("noZombies"));
    }
    public static void defaultChooseAction(){
        printer.print(gameText.get("defaultChooseAction"));
    }
    public static void defaultWalk(){
        printer.print(gameText.get("defaultWalk"));
    }
    public static void monkeyNoBanana(){
        printer.print(gameText.get("monkeyNoBanana"));
    }
    public static void ultimateNoKey(){
        printer.print(gameText.get("ultimateNoKey"));
    }
    public static void attackWin(){
        printer.print(gameText.get("attackWin"));
    }
    public static void runFail(){
        printer.print(gameText.get("runFail"));
    }
    public static void runWin(){
        printer.print(gameText.get("runWin"));
    }
    public static void attackDefault(){
        printer.print(gameText.get("attackDefault"));
    }
    public static void lockedIn(){
        printer.print(gameText.get("lockedIn"));
    }

    // getters and setters
    /* TODO: remove?
    public static HashMap<String, String> getGameText() {
        return gameText;
    } */

    public static void setGameText(HashMap<String, String> gameText) {
        GameText.gameText = gameText;
    }
}
