package com.practice.gomoku;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(16, 16);
        int counter = 0;
        while (counter < 3){
            int[] invalidMove = game.getINVALID_MOVE();
            int[] move = invalidMove;
            while (Arrays.equals(move, invalidMove)) {
                move = game.getMove(game.getPlayer());
            }
            game.mark(game.getPlayer(), move[0], move[1]);
            game.changePlayer(game.getPlayer());
            counter++;
        }
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
    }
}
