package com.Group3.ZombieBytes.Game.Data.Lifeforms;

public enum Directions {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static boolean isDirection(String in) {
        for(Directions direction : Directions.values()) {
            if(in.equalsIgnoreCase(direction.name())) {
                return true;
            }
        }
        return false;
    }
}
