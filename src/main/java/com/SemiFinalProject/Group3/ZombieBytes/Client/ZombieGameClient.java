package com.SemiFinalProject.Group3.ZombieBytes.Client;
import com.SemiFinalProject.Group3.ZombieBytes.Game.Game;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZombieGameClient {
    public static void main(String[] args) throws JSONException, IOException, ParseException {
        Game game1 = new Game();
        game1.setGameBoard(5, 5, 2, 2, 2, 1);
//        ObjectMapper map1 = new ObjectMapper();
//        map1.writeValue(new File("target/map.json"), game1);
//        String mapAsString = ObjectMapper.writeValueAsString(game1);
        // creating JSONObject
        JSONObject location = new JSONObject();

        // putting data to JSONObject
        location.put("Name", "PoliceStation");
        location.put("Zombie", "Monkey");
        location.put("Item", "Baton");
        location.put("Item", "Sandwich");


        // for address data, first create LinkedHashMap
        Map inventory = new LinkedHashMap(4);
//        inventory.put("Item", "Baton");

        // putting address to JSONObject
        location.put("Inventory", inventory);


        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("location.json");
        pw.write(location.toString());

        pw.flush();
        pw.close();
//---------------------------------------------- above is printing to the xml file, below is getting from xml file
        // parsing file "JSONExample.json"
        Object finalLocation = new JSONParser().parse(new FileReader("location.json"));

        // getting firstName and lastName
        String name = (String) location.get("Name");
        String item = (String) location.get("Item");

        System.out.println(name);
        System.out.println(item);

            }
        }


