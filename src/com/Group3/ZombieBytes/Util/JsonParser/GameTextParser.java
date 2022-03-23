package com.Group3.ZombieBytes.Util.JsonParser;
import com.Group3.ZombieBytes.Util.Display.GameText;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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
                Reader gameTextReader = new InputStreamReader(getFileFromResourceAsStream("json/GameText.json"));
                Object gameTextObject = jsonparser.parse(gameTextReader);
                JSONObject jsonGameTextObject = (JSONObject) gameTextObject;

                // Location is a json array of objects
                JSONArray textArray = (JSONArray) jsonGameTextObject.get("gameText");

                for (int i = 0; i < textArray.size(); i++) {
                    JSONObject location = (JSONObject) textArray.get(i);
                    String name = (String) location.get("name");
                    String description = (String) location.get("text");
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
    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = GameTextParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}

