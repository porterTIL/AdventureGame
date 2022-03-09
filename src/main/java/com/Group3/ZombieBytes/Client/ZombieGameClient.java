package com.Group3.ZombieBytes.Client;

import com.Group3.ZombieBytes.Game.Location;

import java.util.ArrayList;

public class ZombieGameClient {
    public static void main (String[] args) {
        // create hospital
        ArrayList<String> hospitalItems = new ArrayList<>();
        hospitalItems.add("Health Kit");
        Location hospital = new Location("Hospital",hospitalItems);

        // create policeStation
        ArrayList<String> policeItems = new ArrayList<>();
        policeItems.add("Baton");
        Location policeStation = new Location("PoliceStation", policeItems);

        // create Store
        ArrayList<String> storeItems = new ArrayList<>();
        storeItems.add("Food");
        Location store = new Location("Store", storeItems);

        // create School
        ArrayList<String> schoolItems = new ArrayList<>();
        schoolItems.add("Books");
        Location school = new Location("School", schoolItems);

        System.out.println(hospital);
        System.out.println(policeStation);
        System.out.println(store);
        System.out.println(school);



    }
}
