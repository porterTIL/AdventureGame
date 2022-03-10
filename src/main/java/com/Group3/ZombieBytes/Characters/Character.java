package com.Group3.ZombieBytes.Characters;

import com.Group3.ZombieBytes.Items.Items;
import com.Group3.ZombieBytes.Game.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Character {
    // properties
    private String username;
    public static int health;
    private int spaces;
    private Directions direction = Directions.NORTH;
    List<Items> inventory = new ArrayList<>();
    List<Location> characterLocation = new ArrayList<>();
    public Location currentLocation;


    //constructors
    public Character(){};

    public Character(String username, int health, List<Location>characterLocation){
        this.username = username;
        this.health = health;
        this.characterLocation = characterLocation;
    }

    //methods
    /*public void walk(Directions direction){
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
    }*/
    public void startGame(){
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Welcome to ZombieBytes! Enter a username: ");
        username = null;
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(username + ", type 'start' to play the game. Enter 'quit' at any time to end the game.");
        String startGame = null;
        try {
            startGame = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        switch (startGame.toLowerCase(Locale.ROOT)){
            case "start":
                walk();
                break;
            case "quit":
                startGame();
                break;
            default:
                System.out.println("enter 'start' to begin the game");
        }
    }

    public void walk(){
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Which direction does " + username + " Want to walk?");

        String walkDirection = null;
        try {
            walkDirection = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


       switch (walkDirection.toLowerCase(Locale.ROOT)){
           case "walk north":
               //if (Location.getName() == "")
               System.out.println(characterLocation.get(0));
               break;
           case "walk south":
               System.out.println(characterLocation.get(1));
               break;
           case "walk east":
               System.out.println(characterLocation.get(2));
               break;
           case "walk west":
               System.out.println(characterLocation.get(3));
               break;
           case "quit":
               startGame();
               break;
           default:
               System.out.println("enter valid movement");
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
