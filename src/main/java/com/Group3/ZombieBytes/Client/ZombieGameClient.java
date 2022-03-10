package com.Group3.ZombieBytes.Client;

import com.Group3.ZombieBytes.Characters.Character;
import com.Group3.ZombieBytes.Items.Items;
import org.json.simple.*;
import com.Group3.ZombieBytes.Game.Location;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZombieGameClient {
    public static void main (String[] args) throws IOException, ParseException {
        // created an arraylist to store my location objects
        ArrayList<Location> townLocations = new ArrayList<>();

        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();

        // this class helps us read the json file for location
        FileReader reader = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Location.json");
        Object locationObject = jsonparser.parse(reader);
        JSONObject locations = (JSONObject)locationObject;

        // Location is a json array of objects
        JSONArray locationArray = (JSONArray)locations.get("Location");

        for(int i = 0; i < locationArray.size(); i++){
           JSONObject location = (JSONObject) locationArray.get(i);
           String name = (String) location.get("name");
           String item =  (String) location.get("Item");
           townLocations.add(new Location(name, item));
        }

        Character c = new Character("Sam", 100,townLocations);
        c.currentLocation = townLocations.get(0);
        System.out.println(c.currentLocation);
//        c.walk();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // this class helps us read the json file for items in a location
        FileReader readerItems = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Items.json");
        Object itemsObject = jsonparser.parse(readerItems);
        JSONObject items = (JSONObject)itemsObject;

        // Location is a json array of objects
        JSONArray itemsArray = (JSONArray)items.get("Items");

        for(int i = 0; i < itemsArray.size(); i++){
        JSONObject ithItem = (JSONObject) itemsArray.get(i);
        String item =  (String) ithItem.get("name");
        String itemLocation = (String) ithItem.get("location");
            for(var loc: townLocations){
                if(loc.getName().equalsIgnoreCase(itemLocation)){
                    loc.itemsInLocation.add(new Items(item));
                }
            }
        }

        for(int x = 0; x < townLocations.size(); x++){
            System.out.println(townLocations.get(x));
        }

    }
}
