package com.Group3.ZombieBytes.JsonParser;
import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Game.GameText;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class GameTextParser {
    public static void run(){
        //     created an arraylist to store my location objects
        HashMap<String, String> gameText = new HashMap<String, String>();

        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();

        // this class helps us read the json file for location
        {
            try {
                FileReader gameTextReader = new FileReader("src/main/java/com/Group3/ZombieBytes/JSONfiles/GameText.json");
                Object gameTextObject = jsonparser.parse(gameTextReader);
                JSONObject jsonGameTextObject = (JSONObject) gameTextObject;

                // Location is a json array of objects
                JSONArray textArray = (JSONArray) jsonGameTextObject.get("gameText");

                for (int i = 0; i < textArray.size(); i++) {
                    JSONObject location = (JSONObject) textArray.get(i);
                    String name = (String) location.get("name");
                    String description = (String) location.get("description");
                    gameText.put(name, description);
                }
                GameText.setGameText(gameText);
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

