package com.Group3.ZombieBytes.Game.Data.Lifeforms;

import com.Group3.ZombieBytes.Driver.FXDriver;
import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.Display.*;
import com.Group3.ZombieBytes.Game.Data.Location;
import com.Group3.ZombieBytes.Game.Data.Items.*;
import com.Group3.ZombieBytes.Util.UserInput.Input;
import isThisUsed.*;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Character {

    // properties
    static Input reader;
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

    public static void startGame(Input in) {
        //InputStreamReader input = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(input);
        reader=in;
        GameText.username();
        username = null;
        username = reader.readLine();
        do {
            GameText.printer.print(username + ", type 'start' to play the game. Enter 'quit' at any time to end the game.");
        }
        while (startOrQuit(reader.readLine()));
        chooseAction();
    }

    //demands user to enter start or quit
    public static boolean startOrQuit(String input) {
        switch (input.toLowerCase()) {
            case "start":
                GameText.intro();
                GameText.printer.print(username + " is currently located in the " + currentLocation.getName());
                return false;
            case "quit":
                Game.quit();
        }
        return true;
    }

    public static void chooseAction() {
        if(FXDriver.hasGraphics) {
            Platform.runLater(()->Doodler.updateMap(Doodler.getMapSquares()));
        }
        GameText.chooseAction();

        String chooseAction;
        String[] wordInput;
        chooseAction = reader.readLine();
        wordInput = chooseAction.split(" ");
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
                        GameText.printer.print("You currently have no items");
                        chooseAction();
                        break;
                    }
                    for (int i = 0; i < inventory.size(); i++) {
                        GameText.printer.print(("YOUR INVENTORY: " + inventory.get(i).getName()));
                    }
                } else {

                    GameText.printer.print("Can't check " + wordInput[1]);
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
                    GameText.printer.print(currentLocation.getItems().get(i).toString());
                }
                for (int w = 0; w < currentLocation.getZombies().size(); w++) {
                    if (currentLocation.getZombies().get(w).getZombieHP() <= 0) {
                        GameText.printer.print("There is a victim of " + username + "'s awe-inspiring violence on the floor." + username + " has already killed the zombie in this location.");
                    } else {
                        GameText.printer.print(currentLocation.getZombies().get(w).toString());
                    }
                }
                GameText.printer.print(currentLocation.getInspect());
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
        if (Directions.isDirection(direction)) {
            if (currentLocation.getAvailableDirection().get(direction) == null) {
                GameText.lockedIn();
            } else {
                currentLocation = totalLocation.get(currentLocation.getAvailableDirection().get(direction));
                GameText.printer.print(currentLocation.toString());
            }
        } else {
            GameText.defaultWalk();
        }
    }

    public static void CheckLength(int length, String verb) {
        if (length < 2) {
            GameText.printer.print("Please enter a noun command to go along with your verb: " + verb);
            chooseAction();
        }
    }

    public static void attack() {

        if (Character.health <= 0) {
            GameText.death();
            Game.quit();
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
                }else {
                    GameText.printer.print("You have confronted " + currentLocation.getZombies().get(w).getZombieName() +
                            ". This zombie's HP is currently " + zombie.zombieHP + ". What would you like to do? (use item, run, hit, or inventory)");
                    String battleAction = reader.readLine();
                    String[] wordInput = battleAction.split(" ");
                    switch (wordInput[0].toLowerCase()) {
                        case "hit":
                            GameText.printer.print("Zombie HP: " + zombie.zombieHP);
                            GameText.printer.print("Your health: " + Character.health);
                            GameText.punch();
                            zombie.zombieHP = zombie.zombieHP - 10;
                            zombie.bite();
                            GameText.printer.print("Your health " + Character.health);
                            GameText.printer.print("Zombie HP: " + zombie.zombieHP);
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
                                GameText.printer.print("Your HP: " + Character.health);
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
                                    GameText.printer.print("You currently have no items");
                                    chooseAction();
                                    break;
                                }
                                for (int i = 0; i < inventory.size(); i++) {
                                    GameText.printer.print(("YOUR INVENTORY: " + inventory.get(i).getName()));
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
                GameText.printer.print(username + " has picked up item");
                currentLocation.getItems().remove(i);
                for (int j = 0; j < inventory.size(); j++) {
                    GameText.printer.print(("Your Inventory: " + inventory.get(j).getName()));
                }
            } else {
                GameText.printer.print("You can not pick up this item");
            }
        }
//        inventory.add(item);
//        currentLocation.getItems().remove(choosenItem);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public static void useItem(String pickedItem) {
        for (Item item : inventory) {   // search the inventory for the item to be used
            if (item.getName().equalsIgnoreCase(pickedItem)){   // if an item matches, check if it's the cure, food, or a simple "text-output" item
                if (pickedItem.equalsIgnoreCase("cure")){
                    GameText.printer.print("You have used " + item.getName());
                    GameText.printer.print(item.getUse());
                    System.exit(0);   // exit the game upon winning - change this after adding in more game winning logic
                }
                else if (item.getType().equalsIgnoreCase("food")){
                    GameText.printer.print("You have used " + item.getName());
                    GameText.printer.print(item.getUse());
                    health += item.healthPoints;
                }
                else {
                    GameText.printer.print("You have used " + item.getName());
                    GameText.printer.print(item.getUse());
                }
                inventory.remove(item); // whatever you used, remove it from the inventory
                return;
            }
        }
    }
//        if (inventory.contains(pickedItem)) {
//            GameText.printer.print(pickedItem.getName() + "has been used");
//            inventory.remove(choosenItem);
//        }
}

