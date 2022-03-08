package com.SemiFinalProject.Group3.ZombieBytes.Game;

import com.SemiFinalProject.Group3.ZombieBytes.Characters.Character;
import com.SemiFinalProject.Group3.ZombieBytes.Characters.Zombie;
import com.SemiFinalProject.Group3.ZombieBytes.Items.Food;
import com.SemiFinalProject.Group3.ZombieBytes.Items.Items;

import java.util.*;

public class Game {
    // properties
    public ArrayList<ArrayList<String>> board = new ArrayList<>();
    public Character character;
    public Zombie zombie;


    public ArrayList<Items> items = new ArrayList<>();

    public boolean gameInProgress = false;

    // methods
    public void getItems(){
        ArrayList<Items> items = new ArrayList<>();
        Items cheese =new Food("cheese");
        items.add(cheese);
    }
    public void setRules(){
        // set the rules of the game, use a scanner for map size
    }

    public void gameStart(){
        this.gameInProgress = true;
        //
    }

    public void gameOver(){
        this.gameInProgress = false;
    }

    public void setGameBoard(int length, int width, int hospital){
        String land = "Land";
        for(int x = 0; x < length; x++){
            board.add(new ArrayList<>());
            for(int y = 0; y < width; y++){
                board.get(x).add(land);
            }
        }
        setHospital(hospital, length, width);

        // prints the board
        for(int x = 0; x < board.size(); x++){
            System.out.println(board.get(x));
        }
    }
    public void setHospital(int hospital, int length, int width){
        Random randomNumber = new Random();
        for (int x = 0; x < hospital; ++x){
            int randomLength = randomNumber.nextInt(length);
            int randomWidth = randomNumber.nextInt(width);

            if (!board.get(randomLength).get(randomWidth).equalsIgnoreCase("Hospital")){
             board.get(randomLength).set(randomWidth, "Hospital");
            } else{
                x--;
            }

        }
    }

}
