/* DO NOT CHANGE THIS INTERFACE! It will be used to test your solution. */

package com.practice.gomoku;


public interface GameInterface {
    void setBoard(int[][] board);
    int[][] getBoard();

    int[] getMove(int player);
    int[] getAiMove(int player);
    void mark(int player, int row, int col);
    boolean hasWon(int player);
    boolean isFull();
    void printBoard();
    void printResult(int player);
    void enableAi(int player);
    void play(int howMany);
}
