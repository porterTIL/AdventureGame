package com.SemiFinalProject.Group3.ZombieBytes.Client;
import com.SemiFinalProject.Group3.ZombieBytes.Game.Game;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.FileWriter;

public class ZombieGameClient {
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.setGameBoard(5, 5, 2, 2, 2, 1);
        ObjectMapper map1 = new ObjectMapper();
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Shikhar");
        jsonObject.put("Last_Name", "Dhawan");
        jsonObject.put("Date_Of_Birth", "1981-12-05");
        jsonObject.put("Place_Of_Birth", "Delhi");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter("E:/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
