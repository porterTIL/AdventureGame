package com.Group3.ZombieBytes.Game;

import com.Group3.ZombieBytes.lifeforms.Character;
import com.Group3.ZombieBytes.lifeforms.Zombie;
import com.Group3.ZombieBytes.Items.*;

import java.util.*;

public class Game {
    // properties
    public ArrayList<ArrayList<String>> board = new ArrayList<>();
    public Character character;
    public Zombie zombie;


    public ArrayList<Item> items = new ArrayList<>();

    public boolean gameInProgress = false;

    // methods
    public void getItems(){
    }
    public void setRules(){
        setIntro();
        setParameters();

    }

    public void gameStart(){
        this.gameInProgress = true;
        //
    }

    public void gameOver(){
        this.gameInProgress = false;
    }

    public void setGameBoard(int length, int width, int hospital, int store, int policeStation, int school){
        String land = "Land";
        for(int x = 0; x < length; x++){
            board.add(new ArrayList<>());
            for(int y = 0; y < width; y++){
                board.get(x).add(land);
            }
        }
        setHospital(hospital, length, width);
        setStore(store, length, width);
        setPoliceStation(policeStation, length, width);
        setSchool(school, length, width);

        // prints the board
        for(int x = 0; x < board.size(); x++){
            System.out.println(board.get(x));
        }
    }
    public void setHospital(int hospital, int length, int width){
        Random randomNumber = new Random();
        for (int x = 0; x < hospital; x++){
            int randomLength = randomNumber.nextInt(length);
            int randomWidth = randomNumber.nextInt(width);

            if (!board.get(randomLength).get(randomWidth).equalsIgnoreCase("Hospital")){
                if(board.get(randomLength).get(randomWidth).equalsIgnoreCase("land")){
                    board.get(randomLength).set(randomWidth, "Hospital");
                }else {
                    x--;
                }
            } else{
                x--;
            }

        }
    }
    public void setStore(int store, int length, int width){
        Random randomNumber = new Random();
        for (int x = 0; x < store; x++){
            int randomLength = randomNumber.nextInt(length);
            int randomWidth = randomNumber.nextInt(width);

            if (!board.get(randomLength).get(randomWidth).equalsIgnoreCase("Store")){
                if(board.get(randomLength).get(randomWidth).equalsIgnoreCase("land")){
                    board.get(randomLength).set(randomWidth, "Store");
                }else {
                    x--;
                }
            } else{
                x--;
            }

        }
    }
    public void setPoliceStation(int policeStation, int length, int width){
        Random randomNumber = new Random();
        for (int x = 0; x < policeStation; x++){
            int randomLength = randomNumber.nextInt(length);
            int randomWidth = randomNumber.nextInt(width);

            if (!board.get(randomLength).get(randomWidth).equalsIgnoreCase("PoliceStation")){
                if(board.get(randomLength).get(randomWidth).equalsIgnoreCase("land")){
                    board.get(randomLength).set(randomWidth, "PoliceStation");
                }else {
                    x--;
                }
            } else{
                x--;
            }

        }
    }
    public void setSchool(int school, int length, int width){
        Random randomNumber = new Random();
        for (int x = 0; x < school; x++){
            int randomLength = randomNumber.nextInt(length);
            int randomWidth = randomNumber.nextInt(width);

            if (!board.get(randomLength).get(randomWidth).equalsIgnoreCase("School")){
                if(board.get(randomLength).get(randomWidth).equalsIgnoreCase("land")){
                    board.get(randomLength).set(randomWidth, "School");
                }else {
                    x--;
                }
            } else{
                x--;
            }

        }
    }

    public void setIntro(){
        System.out.println("Welcome to Zombie Bytes!!!");
    }
    public void setParameters(){

    }


}
