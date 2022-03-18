package com.Group3.ZombieBytes.Game.Data.Lifeforms;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.Display.*;
import com.Group3.ZombieBytes.Game.Data.Location;
import com.Group3.ZombieBytes.Game.Data.Items.*;
import com.Group3.ZombieBytes.Game.Data.Lifeforms.*;
import isThisUsed.*;
import com.Group3.ZombieBytes.Util.Display.*;
import com.Group3.ZombieBytes.Game.Data.Lifeforms.Directions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Character {

    // properties
    private static String username;
    public static int health = 100;
    private static Item chosenItem;
    private int spaces;
    private Directions direction = Directions.NORTH;
    private static List<Item> inventory = new ArrayList<>();
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
        try {
            do {
                System.out.println(username + ", type 'start' to play the game. Enter 'quit' at any time to end the game.");
            }
            while (startOrQuit(reader.readLine()));
        } catch (IOException e) {
            System.out.println("YOU DID A BAD");
            System.out.println("BACK TO THE BEGINNING >:(");
            startGame();
        }
    }

    //demands user to enter start or quit
    public static boolean startOrQuit(String input) {
        switch (input.toLowerCase()) {
            case "start":
                GameText.intro();
                System.out.println(username + " is currently located in the " + currentLocation.getName());
                chooseAction();
                return false;
            case "quit":
                Game.quit();
        }
        return true;
    }

    public static void chooseAction() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        GameText.chooseAction();

        String chooseAction = null;
        String[] wordInput = new String[2];
        try {
            chooseAction = reader.readLine();
            wordInput = chooseAction.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (wordInput[0].toLowerCase()) {
            case "use":
                CheckLength(wordInput.length, wordInput[0]);    // CheckLength param1: checks that user input is the right number of words. param2: takes the user input verb to use in print feedback
                useItem(wordInput[1]);  // pass the item string to "useItem".
                chooseAction(); // call recursively to restart user input loop
                break;

            case "inventory":
//                CheckLength(wordInput.length, wordInput[0]);
                if (wordInput[0].equalsIgnoreCase("inventory")) {
                    if (inventory.size() == 0) {
                        PrintContent.print("You currently have no items");
                        chooseAction();
                        break;
                    }
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println(("YOUR INVENTORY: " + inventory.get(i).getName()));
                    }
                } else {

                    PrintContent.print("Can't check " + wordInput[1]);
                }
                chooseAction();
                break;
            case "grab":
                CheckLength(wordInput.length, wordInput[0]);
                Character.addToInventory(wordInput[1], currentLocation);
                chooseAction();
                break;
            case "walk":
                CheckLength(wordInput.length, wordInput[0]);
                walk(wordInput[1].toLowerCase());
//                GameText.defaultWalk();
                chooseAction();
                break;

            case "inspect":
                for (int i = 0; i < currentLocation.getItems().size(); i++) {
                    System.out.println(currentLocation.getItems().get(i));
                }
                for (int w = 0; w < currentLocation.getZombies().size(); w++) {
                    if (Zombie.getZombieHP() <= 0) {
                        System.out.println("There is a victim of " + username + "'s awe-inspiring violence on the floor." + username + " has already killed the zombie in this location." );
                    } else {
                        System.out.println(currentLocation.getZombies().get(w));
                    }
                }
                System.out.println(currentLocation.getInspect());
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
                Game.quit();
                break;
            default:
                GameText.defaultChooseAction();
                chooseAction();
        }
    }

    public static void walk(String direction) {
        if (currentLocation.getAvailableDirection().get(direction) == null) {
            GameText.lockedIn();
        } else {
            currentLocation = totalLocation.get(currentLocation.getAvailableDirection().get(direction));
            System.out.println(currentLocation.toString());
        }
    }

    public static void CheckLength(int length, String verb) {
        if (length < 2) {
            System.out.println("Please enter a noun command to go along with your verb: " + verb);
            chooseAction();
        }
    }

    public static void attack() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        if (Character.health <= 0) {
            GameText.death();
            System.exit(0);
        }
        for (int w = 0; w < currentLocation.getZombies().size(); w++) { // currentLocation.getZombies returns array list of zombies
            Zombie zombie = currentLocation.getZombies().get(w);
            if (currentLocation.getZombies().size() > 0) {
                if (zombie.zombieHP <= 0) {
                    GameText.alreadyDefeated();
                    chooseAction();
                }
                if (Objects.equals(zombie.getZombieName(), "Monkey Zombie")) {
                    GameText.monkeyNoBanana();
                    chooseAction();
                }
                if (Objects.equals(zombie.getZombieName(), "Ultimate Zombie Boss")) {
                    GameText.ultimateNoKey();
                    chooseAction();
                } else {
                    System.out.println("You have confronted " + zombie.getZombieName() +
                            ". This zombie's HP is currently " + zombie.zombieHP + ". What would you like to do? (use item, run, or hit)");

                    String battleAction = null;
                    String[] wordInput = new String[2];
                    try {
                        battleAction = reader.readLine();
                        wordInput = battleAction.split(" ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    switch (wordInput[0].toLowerCase()) {
                        case "hit":
                            System.out.println("Zombie HP: " + zombie.zombieHP);
                            System.out.println("Your health: " + Character.health);
                            GameText.punch();
                            zombie.zombieHP = zombie.zombieHP - 10;
                            Zombie.bite();
                            System.out.println("Your health " + Character.health);
                            System.out.println("Zombie HP: " + zombie.zombieHP);
                            if (zombie.zombieHP <= 0) {
                                GameText.attackWin();
                                chooseAction();
                               // GameText.alreadyDefeated();

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
                        case "use":
                            CheckLength(wordInput.length, wordInput[0]);
                            Character.useItem(wordInput[1]);
                            attack();
                            break;
                        case "inventory":
                            if (wordInput[0].equalsIgnoreCase("inventory")) {
                                if (inventory.size() == 0) {
                                    PrintContent.print("You currently have no items");
                                    chooseAction();
                                    break;
                                }
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println(("YOUR INVENTORY: " + inventory.get(i).getName()));
                                }
                            }
                            attack();
                        default:
                            GameText.attackDefault();
                            attack();
                    }
                }
            }
        }
    }

    public static void addToInventory(String item, Location currentLocation2) {
        for (int i = 0; i < currentLocation2.getItems().size(); i++) {
            if (currentLocation2.getItems().get(i).getName().equalsIgnoreCase(item)) {
                inventory.add(currentLocation2.getItems().get(i));
                PrintContent.print(username + " has picked up item");
                currentLocation.getItems().remove(i);
                for (int j = 0; j < inventory.size(); j++) {
                    System.out.println(("Your Inventory: " + inventory.get(j).getName()));
                }
            } else {
                PrintContent.print("You can not pick up this item");
            }
        }
//        inventory.add(item);
//        currentLocation.getItems().remove(choosenItem);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public static void useItem(String pickedItem) {
        for (Item item : inventory){
            if (item.getName().equalsIgnoreCase(pickedItem)) {
                    PrintContent.print("You have used " + item.getName());
                    PrintContent.print(item.getUse());
                    Game.start();
                }
                else{
                    PrintContent.print("You have used " + item.getName());
                    PrintContent.print(item.getUse());
                    inventory.remove(item);
                }
            }
        }
//        if (inventory.contains(pickedItem)) {
//            PrintContent.print(pickedItem.getName() + "has been used");
//            inventory.remove(choosenItem);
//        }
    }
