package com.practice.gomoku;

import java.util.Arrays;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game(10, 10);
        while (!game.hasWon(game.getPlayer())){
            int[] move = game.getINVALID_MOVE();
            while (Arrays.equals(move, game.getINVALID_MOVE())) {
                move = game.getMove(game.getPlayer());
            }
            game.mark(game.getPlayer(), move[0], move[1]);
            if(!game.hasWon(game.getPlayer())){
                game.changePlayer(game.getPlayer());
            }
        }
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);
    }
}
