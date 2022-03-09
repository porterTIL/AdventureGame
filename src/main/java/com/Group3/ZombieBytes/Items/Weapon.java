package com.Group3.ZombieBytes.Items;

import com.SemiFinalProject.Group3.ZombieBytes.Characters.Zombie;

import static com.SemiFinalProject.Group3.ZombieBytes.Characters.Zombie.*;

public class Weapon implements Items{
    // properties
    private static String name;

    public Weapon(String name) {
    }

    // methods
    @Override
    public void use() {
        // damage to zombie
        if (Weapon.name  == "stick") {
            int newZombieHP = Zombie.ZombieHP - 10;
        } else if (Weapon.name == "baton") {
            int newZombieHP = Zombie.ZombieHP - 30;
        }

    }
}
