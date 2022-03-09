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
import java.util.function.Function;
import java.util.stream.Collectors;

public class ZombieGameClient {
    public static void main(String[] args) throws JSONException, IOException, ParseException {
//        Game game1 = new Game();
//        game1.setGameBoard(5, 5, 2, 2, 2, 1);
//        ObjectMapper map1 = new ObjectMapper();
//        map1.writeValue(new File("target/map.json"), game1);
//        String mapAsString = ObjectMapper.writeValueAsString(game1);
        // creating JSONObject
        JSONObject location = new JSONObject();

        // putting data to JSONObject
        location.put("Name", "PoliceStation");
//        location.put("Zombie", "Monkey");
//        location.put("Item", "Baton");
//        location.put("Item", "Sandwich");


        // for location data, first create LinkedHashMap
        Map policeStation = new LinkedHashMap(4);
        policeStation.put("Item", "Baton");
        policeStation.put("Item", "Sandwich");
        policeStation.put("Zombie", "Monkey");
        policeStation.put("Description", "You have entered the Police Station. You see a desk by the front door and jail cells to the back.");
        policeStation.put("Key", "City Key");

        Map school = new LinkedHashMap(4);
        policeStation.put("Item", "Apple");
        policeStation.put("Zombie", "Zombie1");
        policeStation.put("Description", "You have entered the School.");
        policeStation.put("Key", "Nurse's Badge");

       //Add other locations


        // putting address to JSONObject
        location.put("Police Station", policeStation);


        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("location.json");
        pw.write(location.toString());

        pw.flush();
        pw.close();
//---------------------------------------------- above is printing to the xml file, below is getting from xml file
        // parsing file "JSONExample.json"
        Object JSONLocation = new JSONParser().parse(new FileReader("location.json"));

        // getting firstName and lastName
//        String item = (String) location.get("Item");
//        String look = (String) location.get("Description");

//        System.out.println(item);
//        System.out.println(look);
//        JSONObject policeStationJSON = (JSONObject) location.get("Police Station");
//        Map<String, Object> objectMap = policeStationJSON.toMap();
//        Map PS = ((Map)location.get("Police Station"));
        JSONObject policeStationJSON = location.getJSONObject("Police Station");
//        Map<String, Object> map = policeStationJSON.keySet().stream().collect(Collectors.toMap(Function.identity(), policeStationJSON::get));
        System.out.println(policeStationJSON);
            }
        }
//game starts, print a location when it starts and if you say
//go north ect.
//description, list of items, Zombies, set of valid directions(where you can go)
//twinkies

//class locations
//town map class with all instances from location in a collection (getInstance)
//charles command parser

