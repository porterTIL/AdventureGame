package com.Group3.ZombieBytes.lifeforms;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Game.GameText;
import com.Group3.ZombieBytes.Game.Location;
import com.Group3.ZombieBytes.Items.Item;
import com.Group3.ZombieBytes.Items.Noun;
import com.Group3.ZombieBytes.Items.Verb;
import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;
import com.Group3.ZombieBytes.lifeforms.Directions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//package com.Group3.ZombieBytes.lifeforms;
//
//import com.Group3.ZombieBytes.Game.Game;
//import com.Group3.ZombieBytes.Game.GameText;
//import com.Group3.ZombieBytes.Items.Item;
//import com.Group3.ZombieBytes.Game.Location;
//import com.Group3.ZombieBytes.Items.Noun;
//import com.Group3.ZombieBytes.Items.Verb;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
public class Character {

    // properties
    private static String username;
    public static int health = 100;
    private int spaces;
    private Directions direction = Directions.NORTH;
    private List<Item> inventory = new ArrayList<>();
    public static HashMap<String, Location> totalLocation = Game.getGameLocation();
//    private Map<Location> characterLocation = new HashMap<>();
    public static Location currentLocation = totalLocation.get("TownCenter");
    List<GameText> characterText = new ArrayList<>();

    public static ArrayList<Verb> verbInteractions = new ArrayList<>();
    public static ArrayList<Noun> nounInteractions = new ArrayList<>();

    public static void startGame() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        GameText.username();
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


        switch (startGame.toLowerCase()) {
            case "start":
                GameText.intro();
                System.out.println(username + " is currently located in the " + currentLocation.getName());
                chooseAction();
                break;
            case "quit":
                startGame();
                break;
            default:
                GameText.defaultStart();
                startGame();
        }
    }

    public static void chooseAction() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        GameText.chooseAction();

        String chooseAction = null;
        try {
            chooseAction = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (chooseAction.toLowerCase()) {
            case "walk":
                GameText.defaultWalk();
                chooseAction();
                break;
            case "walk north":
                walk("north");
                chooseAction();
                break;
            case "walk east":
                walk("east");
                chooseAction();
                break;
            case "walk south":
                walk("south");
                chooseAction();
                break;
            case "walk west":
                walk("west");
                chooseAction();
                break;
            case "inspect":
                for (int i = 0; i < currentLocation.getItems().size();i++) {
                    System.out.println(currentLocation.getItems().get(i));
                }
                for (int w = 0; w < currentLocation.getZombies().size(); w++) {
                    System.out.println(currentLocation.getZombies().get(w));
                }
                chooseAction();
                break;
            case "attack":
                if (currentLocation.getZombies().size() == 0) {
                    GameText.noZombies();
                    chooseAction();
                } else {
                    attack();
                }
                break;
            case "quit":
                GameText.outro();
                startGame();
                break;
            default:
                GameText.defaultChooseAction();
                chooseAction();
        }
    }

    public static void walk(String direction){
        if (currentLocation.getAvailableDirection().get(direction.toLowerCase()) == null){
            GameText.lockedIn();
        } else {
            currentLocation = totalLocation.get(currentLocation.getAvailableDirection().get(direction));
            System.out.println(currentLocation.toString());
        }
    }

    public static void attack() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        if (Character.health <= 0) {
            GameText.death();
        }
        for (int w = 0; w < currentLocation.getZombies().size(); w++) {
            if (currentLocation.getZombies().size() > 00) {
                if (Zombie.zombieHP <= 0) {
                   GameText.alreadyDefeated();
                    chooseAction();
                }
                if (Objects.equals(currentLocation.getZombies().get(w).getZombieName(), "Monkey Zombie")) {
                    GameText.monkeyNoBanana();
                    chooseAction();
                }
                if (Objects.equals(currentLocation.getZombies().get(w).getZombieName(), "Ultimate Zombie Boss")) {
                    GameText.ultimateNoKey();
                    chooseAction();
                } else {
                    System.out.println("You have confronted " + currentLocation.getZombies().get(w).getZombieName() + ". This zombie's HP is currently " + Zombie.zombieHP + ". What would you like to do? (use item, run, or hit)");
                    String battleAction = null;
                    try {
                        battleAction = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    switch (battleAction.toLowerCase()) {
                        case "hit":
                            System.out.println("Zombie HP: " + Zombie.zombieHP);
                            System.out.println("Your health: " + Character.health);
                            GameText.punch();
                            Zombie.zombieHP = Zombie.zombieHP - 10;
                            Zombie.bite();
                            System.out.println("Your health " + Character.health);
                            System.out.println("Zombie HP: " + Zombie.zombieHP);
                            if (Zombie.zombieHP <= 0) {
                                GameText.attackWin();
                                chooseAction();
                            }
                            attack();
                            break;
                        case "run":
                            int int_random = ThreadLocalRandom.current().nextInt(0, 100);
                            if (int_random > 50) {
                                GameText.runFail();
                                Character.health = Character.health - 10;
                                System.out.println("Your HP: " + Character.health);
                                attack();
                            } else {
                               GameText.runWin();
                                chooseAction();
                            }
                            break;
//                    case "use item":
//                        System.out.println("Item used");
//                        break;
                        default:
                            GameText.attackDefault();
                            attack();
                    }
                }
            }
        }
    }
}

