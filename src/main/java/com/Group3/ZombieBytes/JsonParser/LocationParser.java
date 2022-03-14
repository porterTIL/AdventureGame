package com.Group3.ZombieBytes.JsonParser;

public class LocationParser {
    public static void run() {
//     created an arraylist to store my location objects
        HashMap<String, Location> gameLocation = new HashMap<String, Location>();

        // this class helps us parse the json file
        JSONParser jsonparser = new JSONParser();

        // this class helps us read the json file for location
        {
            try {
                FileReader locationReader = new FileReader("src/main/java/com/V2/Group3/Zombie/JsonFiles/location.json");
                Object locationObject = jsonparser.parse(locationReader);
                JSONObject locations = (JSONObject) locationObject;

                // Location is a json array of objects
                JSONArray locationArray = (JSONArray) locations.get("Location");

                for (int i = 0; i < locationArray.size(); i++) {
                    JSONObject location = (JSONObject) locationArray.get(i);
                    String name = (String) location.get("name");
//            String item =  (String) location.get("Item");
                    String description = (String) location.get("Description");
                    gameLocation.put(name, new Location(name, description));
                }
                ZombieGame.setGameLocation(gameLocation);
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
