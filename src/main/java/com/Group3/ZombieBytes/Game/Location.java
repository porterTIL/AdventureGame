package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.Characters.Zombie;
import com.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.List;

public class Location {
    // Properties
    String name = null;
    String items = null;
    String zombieName = null;
    String Zombies = null;
    int zombieHP = 0;
    public List<Items> itemsInLocation = new ArrayList<Items>();
    public List<Zombie> zombiesInLocation = new ArrayList<Zombie>();
//    List <String> items = new ArrayList<>();

    // constructors
    public Location(String name, String items) {
        setName(name);
        setItems(items);
        setZombies(Zombies);
    }

    // methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName() {
        this.zombieName = zombieName;
    }

    public void setZombies(String Zombies) {
        this.Zombies = Zombies;
    }

    public int getZombieHP() {
        return zombieHP;
    }

    public void setZombieHP(int zombieHP) {
        this.zombieHP = zombieHP;
    }

    private String falseToString() {
        int sizeofLocation = itemsInLocation.size();
        String item = "";
        for (int y = 0; y < sizeofLocation; y++) {
            item += itemsInLocation.get(y).getName();
            item += " ";
        }
        return item;
    }

    private String falseToString2() {
        int sizeofLocation = zombiesInLocation.size();
        String zombie = "";
        for (int y = 0; y < sizeofLocation; y++) {
            zombie += zombiesInLocation.get(y).getZombieName();
            zombie += " ";
        }
        return zombie;
    }

    // to String
    public String toString() {
        if (falseToString2() == "") {
            return getName() + ", " + "and it has the following items: " + falseToString();
        } else {
            return getName() + ", " + "and it has the following items: " + falseToString() + ". You see a " + falseToString2() + "stumbling around.";
        }

    }
}
