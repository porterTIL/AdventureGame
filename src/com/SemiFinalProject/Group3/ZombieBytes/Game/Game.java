package com.SemiFinalProject.Group3.ZombieBytes.Game;

import com.SemiFinalProject.Group3.ZombieBytes.Characters.Character;
import com.SemiFinalProject.Group3.ZombieBytes.Characters.Zombie;
import com.SemiFinalProject.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    // properties
    public Map<Integer, Integer> board = new HashMap<>();
    public Character character;
    public Zombie zombie;
    public List<Items> items = new ArrayList<>();
    public boolean gameInProgress = false;

    // methods
    public void setRules(){
        // set the rules of the game, use a scanner for map size
    }
    public void gameStart(){
        this.gameInProgress = true;
        //
    }
    public void gameOver(){
        this.gameInProgress = false;
    }

}
