package com.Group3.ZombieBytes.Util.JsonParser;

import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Data.Location;
import com.Group3.ZombieBytes.Data.Items.Item;
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

public class ItemParser {
    public static void run() {
//     created an arraylist to store my location objects
        List<Item> itemList = new ArrayList<>();

        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();

        // this class helps us read the json file for location
        {
            try {
                FileReader itemReader = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/Items.json");
                Object itemObject = jsonparser.parse(itemReader);
                JSONObject items = (JSONObject) itemObject;

                // Location is a json array of objects
                JSONArray itemArray = (JSONArray) items.get("Items");

                // created an arrayList of items
                for (int i = 0; i < itemArray.size(); i++) {
                    JSONObject item = (JSONObject) itemArray.get(i);
                    String location = (String) item.get("location");
                    String name = (String) item.get("name");
                    long quantity = (Long) item.get("quantity");
                    String type = (String) item.get("type");
                    String description = (String) item.get("Description");
                    String use = (String) item.get("use");

                    itemList.add(new Item(location, name, quantity, type, description, use));
                }

                // found on stackOverFlow flow how to parse through Location hash map from ZombieGame
                for(Map.Entry<String, Location> loc : Game.getGameLocation().entrySet()) {
                    ArrayList<Item> tempItemArrayList = new ArrayList<>();
                    String key = loc.getKey();
                    Location location = loc.getValue();
                    for(Item item : itemList){
                        if (location.getName().equalsIgnoreCase(item.getLocatedIn())){
                            tempItemArrayList.add(item);
                        }
                    }
                    location.setItems(tempItemArrayList);
//                    tempItemArrayList.clear();

                }
//                ZombieGame.setGameLocation(gameLocation);
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
