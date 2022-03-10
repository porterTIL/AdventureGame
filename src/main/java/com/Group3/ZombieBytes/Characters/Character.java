package com.Group3.ZombieBytes.Characters;

import com.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.List;

public class Character {
    // properties
    private String username;
    public static int health;
    private int spaces;
    private Directions direction = Directions.NORTH;
    List<Items> inventory = new ArrayList<>();

    //constructors
    public Character(){};

    public Character(String username, int health){
        this.username = username;
        this.health = health;
    }

    //methods
    public void walk(Directions direction){
        switch (direction) {
            case NORTH:
                System.out.println("moving north");
                break;
            case EAST:
                System.out.println("moving east");
                break;
            case SOUTH:
                System.out.println("moving south");
                break;
            case WEST:
                System.out.println("moving west");
                break;
            default:
                System.out.println("Please select a valid movement");
        }
    }

    public void runAway(Directions direction, int spaces){

    }

    public void attack(){
        System.out.println(Zombie.ZombieHP);
        System.out.println("Zombie hit");
        Zombie.ZombieHP = Zombie.ZombieHP - 10;
        System.out.println("new Zombie HP " + Zombie.ZombieHP);

    }

    public void grab(Items item){
        inventory.add(item);
    }

    public void use(Items item){
        inventory.remove(item);
    }

    public void inspect(Items items){

    }

    public void showInventory(){
        System.out.println(getInventory());
    }


    //getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public List<Items> getInventory() {
        return inventory;
    }

    public void setInventory(List<Items> inventory) {
        this.inventory = inventory;
    }

    //toString

    @Override
    public String toString() {
        return "Character{" +
                "username='" + username + '\'' +
                ", health=" + health +
                ", direction=" + direction +
                ", inventory=" + inventory +
                '}';
    }
}
