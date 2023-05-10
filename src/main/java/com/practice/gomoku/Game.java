package com.practice.gomoku;

import java.util.Scanner;
import java.util.regex.*;

public class Game implements GameInterface {

    private int[][] board;

    public Game(int nRows, int nCols) {
        nRows = (nRows > 26) ? 26 : nRows;
        nRows = (nRows < 5) ? 5 : nRows;
        nCols = (nCols > 26) ? 26 : nCols;
        nCols = (nCols < 5) ? 5 : nRows;
        board = new int[nRows][nCols];
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getMove(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Next move: ");
        String userInput = sc.next();
        Pattern pattern = Pattern.compile("^[a-zA-Z]([1-9]|1[0-9]|2[0-6])$");
        Matcher matcher = pattern.matcher(userInput);
        if(matcher.find()){
            int[] possibleMove = getArrayOfTwoIntegersFromUserInput(userInput.toLowerCase());
            if(board[possibleMove[0]][possibleMove[1]] == 0){
                return possibleMove;
            }
        }
        return new int[] {26, 26};
    }

    private int[] getArrayOfTwoIntegersFromUserInput(String userInput) {
        String alphabet = "";
        for(char c='a'; c <= 'z'; c++){
            alphabet += c;
        }
        int[] coordinate = new int[2];
        coordinate[0] = alphabet.indexOf(userInput.toCharArray()[0]);
        coordinate[1] = Integer.parseInt(userInput.substring(1)) - 1;
        return coordinate;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
    }

    public boolean hasWon(int player, int howMany) {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void printBoard() {
    }

    public void printResult(int player) {
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {
    }
}
