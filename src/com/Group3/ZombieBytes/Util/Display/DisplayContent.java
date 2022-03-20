package com.Group3.ZombieBytes.Util.Display;

import com.Group3.ZombieBytes.Driver.FXDriver;
import javafx.scene.control.TextArea;

import java.util.Map;

public class DisplayContent extends PrintContent{
    static String linebreak = System.lineSeparator();
    private TextArea console;
    public DisplayContent(){
        console = Doodler.out;
    }
    @Override
    public void print(String text) {
        console.appendText(text + linebreak);
    }
    @Override
    public void print(int text) {
        console.appendText(text + linebreak);
    }
    @Override
    public void print(long text) {
        console.appendText(text + linebreak);
    }
    @Override
    public void print(Map<Object,Object> gameObject) {
        console.appendText(gameObject.toString()+ linebreak);
    }
    @Override
    public void print(boolean text) {
        if(text)console.appendText("so true" + linebreak);
        else console.appendText("unbelievably wrong" + linebreak);
    }
    public void clear(){
        console.clear();
    }
    public TextArea getConsole(){
        return console;
    }
}
