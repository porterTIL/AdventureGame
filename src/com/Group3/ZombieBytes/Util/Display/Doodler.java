package com.Group3.ZombieBytes.Util.Display;

import com.Group3.ZombieBytes.Driver.FXDriver;
import com.Group3.ZombieBytes.Game.Game;
import com.Group3.ZombieBytes.Util.UserInput.Input;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Window;

public class Doodler {
    private static Paint backgroundColor = Color.WHITE; //!DON'T USE AWT
    public final static int xRes = 400;
    public final static int yRes = 400;
    public final static int xScale = 1;
    public final static int yScale = 1;
    private final static TextField in = FXDriver.getInputField();
    public final static TextArea out = FXDriver.getTextField();
    private Doodler(){}
    public static Group drawMap(){
        //calculate square size
        int xSize = (xRes/10)*xScale;
        int ySize = (yRes/10)*yScale;
        // keep track of previous squares position
        double xPos = 0;
        double yPos = 0;
        //make a new rectangle for each location
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
            if((xPos+xSize)> xRes || (yPos+ySize)> yRes) {
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
    //Creates a textbox and includes in field to draw a fake console
    public static Group drawConsole(){
        //create textbox background
        Rectangle background = new Rectangle();
        background.setWidth(xRes); //screen width
        background.setHeight(yRes/2); // half the height of screen
        background.setY(yRes/2); //the bottom half
        background.setFill(Color.WHITE);//white background
        //get text area, then position and style it

        return new Group();
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
        //Create a scene
        return new Scene(root, xRes, yRes);

    }
    public static Group drawGameScene(Group graphic){
        Group console = drawConsole();

        return new Group(graphic, console);
    }
}
