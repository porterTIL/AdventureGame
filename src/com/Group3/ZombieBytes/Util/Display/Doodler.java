package com.Group3.ZombieBytes.Util.Display;

import com.Group3.ZombieBytes.Driver.FXApp;
import com.Group3.ZombieBytes.Game.Data.Location;
import com.Group3.ZombieBytes.Game.Game;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class Doodler {
    public final static int xScale = 1;
    public final static int yScale = xScale;
    public static Group drawMap(){
        //calculate square size
        int xSize = (FXApp.xRes/10)*xScale;
        int ySize = (FXApp.yRes/10)*yScale;
        //make a new rectangle for each location
        // keep track of previous squares position
        double xPos = 0;
        double yPos = 0;
         Rectangle[] rectangles = new Rectangle[Game.getGameLocation().size()];
        for(int i =0; i< Game.getGameLocation().values().size(); i++){
            //create rectangle
            Rectangle rect = new Rectangle(xSize, ySize);
            //move the rectangle proportional to size
            xPos+= xSize*2;
            //since the map is 3x3 after every 3rd instance go down a row and start from left
            if(i%3==0) {
                xPos = 0;
                yPos += ySize*2;
            }
            //if the map is out of bounds, lower scale and try again
            if((xPos+xSize)>FXApp.xRes || (yPos+ySize)>FXApp.yRes) {
                //insert code here (need to change scale to not be final with getters and setters. Too lazy rn)
            }
            rect.setX(xPos);
            rect.setY(yPos);
            rectangles[i]=rect;
        }
        //create a group of all location rectangles
        Group rectGroup = new Group(rectangles);
        return rectGroup;
    }
    public static Scene drawScene(Group... groups){
        return null;
    }
}
