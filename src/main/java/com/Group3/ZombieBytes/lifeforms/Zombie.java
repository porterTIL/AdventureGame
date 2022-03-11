package com.Group3.ZombieBytes.lifeforms;

public class Zombie {
    private int ZombieHP;

    // Properties
    private String zombieName = null;
    private String Zombies = null;
//    String zombieHP = null;
    private String zombieDescription = null;
    public long zombieHP;

    // constructors
    public Zombie(String Zombies, String zombieDescription, long zombieHP){
        this.zombieName = Zombies;
        this.zombieDescription = zombieDescription;
        this.zombieHP = zombieHP;

//        getZombieName(zombieName);
//        setZombies(Zombies);
//        setZombieHP(zombieHP);

    }


    //methods
    public String getZombieDescription() {
        return zombieDescription;
    }
    public void setZombieDescription(String zombieDescription) {
        this.zombieDescription = zombieDescription;
    }
    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName(String zombieName) {
        this.zombieName = zombieName;
    }

//    public String getZombies() {
//        return Zombies;
//    }
//
//    public void setZombies(String Zombies) {
//        this.Zombies = Zombies;
//    }
//    public String getZombieHP() {
//        return zombieHP;
//    }
//
//    public void setZombieHP(String zombieHP) {
//        this.zombieHP = zombieHP;
//    }

//    public int bite() {
//    if (difficulty == Level.EASY) {
//        Character.health = Character.health - 10;
//    } else if (difficulty == Level.MEDIUM) {
//        Character.health = Character.health - 20;
//    } else if (difficulty == Level.HARD) {
//        Character.health = Character.health - 30;
//    }
//    return Character.health;
//    }


    // to String
    public String toString(){
        return getZombieName().toUpperCase()+ ": " + zombieDescription;
    }
}

