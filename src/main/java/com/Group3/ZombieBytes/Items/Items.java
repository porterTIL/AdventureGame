package com.Group3.ZombieBytes.Items;

public class Items {

    // properties
    String name = null;

    // constructors
    public Items(String item){
        this.name = item;
    }
    // methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void use(){
        System.out.println("Using " + name);
    };
}
