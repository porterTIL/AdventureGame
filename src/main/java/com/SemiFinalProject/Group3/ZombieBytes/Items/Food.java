package com.SemiFinalProject.Group3.ZombieBytes.Items;
import com.SemiFinalProject.Group3.ZombieBytes.Characters.Character;

public class Food implements Items{
    // properties
    String name;

    public Food(String name) {
    }

    // methods
    @Override
    public void use() {
        // restore health
        Character.health = Character.health + 5;
    }
}
