package com.SemiFinalProject.Group3.ZombieBytes.Characters;

public class Zombie{
    public static int ZombieHP;
    Level difficulty;

    public Zombie(Level difficulty, int ZombieHP) {
        this.difficulty = difficulty;
        this.ZombieHP = ZombieHP;
    }


    public int bite() {
    if (difficulty == Level.EASY) {
        Character.health = Character.health - 10;
    } else if (difficulty == Level.MEDIUM) {
        Character.health = Character.health - 20;
    } else if (difficulty == Level.HARD) {
        Character.health = Character.health - 30;
    }
    return Character.health;
    }


}
