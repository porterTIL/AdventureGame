package com.Group3.ZombieBytes.Game.Data.Items;

public class Item {
    // properties
    String locatedIn = null;
    String name = null;
    long quantity = 0;
    String type = null;
    String description = null;


    String use = null;

    // constructors
    public Item(String locatedIn, String name, long quantity, String type, String description, String use){
        setLocatedIn(locatedIn);
        setName(name);
        setQuantity(quantity);
        setType(type);
        setDescription(description);
        setUse(use);
    }

    // methods
    // business methods
//    public void use(){
//        System.out.println("Using " + getName() + ": " + getDescription());
//    }

    // getters and setters
    public String getLocatedIn() {
        return locatedIn;
    }
    public void setLocatedIn(String locatedIn) {
        this.locatedIn = locatedIn;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String toString(){
        return getName().toUpperCase()+": " + description;
    }

}
