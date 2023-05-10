package com.practice.gomoku;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(11, 11);
        int[][] testBoard = game.getBoard();
        testBoard[0][0] = 1;
        game.setBoard(testBoard);
        int[] move = {26, 26};
        while (Arrays.equals(move, new int[] {26, 26})) {
            move = game.getMove(1);
        }
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
    }
}
