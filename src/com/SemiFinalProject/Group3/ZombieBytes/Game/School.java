package com.SemiFinalProject.Group3.ZombieBytes.Game;

import com.SemiFinalProject.Group3.ZombieBytes.Items.Items;

import java.util.ArrayList;
import java.util.List;

public class School implements Location{
    String name = null;
    List<Items> placedItems = new ArrayList<>();

    @Override
    public void checkItems() {

    }

    @Override
    public ArrayList<Items> pickUp() {
        return null;
    }
}
