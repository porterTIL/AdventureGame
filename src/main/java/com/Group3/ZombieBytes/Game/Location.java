package com.Group3.ZombieBytes.Game;

import java.util.ArrayList;
import java.util.List;

public class Location {
    // Properties
    String name = null;
    String items = null;
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

    // to String
    public String toString(){
        return "This is a " + getName() + ", " + "and it has the following items: " + getItems();
    }

}
