package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location {
    // Properties
    String name = null;
    String items = null;
    public List <Items> itemsInLocation = new ArrayList<Items>();
//    List <String> items = new ArrayList<>();

    // constructors
    public Location(String name, String items){
        setName(name);
        setItems(items);

    }

    // methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    private String falseToString(){
        int sizeofLocation = itemsInLocation.size();
        String item = "";
        for (int y = 0; y < sizeofLocation; y++){
            item += itemsInLocation.get(y).getName();
            item += ", ";
        }
        return item;
    }

    // to String
    public String toString(){
        return "This is a " + getName() + ", " + "and it has the following items: " + falseToString();
    }

}
