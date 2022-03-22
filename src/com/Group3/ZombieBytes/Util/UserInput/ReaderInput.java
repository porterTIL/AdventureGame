package com.Group3.ZombieBytes.Util.UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//backwards compatibility for console based play
public class ReaderInput extends Input {
    BufferedReader reader;
    public ReaderInput() { //reader used by original team
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        this.reader=reader;
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) { //HOW DO YOU THROW AN IO EXCEPTION
            return "oops";
        }
    }
}
