package com.SemiFinalProject.Group3.ZombieBytes.Game;
import com.SemiFinalProject.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.List;

public interface Location {
    //fields
    String name = null;
    List<Items> placedItems = new ArrayList<>();

    //methods
    public void checkItems();

    public ArrayList<Items> pickUp();

}
