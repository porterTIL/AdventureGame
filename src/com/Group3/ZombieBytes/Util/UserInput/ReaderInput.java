package com.Group3.ZombieBytes.Util.UserInput;

import com.Group3.ZombieBytes.Util.UserInput.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderInput extends Input {
    BufferedReader reader;
    public ReaderInput() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        this.reader=reader;
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "oops";
        }
    }
}
