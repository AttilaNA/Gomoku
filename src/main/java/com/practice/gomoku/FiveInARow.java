package com.practice.gomoku;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(16, 16);
        int[] move = {26, 26};
        while (Arrays.equals(move, new int[] {26, 26})) {
            move = game.getMove(1);
        }
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
    }
}
