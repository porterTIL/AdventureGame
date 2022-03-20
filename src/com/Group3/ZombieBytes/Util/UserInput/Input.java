package com.Group3.ZombieBytes.Util.UserInput;

import com.Group3.ZombieBytes.Driver.FXDriver;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {
    private TextField in;
    private Task<String> getInput = new Task(){
        @Override
        public String call(){
            awaitEnter();
            return in.getCharacters().toString();
        }
    };
    public Input() {
        in = FXDriver.getInputField();
    }

    //mimics the pausing functionality of console scanners
    public String readLine() {
        awaitEnter();
        return in.getCharacters().toString();
    }
    //waits until enter is pressed then breaks for readLine
    private void awaitEnter() {
        in.addEventFilter(KeyEvent.KEY_PRESSED, breakOnEnterHandler);
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    EventHandler<KeyEvent> breakOnEnterHandler = keyEvent -> {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            in.removeEventFilter(keyEvent.getEventType(), (EventHandler<? super Event>)keyEvent.getSource());
            return;
        }
    };

}
