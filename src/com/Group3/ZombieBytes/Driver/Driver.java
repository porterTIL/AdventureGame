package com.Group3.ZombieBytes.Driver;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.UserInput.ReaderInput;

public class Driver {
    public static void main(String[] args) {
        // starts the game
        Game.start(new ReaderInput());
    }
}

//        Character c = new Character("Sam", 100,townLocations);
//
//        // this is the second commit
//        c.currentLocation = townLocations.get(0);
//        c.startGame();
//        System.out.println(c.currentLocation);
//}
