package com.Group3.ZombieBytes.Util.JsonParser;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Game.Data.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;

public class LocationParser {

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = LocationParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
    public static void run() {
//     created an arraylist to store my location objects
        HashMap<String, Location> gameLocation = new HashMap<String, Location>();

        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();

        // this class helps us read the json file for location
        {
            try {
                Reader locationReader = new InputStreamReader(getFileFromResourceAsStream("JSON/Location.json"));
                Object locationObject = jsonparser.parse(locationReader);
                JSONObject locations = (JSONObject) locationObject;

                // Location is a json array of objects
                JSONArray locationArray = (JSONArray) locations.get("Location");

                for (int i = 0; i < locationArray.size(); i++) {
                    JSONObject location = (JSONObject) locationArray.get(i);
                    String name = (String) location.get("name");
                    String description = (String) location.get("description");
                    String north = (String) location.get("North");
                    String east = (String) location.get("East");
                    String south = (String) location.get("South");
                    String west = (String) location.get("West");
                    String inspect = (String) location.get("inspect");

                    HashMap<String, String> tempAvailableDirection = new HashMap<>();
                    tempAvailableDirection.put("north", north);
                    tempAvailableDirection.put("east", east);
                    tempAvailableDirection.put("south", south);
                    tempAvailableDirection.put("west", west);

                    gameLocation.put(name, new Location(name, description, tempAvailableDirection, inspect));
                }
                Game.setGameLocation(gameLocation);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
