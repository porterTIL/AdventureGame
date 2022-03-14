package com.Group3.ZombieBytes.Client;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;
//import com.Group3.ZombieBytes.lifeforms.Character;
//import com.Group3.ZombieBytes.lifeforms.Zombie;
import com.Group3.ZombieBytes.Game.GameText;
import com.Group3.ZombieBytes.Items.*;
import org.json.simple.*;
import com.Group3.ZombieBytes.Game.Location;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZombieGameClient {
    public static void main(String[] args) {
        // starts the game
        Game.start();
    }
}

//        Character c = new Character("Sam", 100,townLocations);
//
//        // this is the second commit
//        c.currentLocation = townLocations.get(0);
//        c.startGame();
//        System.out.println(c.currentLocation);
//}
