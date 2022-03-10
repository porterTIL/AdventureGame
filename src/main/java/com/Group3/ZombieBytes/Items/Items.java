package com.Group3.ZombieBytes.Items;

public class Items {

    // properties
    String name = null;


    String description = null;

    // constructors
    public Items(String item, String description){
        this.name = item;
        this.description = description;
    }
    // methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void use(){
        System.out.println("Using " + getName() + ": " + getDescription());
    }
    public String toString(){
        return description;
    }
}
