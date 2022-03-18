package com.Group3.ZombieBytes.Util.Display;
import com.Group3.ZombieBytes.Util.Display.*;

import java.util.HashMap;

public class GameText {
// properties
private static HashMap<String, String> gameText;

    //methods
    // business methods
    public static void intro(){
        PrintContent.print(gameText.get("intro"));
    }
    public static void outro(){
        PrintContent.print(gameText.get("outro"));

    }
    public static void punch(){
        PrintContent.print(gameText.get("punch"));
    }
    public static void alreadyDefeated(){
        PrintContent.print(gameText.get("alreadyDefeated"));
    }
    public static void defaultStart(){
        PrintContent.print(gameText.get("defaultStart"));
    }
    public static void username(){
        PrintContent.print(gameText.get("username"));
    }
    public static void death(){
        PrintContent.print(gameText.get("death"));
    }
    public static void bite(){
        PrintContent.print(gameText.get("bite"));
    }
    public static void chooseAction(){
        PrintContent.print(gameText.get("chooseAction"));
    }
    public static void noZombies(){
        PrintContent.print(gameText.get("noZombies"));
    }
    public static void defaultChooseAction(){
        PrintContent.print(gameText.get("defaultChooseAction"));
    }
    public static void defaultWalk(){
        PrintContent.print(gameText.get("defaultWalk"));
    }
    public static void monkeyNoBanana(){
        PrintContent.print(gameText.get("monkeyNoBanana"));
    }
    public static void ultimateNoKey(){
        PrintContent.print(gameText.get("ultimateNoKey"));
    }
    public static void attackWin(){
        PrintContent.print(gameText.get("attackWin"));
    }
    public static void runFail(){
        PrintContent.print(gameText.get("runFail"));
    }
    public static void runWin(){
        PrintContent.print(gameText.get("runWin"));
    }
    public static void attackDefault(){
        PrintContent.print(gameText.get("attackDefault"));
    }
    public static void lockedIn(){
        PrintContent.print(gameText.get("lockedIn"));
    }

    // getters and setters
    public static HashMap<String, String> getGameText() {
        return gameText;
    }

    public static void setGameText(HashMap<String, String> gameText) {
        GameText.gameText = gameText;
    }
}
