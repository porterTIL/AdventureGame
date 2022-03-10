//package com.SemiFinalProject.Group3.ZombieBytes.Client;
//import com.Group3.ZombieBytes.Game.Game;
//import com.Group3.ZombieBytes.Game.Location;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.*;
//
//import java.io.*;
//import java.nio.file.Paths;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class ZombieGameClient {
//    public ZombieGameClient() throws IOException, ParseException {
//    }
//
//    public static void main(String[] args) throws JSONException, IOException, ParseException {
//        Game game1 = new Game();
////        game1.setGameBoard(5, 5, 2, 2, 2, 1);
////        ObjectMapper map1 = new ObjectMapper();
////        map1.writeValue(new File("target/map.json"), game1);
////        String mapAsString = ObjectMapper.writeValueAsString(game1);
//        // creating JSONObject
////        JSONObject location = new JSONObject();
//
//        org.json.simple.JSONObject location = new org.json.simple.JSONObject();
//        // putting data to JSONObject
////        location.put("Name", "PoliceStation");
////        location.put("Zombie", "Monkey");
////        location.put("Item", "Baton");
////        location.put("Item", "Sandwich");
//
//
//        // for location data, first create LinkedHashMap
//        Map policeStation = new LinkedHashMap(4);
//        policeStation.put("Item", "Baton");
//        policeStation.put("Item", "Sandwich");
//        policeStation.put("Zombie", "Monkey");
//        policeStation.put("Description", "You have entered the Police Station. You see a desk by the front door and jail cells to the back.");
//        policeStation.put("Key", "City Key");
//        policeStation.put("Valid Directions", "South");
//        policeStation.put("Valid Directions", "South");
//
//        Map school = new LinkedHashMap(4);
//        school.put("Item", "Apple");
//        school.put("Zombie", "Teacher Zombie");
//        school.put("Description", "You have entered the School. Empty desks line the halls.");
//        school.put("Key", "Nurse's Badge");
//        policeStation.put("Valid Directions", "South");
//        policeStation.put("Valid Directions", "South");
//
//        Map store = new LinkedHashMap(4);
//        store.put("Zombie", "Grocer Zombie");
//        store.put("Description", "You have entered the Store. Aisles are lined with grocery items.");
//        store.put("Key", "Banana");
//        policeStation.put("Valid Directions", "South");
//        policeStation.put("Valid Directions", "South");
//
//        Map hospital = new LinkedHashMap(4);
//        hospital.put("Zombie", "Zombie Boss");
//        hospital.put("Description", "You have entered the Hospital.");
//        hospital.put("Cure", "Cure");
//        policeStation.put("Valid Directions", "South");
//        policeStation.put("Valid Directions", "South");
//
//
//        // putting address to JSONObject
//        location.put("Police Station", policeStation);
//        location.put("School", school);
//        location.put("Store", store);
//        location.put("Hospital", hospital);
//
//        // writing JSON to file:"JSONExample.json" in cwd
//        PrintWriter pw = new PrintWriter("location.json");
//        pw.write(location.toString());
//
//        pw.flush();
//        pw.close();
////---------------------------------------------- above is printing to the xml file, below is getting from xml file
//
//        // parsing file "JSONExample.json"
////        Object obj = new JSONParser().parse(new FileReader("location.json"));
//        ObjectMapper mapper = new ObjectMapper();
//        Location JSONLocation = mapper.readValue(Paths.get("location.json").toFile(), Location.class);
//
//        System.out.println(JSONLocation);
        // typecasting obj to JSONObject
//         JSONLocation = (JSONObject) obj;
//        System.out.println(obj);
//        System.out.println(JSONLocation);
        // getting firstName and lastName
//        String item = (String) JSONLocation.get("Item");
//        String look = (String) location.get("Description");

//        System.out.println(item);
//        System.out.println(look);
//        JSONObject policeStationJSON = (JSONObject) location.get("Police Station"); //ATTEMPT 2
//        Map<String, Object> objectMap =   //ATTEMPT 2
//        Map PS = ((Map)JSONLocation.get("Police Station")); //ATTEMPT 1
//        JSONObject policeStationJSON = location.getJSONObject("Police Station");  //ATTEMPT 3
//        Map<String, Object> map = policeStationJSON.keySet().stream().collect(Collectors.toMap(Function.identity(), policeStationJSON::get));  //ATTEMPT 3
//        System.out.println(item);
//        System.out.println(PS);
//    }
//}

//game starts, print a location when it starts and if you say
//go north ect.
//description, list of items, Zombies, set of valid directions(where you can go)
//twinkies

//class locations
//town map class with all instances from location in a collection (getInstance)


