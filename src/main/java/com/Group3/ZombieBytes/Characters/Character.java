package com.Group3.ZombieBytes.Characters;

import com.Group3.ZombieBytes.Items.Items;
import com.Group3.ZombieBytes.Game.Location;
import jdk.swing.interop.SwingInterOpUtils;

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
                System.out.println(username + " is currently located in the " + currentLocation);
                chooseAction();
                break;
            case "quit":
                startGame();
                break;
            default:
                System.out.println("enter 'start' to begin the game");
        }

    }

    public void chooseAction() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("What would you like to do? (walk, inspect)");

        String chooseAction = null;
        try {
            chooseAction = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (chooseAction.toLowerCase(Locale.ROOT)){
            case "walk":
                walk();
                break;
            case "inspect":
                for (int i = 0; i < currentLocation.itemsInLocation.size(); i++){
                    System.out.println(currentLocation.itemsInLocation.get(i));
                }
                    chooseAction();
                break;
            case "quit":
                startGame();
                break;
            default:
                System.out.println("What would you like to do?");
                chooseAction();
        }
    }
    public void walk(){
        System.out.println(username + " is currently located in the " + currentLocation);
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Which direction does " + username + " want to walk?");

        String walkDirection = null;
        try {
            walkDirection = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (currentLocation == characterLocation.get(0)){
            switch (walkDirection.toLowerCase(Locale.ROOT)){
                case "north":
                    currentLocation = characterLocation.get(1);
                    System.out.println(username + " has moved to the" + currentLocation);
                    chooseAction();
                    break;
                case "south":
                    currentLocation = characterLocation.get(2);
                    System.out.println(username + " has moved to the " + currentLocation);
                    chooseAction();
                    break;
                case "east":
                    currentLocation = characterLocation.get(3);
                    System.out.println(username + " has moved to the " + currentLocation);
                    chooseAction();
                    break;
                case "west":
                    currentLocation = characterLocation.get(7);
                    System.out.println(username + " has moved to the " + currentLocation);
                    chooseAction();
                    break;
                default:
                    System.out.println("enter valid movement");
                    walk();
            }
        }else {
            if (currentLocation == characterLocation.get(1)){
                switch (walkDirection.toLowerCase(Locale.ROOT)){
                    case "east":
                        currentLocation = characterLocation.get(6);
                        System.out.println(username + " has moved to the " + currentLocation);
                        chooseAction();
                        break;
                    case "west":
                        currentLocation = characterLocation.get(5);
                        System.out.println(username + " has moved to the " + currentLocation);
                        chooseAction();
                        break;
                    case "south":
                        currentLocation = characterLocation.get(0);
                        System.out.println(username + " has moved to the " + currentLocation);
                        chooseAction();
                    default:
                        System.out.println("enter valid movement");
                        walk();
                }
            } else{
                if (currentLocation == characterLocation.get(2)){
                    switch (walkDirection.toLowerCase(Locale.ROOT)){
                        case "north":
                            currentLocation = characterLocation.get(0);
                            System.out.println(username + " has moved to the " + currentLocation);
                            chooseAction();
                            break;
                        case "east":
                            currentLocation = characterLocation.get(8);
                            System.out.println(username + " has moved to the " + currentLocation);
                            chooseAction();
                            break;
                        case "west":
                            currentLocation = characterLocation.get(4);
                            System.out.println(username + " has moved to the " + currentLocation);
                            chooseAction();
                            break;
                        default:
                            System.out.println("Please enter a valid movement");
                            walk();
                    }
                }else {
                    if (currentLocation == characterLocation.get(3)){
                        switch (walkDirection.toLowerCase(Locale.ROOT)){
                            case "north":
                                currentLocation = characterLocation.get(6);
                                System.out.println(username + " has moved to the " + currentLocation);
                                chooseAction();
                                break;
                            case "west":
                                currentLocation = characterLocation.get(0);
                                System.out.println(username + " has moved to the " + currentLocation);
                                chooseAction();
                                break;
                            case "south":
                                currentLocation = characterLocation.get(8);
                                System.out.println(username + " has moved to the " + currentLocation);
                                chooseAction();
                                break;
                            default:
                                System.out.println("Please enter a valid movement");
                                walk();
                        }
                    }else {
                        if (currentLocation == characterLocation.get(4)){
                            switch (walkDirection.toLowerCase(Locale.ROOT)){
                                case "north":
                                    currentLocation = characterLocation.get(7);
                                    System.out.println(username + " has moved to the " + currentLocation);
                                    chooseAction();
                                    break;
                                case "east":
                                    currentLocation = characterLocation.get(2);
                                    System.out.println(username + " has moved to the " + currentLocation);
                                    chooseAction();
                                    break;
                                default:
                                    System.out.println("Please enter a valid movement");
                                    walk();
                            }
                        }else {
                            if (currentLocation == characterLocation.get(5)) {
                                switch (walkDirection.toLowerCase(Locale.ROOT)){
                                    case "east":
                                        currentLocation = characterLocation.get(1);
                                        chooseAction();
                                        System.out.println(username + " has moved to the " + currentLocation);
                                        break;
                                    case "south":
                                        currentLocation = characterLocation.get(7);
                                        System.out.println(username + " has moved to the " + currentLocation);
                                        chooseAction();
                                        break;
                                    default:
                                        System.out.println("Please enter a valid movement");
                                        walk();
                                }
                            }else {
                                if (currentLocation == characterLocation.get(6)){
                                    switch (walkDirection.toLowerCase(Locale.ROOT)){
                                        case "west":
                                            currentLocation = characterLocation.get(1);
                                            System.out.println(username + " has moved to the " + currentLocation);
                                            chooseAction();
                                            break;
                                        case "south":
                                            currentLocation = characterLocation.get(3);
                                            System.out.println(username + " has moved to the " + currentLocation);
                                            chooseAction();
                                            break;
                                        default:
                                            System.out.println("Please enter a valid movement");
                                            walk();
                                    }
                                } else {
                                    if (currentLocation == characterLocation.get(7)){
                                        switch (walkDirection.toLowerCase(Locale.ROOT)){
                                            case "north":
                                                currentLocation = characterLocation.get(5);
                                                System.out.println(username + " has moved to the " + currentLocation);
                                                chooseAction();
                                                break;
                                            case "east":
                                                currentLocation = characterLocation.get(0);
                                                System.out.println(username + " has moved to the " + currentLocation);
                                                chooseAction();
                                                break;
                                            case "south":
                                                currentLocation = characterLocation.get(4);
                                                System.out.println(username + " has moved to the " + currentLocation);
                                                chooseAction();
                                                break;
                                            default:
                                                System.out.println("Please enter a valid movement");
                                                walk();
                                        }
                                    } else {
                                        if (currentLocation == characterLocation.get(8)){
                                            switch (walkDirection.toLowerCase(Locale.ROOT)){
                                                case "north":
                                                    currentLocation = characterLocation.get(3);
                                                    System.out.println(username + " has moved to the " + currentLocation);
                                                    chooseAction();
                                                    break;
                                                case "west":
                                                    currentLocation = characterLocation.get(2);
                                                    System.out.println(username + " has moved to the " + currentLocation);
                                                    chooseAction();
                                                    break;
                                                default:
                                                    System.out.println("Please enter a valid movement");
                                                    walk();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
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
