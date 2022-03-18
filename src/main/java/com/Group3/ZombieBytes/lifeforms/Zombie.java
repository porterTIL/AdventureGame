package com.Group3.ZombieBytes.lifeforms;

import com.Group3.ZombieBytes.Game.GameText;

public class Zombie {

    // Properties
    private String zombieName;
    private String zombieLocation;
    public long zombieHP;
    private String zombieDescription;
    private String Zombies = null;
    private static int newHealth;

    // constructors
    public Zombie(String zombieName, long zombieHealthPoint, String zombieLocation, String zombieDescription){
        setZombieName(zombieName);
        setZombieHP(zombieHealthPoint);
        setZombieLocation(zombieLocation);
        setZombieDescription(zombieDescription);
    }

//    public Zombie(String zombieName, String zombieDescription) {
//        this.zombieName = zombieName;
//        this.zombieDescription = zombieDescription;
//    }

    //methods
        // business methods
    public static void bite() {
        Character.health = Character.health - 10;
        GameText.bite();
    }

        // getters and setters
    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName(String zombieName) {
        this.zombieName = zombieName;
    }

    public String getZombieLocation() {
        return zombieLocation;
    }

    public void setZombieLocation(String zombieLocation) {
        this.zombieLocation = zombieLocation;
    }

    private long getZombieHP() {
        return this.zombieHP;
    }

    private void setZombieHP(long zombieHP) {
        this.zombieHP = zombieHP;
    }

    public String getZombieDescription() {
        return zombieDescription;
    }

    public void setZombieDescription(String zombieDescription) {
        this.zombieDescription = zombieDescription;
    }



    // to String
    public String toString(){
        return getZombieName().toUpperCase()+ ": " + zombieDescription;
    }
}

