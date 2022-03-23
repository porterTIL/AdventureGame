package com.Group3.ZombieBytes.Util.UserInput;

import com.Group3.ZombieBytes.Driver.FXDriver;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
//should probably be a singleton or something
public class Input {
    private TextField in; // just grabbed on construction
    private static boolean hasPressedEnter;
    public Input() {
        in = FXDriver.getInputField();
    }

    //mimics Scanner's readLine() minus logging user input
    public String readLine() {
        awaitEnter();
        String out = in.getCharacters().toString();
        in.clear();
        return out;
    }
    //waits until enter is pressed then breaks for readLine
    private void awaitEnter() {
        in.addEventFilter(KeyEvent.KEY_PRESSED, enterHandler); // look for a key press and send it to the handler that checks for enter
        while (!hasPressedEnter) {// broken by handler
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasPressedEnter = false; //reset
    }
    public static EventHandler<KeyEvent> enterHandler = keyEvent -> { //just breaks the loop if they press enter
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {//if they pressed enter
            TextField in = (TextField) keyEvent.getSource(); // i promise this is a textfield
            in.removeEventFilter(keyEvent.getEventType(), Input.enterHandler); // clean up
            hasPressedEnter=true;//break loop
        }
    };

}
