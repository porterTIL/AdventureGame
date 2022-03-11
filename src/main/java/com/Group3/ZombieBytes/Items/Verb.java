package com.Group3.ZombieBytes.Items;

public class Verb {
    // properties
    public String value = null;
    // constructors
    public Verb(String verb){
        this.value = verb;
    }
    // methods
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
