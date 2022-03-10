package com.Group3.ZombieBytes.Client;

import com.Group3.ZombieBytes.Characters.Character;
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

        // this class helps us read the json file
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
//            System.out.println("Name of the location is " + name);
//            System.out.println("The item here is " + item);
        }
//        System.out.println(townLocations.size());

        Character c = new Character("Sam", 100,townLocations);
        c.currentLocation = townLocations.get(0);
        System.out.println(c.currentLocation);
        c.startGame();
    }
}
