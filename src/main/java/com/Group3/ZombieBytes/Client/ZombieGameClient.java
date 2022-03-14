package com.Group3.ZombieBytes.Client;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.PrintToOutPut.PrintContent;
//import com.Group3.ZombieBytes.lifeforms.Character;
//import com.Group3.ZombieBytes.lifeforms.Zombie;
import com.Group3.ZombieBytes.Game.GameText;
import com.Group3.ZombieBytes.Items.*;
import org.json.simple.*;
import com.Group3.ZombieBytes.Game.Location;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZombieGameClient {
    public static void main(String[] args) {
        // starts the game

        Game.start();
    }
}
//        // created an arraylist to store my location objects
//        ArrayList<GameText> alltext = new ArrayList<>();
//        ArrayList<Location> townLocations = new ArrayList<>();
//
//        // this class helps us parse the json file
//        JSONParser jsonparser = new JSONParser();
//
//        // this class helps us read the json file for location
//        FileReader reader = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Location.json");
//        Object locationObject = jsonparser.parse(reader);
//        JSONObject locations = (JSONObject)locationObject;
//
//        // Location is a json array of objects
//        JSONArray locationArray = (JSONArray)locations.get("Location");
//
//        for(int i = 0; i < locationArray.size(); i++){
//           JSONObject location = (JSONObject) locationArray.get(i);
//           String name = (String) location.get("name");
//           String item =  (String) location.get("Item");
//           townLocations.add(new Location(name, item));
//        }
//
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // this class helps us read the json file for items in a location
//        FileReader readerItems = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Items.json");
//        Object itemsObject = jsonparser.parse(readerItems);
//        JSONObject items = (JSONObject)itemsObject;
//
//        // Location is a json array of objects
//        JSONArray itemsArray = (JSONArray)items.get("Items");
//
//        for(int i = 0; i < itemsArray.size(); i++){
//        JSONObject ithItem = (JSONObject) itemsArray.get(i);
//        String itemName =  (String) ithItem.get("name");
//        String itemLocation = (String) ithItem.get("location");
//        String itemDescription = (String) ithItem.get("Description");
//            for(var loc: townLocations){
//                if(loc.getName().equalsIgnoreCase(itemLocation)){
//                    loc.itemsInLocation.add(new Item(itemName, itemDescription));
//
//                }
//            }
//        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // this class helps us read the json file for zombies in a location
//        FileReader readerZombie = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Zombie.json");
//        Object zombieObject = jsonparser.parse(readerZombie);
//        JSONObject zombie = (JSONObject)zombieObject;
//
//        // Location is a json array of objects
//        JSONArray zombieArray = (JSONArray)zombie.get("Zombies");
//
//        for(int i = 0; i < zombieArray.size(); i++){
//            JSONObject ithZombie = (JSONObject) zombieArray.get(i);
//            String zombieName =  (String) ithZombie.get("name");
//            String zombieLocation = (String) ithZombie.get("location");
//            String zombieDescription = (String) ithZombie.get("description");
////            String zombieHP = (String) ithZombie.get("healthPoint");
////            int zombieHealth = Integer.parseInt(zombieHP);
//            for(var loc: townLocations){
//                if(loc.getName().equalsIgnoreCase(zombieLocation)){
//                    loc.zombiesInLocation.add(new Zombie(zombieName, zombieDescription));
//
//                }
//            }
//        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // created an arraylist to store my noun and verb objects
//
//        // this class helps us read the json file for location
//        FileReader readerInteractions = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/gameInteraction.json");
//        Object interactionObject = jsonparser.parse(readerInteractions);
//        JSONObject interactions = (JSONObject)interactionObject;
//
//        // Location is a json array of objects
//        JSONArray interactionArray = (JSONArray)interactions.get("Interaction");
//        JSONObject interaction = (JSONObject) interactionArray.get(0);
//        ArrayList<String> verbList = (ArrayList<String>) interaction.get("verb");
//        ArrayList<String> nounList = (ArrayList<String>) interaction.get("noun");
//        for(String noun: nounList){
//            Character.nounInteractions.add(new Noun(noun));
//        }
//        for(String verb: verbList){
//            Character.verbInteractions.add(new Verb(verb));
//        }
//        System.out.println(Character.verbInteractions.get(0).value);
//        System.out.println(Character.nounInteractions.get(3).value);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ///help read GameText JSON
////        FileReader test = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/GameText.json");
////        Object gameTextObject = jsonparser.parse(test);
////        JSONObject gameText = (JSONObject)gameTextObject;
////
////        //////////////
////        JSONArray gameTextArray = (JSONArray)gameText.get("GameText");
//
////        for (int i = 0; i < gameTextArray.size(); i++){
////            JSONObject gameThang = (JSONObject) gameTextArray.get(i);
////            String text = (String) gameThang.get("text");
////            String name = (String) gameThang.get("name");
////            System.out.println(name + text);
////            alltext.add(new GameText(name, text));
////
////        }
//
//        Character c = new Character("Sam", 100,townLocations);
//
//        // this is the second commit
//        c.currentLocation = townLocations.get(0);
//        c.startGame();
//        System.out.println(c.currentLocation);
//}
