package com.Group3.ZombieBytes.lifeforms;

import com.Group3.ZombieBytes.Game.Game;
//import com.Group3.ZombieBytes.Game.GameText;
import com.Group3.ZombieBytes.Items.Item;
import com.Group3.ZombieBytes.Game.Location;
import com.Group3.ZombieBytes.Items.Noun;
import com.Group3.ZombieBytes.Items.Verb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Character {
    // properties
    private String username;
    public static int health;
    private int spaces;
    private Directions direction = Directions.NORTH;
    private List<Item> inventory = new ArrayList<>();
    private List<Location> characterLocation = new ArrayList<>();
    public Location currentLocation;
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

//    List<GameText> characterText = new ArrayList<>();

    public static ArrayList<Verb> verbInteractions = new ArrayList<>();
    public static ArrayList<Noun> nounInteractions = new ArrayList<>();


    //constructors
    public Character() {
    }

    ;

    public Character(String username, int health, List<Location> characterLocation) {
        this.username = username;
        this.health = health;
        this.characterLocation = characterLocation;
//        this.characterText = characterText;
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
    public void startGame() {
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(input);
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


        switch (startGame.toLowerCase(Locale.ROOT)) {
            case "start":
                System.out.println(username + " is currently located in the " + currentLocation);
                chooseAction();
                break;
            case "quit":
                startGame();
                break;
            default:
                System.out.println("enter 'start' to begin the game");
                startGame();
        }

    }

    public void chooseAction() {
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(input);
        System.out.println("What would you like to do? (walk, inspect, attack)");
        String chooseAction = null;
        try {
            chooseAction = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (chooseAction.toLowerCase(Locale.ROOT)) {
            case "walk":
                walk();
                break;
            case "inspect":
                for (int i = 0; i < currentLocation.itemsInLocation.size(); i++) {
                    System.out.println(currentLocation.itemsInLocation.get(i));
                }
                for (int w = 0; w < currentLocation.zombiesInLocation.size(); w++) {
                    System.out.println(currentLocation.zombiesInLocation.get(w));
                }
                chooseAction();
                break;
            case "attack":
                if (currentLocation.zombiesInLocation.size() == 0) {
//                    if (currentLocation.zombiesInLocation.get(w) == null) {
                    System.out.println("There are no zombies to attack in this room.");
                    chooseAction();
                } else {
                    attack();
                }
                break;
                    case "quit":
                        System.out.println("Test");
                        startGame();
                        break;
                    default:
                        System.out.println("What would you like to do?");
                        chooseAction();
                }
        }


    public void walk() {
        System.out.println(username + " is currently located in the " + currentLocation.getName());
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(input);
        System.out.println("Which direction does " + username + " want to walk?");

        String walkDirection = null;
        try {
            walkDirection = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (currentLocation == characterLocation.get(0)) {
            switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
        } else {
            if (currentLocation == characterLocation.get(1)) {
                switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
            } else {
                if (currentLocation == characterLocation.get(2)) {
                    switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                } else {
                    if (currentLocation == characterLocation.get(3)) {
                        switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                    } else {
                        if (currentLocation == characterLocation.get(4)) {
                            switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                        } else {
                            if (currentLocation == characterLocation.get(5)) {
                                switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                            } else {
                                if (currentLocation == characterLocation.get(6)) {
                                    switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                                    if (currentLocation == characterLocation.get(7)) {
                                        switch (walkDirection.toLowerCase(Locale.ROOT)) {
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
                                        if (currentLocation == characterLocation.get(8)) {
                                            switch (walkDirection.toLowerCase(Locale.ROOT)) {
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

    public void runAway(Directions direction, int spaces) {

    }

    public void attack() {
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(input);

        for (int w = 0; w < currentLocation.zombiesInLocation.size(); w++) {
            if (Objects.equals(currentLocation.zombiesInLocation.get(w).getZombieName(), "Monkey Zombie")) {
                System.out.println("The monkey zombie shreiks at you and you stumble backwards...");
                chooseAction(); }
            else {
                System.out.println("You have confronted " + currentLocation.zombiesInLocation.get(w).getZombieName() + ". This zombie's HP is currently " + Zombie.zombieHP + ". What would you like to do? (use item, run, or hit)");
                String battleAction = null;
                try {
                    battleAction = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                switch (battleAction.toLowerCase(Locale.ROOT)) {
                    case "hit":
                        System.out.println("Zombie HP: " + Zombie.zombieHP);
                        System.out.println("Your health: " + Character.health);
                        System.out.println("You punch the zombie in the face.");
                        Zombie.zombieHP = Zombie.zombieHP - 10;
                        Zombie.bite();
                        System.out.println("Your health " + Character.health);
                        System.out.println("Zombie HP: " + Zombie.zombieHP);
                        attack();
                        break;
                    case "run":
                        int int_random = ThreadLocalRandom.current().nextInt(0, 100);
                        if (int_random > 50) {
                            System.out.println("Your attempt at running away was unsuccessful. The zombie attacks you back!");
                            Character.health = Character.health - 10;
                            System.out.println("Your HP: " + Character.health);
                            attack();
                        } else {
                            System.out.println("You were able to get away!");
                            chooseAction();
                        }
                        break;
//                    case "use item":
//                        System.out.println("Item used");
//                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                        attack();
                }
            }
        }
    }
//        for (int w = 0; w < currentLocation.zombiesInLocation.size(); w++) {
//            if (currentLocation.zombiesInLocation.get(w).getZombieName() == "Monkey Boss Zombie")
//                System.out.println("The monkey zombie shreiks at you and you stumble backwards...");
//            else {
//                System.out.println("This zombie's HP is currently " + Zombie.zombieHP + ". What would you like to do? (use item, run away, or hit)");
//                if (battleAction.toLowerCase(Locale.ROOT) == "hit") {
//                    System.out.println("Zombie HP: " + Zombie.zombieHP);
//                    System.out.println("Your health: " + Character.health);
//                    System.out.println("You punch the zombie in the face.");
//                    Zombie.zombieHP = Zombie.zombieHP - 10;
//                    System.out.println("Zombie HP: " + Zombie.zombieHP);
//                }
//                if (battleAction.toLowerCase(Locale.ROOT) == "run away") {
//                    int int_random = ThreadLocalRandom.current().nextInt(0, 100);
//                    if (int_random > 50) {
//                        System.out.println("Your attempt at running away was unsuccessful. The zombie attacks you back!");
//                        int newHealth = Character.health - 10;
//                        System.out.println("Your HP: " + newHealth);
//                    } else {
//                        System.out.println("You were able to get away!");
//                        chooseAction();
//                    } }
//                }
////                if (battleAction.toLowerCase(Locale.ROOT) == "use item") {
////
//                }


    public void grab(Item item) {
        inventory.add(item);
    }

    public void use(Item item) {
        inventory.remove(item);
    }

    public void inspect(Item items) {

    }

    public void showInventory() {
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
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