//    public void walk(){
//        System.out.println(username + " is currently located in the " + currentLocation.getName());
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(input);
//        System.out.println("Which direction does " + username + " want to walk?");
//
//        String walkDirection = null;
//        try {
//            walkDirection = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (currentLocation == characterLocation.get(0)){
//            switch (walkDirection.toLowerCase(Locale.ROOT)){
//                case "north":
//                    currentLocation = characterLocation.get(1);
//                    System.out.println(username + " has moved to the" + currentLocation);
//                    chooseAction();
//                    break;
//                case "south":
//                    currentLocation = characterLocation.get(2);
//                    System.out.println(username + " has moved to the " + currentLocation);
//                    chooseAction();
//                    break;
//                case "east":
//                    currentLocation = characterLocation.get(3);
//                    System.out.println(username + " has moved to the " + currentLocation);
//                    chooseAction();
//                    break;
//                case "west":
//                    currentLocation = characterLocation.get(7);
//                    System.out.println(username + " has moved to the " + currentLocation);
//                    chooseAction();
//                    break;
//                default:
//                    System.out.println("enter valid movement");
//                    walk();
//            }
//        }else {
//            if (currentLocation == characterLocation.get(1)){
//                switch (walkDirection.toLowerCase(Locale.ROOT)){
//                    case "east":
//                        currentLocation = characterLocation.get(6);
//                        System.out.println(username + " has moved to the " + currentLocation);
//                        chooseAction();
//                        break;
//                    case "west":
//                        currentLocation = characterLocation.get(5);
//                        System.out.println(username + " has moved to the " + currentLocation);
//                        chooseAction();
//                        break;
//                    case "south":
//                        currentLocation = characterLocation.get(0);
//                        System.out.println(username + " has moved to the " + currentLocation);
//                        chooseAction();
//                    default:
//                        System.out.println("enter valid movement");
//                        walk();
//                }
//            } else{
//                if (currentLocation == characterLocation.get(2)){
//                    switch (walkDirection.toLowerCase(Locale.ROOT)){
//                        case "north":
//                            currentLocation = characterLocation.get(0);
//                            System.out.println(username + " has moved to the " + currentLocation);
//                            chooseAction();
//                            break;
//                        case "east":
//                            currentLocation = characterLocation.get(8);
//                            System.out.println(username + " has moved to the " + currentLocation);
//                            chooseAction();
//                            break;
//                        case "west":
//                            currentLocation = characterLocation.get(4);
//                            System.out.println(username + " has moved to the " + currentLocation);
//                            chooseAction();
//                            break;
//                        default:
//                            System.out.println("Please enter a valid movement");
//                            walk();
//                    }
//                }else {
//                    if (currentLocation == characterLocation.get(3)){
//                        switch (walkDirection.toLowerCase(Locale.ROOT)){
//                            case "north":
//                                currentLocation = characterLocation.get(6);
//                                System.out.println(username + " has moved to the " + currentLocation);
//                                chooseAction();
//                                break;
//                            case "west":
//                                currentLocation = characterLocation.get(0);
//                                System.out.println(username + " has moved to the " + currentLocation);
//                                chooseAction();
//                                break;
//                            case "south":
//                                currentLocation = characterLocation.get(8);
//                                System.out.println(username + " has moved to the " + currentLocation);
//                                chooseAction();
//                                break;
//                            default:
//                                System.out.println("Please enter a valid movement");
//                                walk();
//                        }
//                    }else {
//                        if (currentLocation == characterLocation.get(4)){
//                            switch (walkDirection.toLowerCase(Locale.ROOT)){
//                                case "north":
//                                    currentLocation = characterLocation.get(7);
//                                    System.out.println(username + " has moved to the " + currentLocation);
//                                    chooseAction();
//                                    break;
//                                case "east":
//                                    currentLocation = characterLocation.get(2);
//                                    System.out.println(username + " has moved to the " + currentLocation);
//                                    chooseAction();
//                                    break;
//                                default:
//                                    System.out.println("Please enter a valid movement");
//                                    walk();
//                            }
//                        }else {
//                            if (currentLocation == characterLocation.get(5)) {
//                                switch (walkDirection.toLowerCase(Locale.ROOT)){
//                                    case "east":
//                                        currentLocation = characterLocation.get(1);
//                                        chooseAction();
//                                        System.out.println(username + " has moved to the " + currentLocation);
//                                        break;
//                                    case "south":
//                                        currentLocation = characterLocation.get(7);
//                                        System.out.println(username + " has moved to the " + currentLocation);
//                                        chooseAction();
//                                        break;
//                                    default:
//                                        System.out.println("Please enter a valid movement");
//                                        walk();
//                                }
//                            }else {
//                                if (currentLocation == characterLocation.get(6)){
//                                    switch (walkDirection.toLowerCase(Locale.ROOT)){
//                                        case "west":
//                                            currentLocation = characterLocation.get(1);
//                                            System.out.println(username + " has moved to the " + currentLocation);
//                                            chooseAction();
//                                            break;
//                                        case "south":
//                                            currentLocation = characterLocation.get(3);
//                                            System.out.println(username + " has moved to the " + currentLocation);
//                                            chooseAction();
//                                            break;
//                                        default:
//                                            System.out.println("Please enter a valid movement");
//                                            walk();
//                                    }
//                                } else {
//                                    if (currentLocation == characterLocation.get(7)){
//                                        switch (walkDirection.toLowerCase(Locale.ROOT)){
//                                            case "north":
//                                                currentLocation = characterLocation.get(5);
//                                                System.out.println(username + " has moved to the " + currentLocation);
//                                                chooseAction();
//                                                break;
//                                            case "east":
//                                                currentLocation = characterLocation.get(0);
//                                                System.out.println(username + " has moved to the " + currentLocation);
//                                                chooseAction();
//                                                break;
//                                            case "south":
//                                                currentLocation = characterLocation.get(4);
//                                                System.out.println(username + " has moved to the " + currentLocation);
//                                                chooseAction();
//                                                break;
//                                            default:
//                                                System.out.println("Please enter a valid movement");
//                                                walk();
//                                        }
//                                    } else {
//                                        if (currentLocation == characterLocation.get(8)){
//                                            switch (walkDirection.toLowerCase(Locale.ROOT)){
//                                                case "north":
//                                                    currentLocation = characterLocation.get(3);
//                                                    System.out.println(username + " has moved to the " + currentLocation);
//                                                    chooseAction();
//                                                    break;
//                                                case "west":
//                                                    currentLocation = characterLocation.get(2);
//                                                    System.out.println(username + " has moved to the " + currentLocation);
//                                                    chooseAction();
//                                                    break;
//                                                default:
//                                                    System.out.println("Please enter a valid movement");
//                                                    walk();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//        }
//    public void runAway(Directions direction, int spaces){
//
//    }
//
//    public void attack(){
//        System.out.println(Zombie.zombieHP);
//        System.out.println("Zombie hit");
//        Zombie.zombieHP = Zombie.zombieHP - 10;
//        System.out.println("new Zombie HP " + Zombie.zombieHP);
//
//    }
//
//    public void grab(Item item){
//        inventory.add(item);
//    }
//
//    public void use(Item item){
//        inventory.remove(item);
//    }
//
//    public void inspect(Item items){
//
//    }
//
//    public void showInventory(){
//        System.out.println(getInventory());
//    }
//
//
//    //getter and setter
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getHealth() {
//        return health;
//    }
//
//    public void setHealth(int health) {
//        this.health = health;
//    }
//
//    public Directions getDirection() {
//        return direction;
//    }
//
//    public void setDirection(Directions direction) {
//        this.direction = direction;
//    }
//
//    public List<Item> getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(List<Item> inventory) {
//        this.inventory = inventory;
//    }
//
//    public Location getCurrentLocation() {
//        return currentLocation;
//    }
//
//    public void setCurrentLocation(Location currentLocation) {
//        this.currentLocation = currentLocation;
//    }
//
//    //toString
//
//    @Override
//    public String toString() {
//        return "Character{" +
//                "username='" + username + '\'' +
//                ", health=" + health +
//                ", direction=" + direction +
//                ", inventory=" + inventory +
//                '}';
//    }
//}
