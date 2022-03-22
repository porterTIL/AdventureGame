package com.Group3.ZombieBytes.Game.Data.Lifeforms;

import com.Group3.ZombieBytes.Util.Display.GameText;

import java.util.random.RandomGenerator;

public class ZombieBoss extends Zombie{
    public ZombieBoss(String zombieName, long zombieHealthPoint, String zombieLocation, String zombieDescription) {
        super(zombieName, zombieHealthPoint, zombieLocation, zombieDescription);
    }
    @Override
    public void bite(){
        if(Math.random()>.5){
            dropkick();
        } else {
            punch();
        }
    }
    private void punch(){
        Character.health -= 15;
        GameText.printer.print(getZombieName()+" has walloped you.");
    }
    private void dropkick(){
        Character.health -= 30;
        GameText.printer.print(getZombieName()+" has dropkicked you!");
    }
}
