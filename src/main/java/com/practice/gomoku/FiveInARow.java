package com.practice.gomoku;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(16, 16);
        int[] invalidMove = game.getINVALID_MOVE();
        int[] move = invalidMove;
        while (Arrays.equals(move, invalidMove)) {
            move = game.getMove(1);
        }
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
    }
}
