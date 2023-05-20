package com.practice.gomoku;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(1, 1);
        game.play();
        game.enableAi(1);
        game.enableAi(2);
    }
}
