package com.Group3.ZombieBytes.Util.JsonParser;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Data.Location;
import com.Group3.ZombieBytes.Data.Lifeforms.Zombie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZombieParser {
    public static void run() {
//     created an arraylist to store my location objects
        List<Zombie> zombieList = new ArrayList<>();
        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();
        // this class helps us read the json file for location
        {
            try {
                FileReader zombieReader = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Zombie.json");
                Object zombieObject = jsonparser.parse(zombieReader);
                JSONObject zombies = (JSONObject) zombieObject;
                // Location is a json array of objects
                JSONArray zombieArray = (JSONArray) zombies.get("Zombies");
                // created an arrayList of items
                for (int i = 0; i < zombieArray.size(); i++) {
                    JSONObject zombie = (JSONObject) zombieArray.get(i);
                    String name = (String) zombie.get("name");
                    long healthPoint = (Long) zombie.get("healthPoint");
                    String location = (String) zombie.get("location");
                    String description = (String) zombie.get("description");
                    zombieList.add(new Zombie(name, healthPoint, location, description));
                }
                for (Map.Entry<String, Location> loc : Game.getGameLocation().entrySet()) {
                    ArrayList<Zombie> tempZombieList = new ArrayList<>();
//                    String key = loc.getKey();
                    Location location = loc.getValue();
                    for (Zombie zombie: zombieList){
                        if (location.getName().equalsIgnoreCase(zombie.getZombieLocation())){
                            tempZombieList.add(zombie);
                        }
                    }
                    location.setZombies(tempZombieList);
                }
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
