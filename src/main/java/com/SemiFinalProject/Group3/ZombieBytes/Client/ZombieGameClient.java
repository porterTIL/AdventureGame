package com.SemiFinalProject.Group3.ZombieBytes.Client;

import com.SemiFinalProject.Group3.ZombieBytes.Game.Game;

public class ZombieGameClient {
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.setGameBoard(5, 5, 2, 2, 2, 1);
    }
}
