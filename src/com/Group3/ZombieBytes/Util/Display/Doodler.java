package com.Group3.ZombieBytes.Util.Display;

import com.Group3.ZombieBytes.Driver.FXDriver;
import com.Group3.ZombieBytes.Game.Data.Lifeforms.Character;
import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.UserInput.Input;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Doodler {
    private static Paint backgroundColor = Color.BISQUE; //!DON'T USE AWT
    public final static int xRes = 800;
    public final static int yRes = 600;
    public final static int xScale = 1;
    public final static double yScale = 1.5;
    private static Group console;
    private static Group graphic;//current image

    private Doodler(){}
    public static Group drawMap(){
        //calculate square size
        int xSize = (xRes/10)*xScale;
        int ySize = (int) ((yRes/10)*yScale);
        // keep track of previous squares position
        double xPos = 0;
        double yPos = 0;
        //make a new rectangle for each location
        Rectangle[] rectangles = new Rectangle[Game.getGameLocation().size()];
        for(int i =0; i< Game.getGameLocation().values().size(); i++){
            //create rectangle
            Rectangle rect = new Rectangle(xSize, ySize);
            if(i!=0) {
                //move the rectangle proportional to size (aspect ratio 3:5(gross))
                xPos += xSize * 2.5;
                //since the map is 3x3 after every 3rd instance go down a row and start from left
                if (i % 3 == 0) {
                    xPos = 0;
                    yPos += ySize * 1.5;
                }
                //if the map is out of bounds, lower scale and try again
                if ((xPos + xSize) > xRes || (yPos + ySize) > yRes) {
                    //insert code here (need to change scale to not be final with getters and setters. Too lazy rn)
                    return drawMap();
                }
            }
            rect.setX(xPos);
            rect.setY(yPos);
            rectangles[i]=rect;
        }
        //create a group of all location rectangles
        Group rectGroup = new Group(rectangles);
        return rectGroup;
    }
    public static Rectangle[] getMapSquares(){
        Object[] nodes = graphic.getChildren().toArray();
        Rectangle[] rectangles = new Rectangle[nodes.length];
        try{
            for(int i =0; i<nodes.length; i++){
                Rectangle rectangle = (Rectangle) nodes[i];
                rectangles[i] = rectangle;
            }
            return rectangles;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //look through each rectangle, check location, if its the current location make it red, otherwise make sure it's black
    public static void updateMap(Rectangle[] rectangles){
        //make each rectangle black
        for(Rectangle rectangle : rectangles){
                rectangle.setFill(Color.BLACK);
        }
        getCurrentRectangle(rectangles).setFill(Color.RED); //set appropriate rectangle to red
    }
    //finds the proper rectangle for currentLocation
    public static Rectangle getCurrentRectangle(Rectangle[] rectangles){
        //ugly switch case to avoid refactor
        switch (Character.currentLocation.getName().toLowerCase()){
            case "road 1": {
                return rectangles[0];
            }
            case "hospital": {
                return rectangles[1];
            }
            case "road 2": {
                return rectangles[2];
            }
            case "road 3": {
                return rectangles[3];
            }
            case "towncenter": {
                return rectangles[4];
            }
            case "store": {
                return rectangles[5];
            }
            case "school": {
                return rectangles[6];
            }
            case "policestation": {
                return rectangles[7];
            }
            case "road 4": {
                return rectangles[8];
            }
        }
        return null;
    }
    //Creates a textbox and includes in field to draw a fake console
    public static Group getConsole(TextField in,TextArea out){
        if (Doodler.console==null){
            //style text area
            out.setWrapText(true);
            out.setEditable(false);
            out.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY,new Insets(0))));
            in.setPromptText("Enter your command here!");
            VBox consoleText = new VBox(out, in);
            Doodler.console = new Group(consoleText);
        }
        return Doodler.console;
    }
    public static Scene drawStartScene(){
        //start button
        Button start = new Button("Start");
        start.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> new Thread(() -> {
            try {
                Game.start(new Input());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start());
        //quit button
        Button quit = new Button("Quit");
        quit.setLayoutX(50);
        Group buttons = new Group(start, quit);
        //create title text
        Text title = new Text(FXDriver.appName);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setX(xRes/2);
        title.setY(yRes/3);
        //Create group of start items
        Group root = new Group(title, buttons);
        Doodler.graphic=root;
        //Create a scene
        return new Scene(root, xRes, yRes);

    }
    public static Group drawGameScene(Group graphic){
        Doodler.graphic = graphic;
        VBox frame = new VBox(graphic, getConsole(FXDriver.getInputField(), FXDriver.getTextField()));
        frame.setAlignment(Pos.CENTER);
        return new Group(frame);
    }
}
