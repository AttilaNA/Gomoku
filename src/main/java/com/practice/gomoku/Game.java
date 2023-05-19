package com.practice.gomoku;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Game implements GameInterface {

    private int[][] board;

    private final int MIN_SIZE;

    private final int MAX_SIZE;

    private final int[] INVALID_MOVE;

    private int player;

    public Game(int nRows, int nCols) {
        MIN_SIZE = 5;
        MAX_SIZE = 26;
        INVALID_MOVE = new int[] {MAX_SIZE, MAX_SIZE};
        player = 1;
        nRows = (nRows > MAX_SIZE) ? MAX_SIZE : nRows;
        nRows = (nRows < MIN_SIZE) ? MIN_SIZE : nRows;
        nCols = (nCols > MAX_SIZE) ? MAX_SIZE : nCols;
        nCols = (nCols < MIN_SIZE) ? MIN_SIZE : nCols;
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

    public int[] getINVALID_MOVE() { return INVALID_MOVE; }

    public int getPlayer() { return player; }

    public int[] getMove(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player%d next move: ".formatted(player));
        String userInput = sc.next();
        Pattern pattern = Pattern.compile("^[a-zA-Z]([1-9]|1[0-9]|2[0-6])$");
        Matcher matcher = pattern.matcher(userInput);
        if(matcher.find()){
            int[] possibleMove = getArrayOfTwoIntegersFromUserInput(userInput.toLowerCase());
            if(Arrays.equals(possibleMove, INVALID_MOVE)){
                return INVALID_MOVE;
            }
            else if (board[possibleMove[0]][possibleMove[1]] == 0){
                return possibleMove;
            }
        }
        return INVALID_MOVE;
    }

    private int[] getArrayOfTwoIntegersFromUserInput(String userInput) {
        String alphabet = "";
        for(char c='a'; c <= 'z'; c++){
            alphabet += c;
        }
        int[] coordinate = new int[2];
        coordinate[0] = alphabet.indexOf(userInput.toCharArray()[0]);
        coordinate[1] = Integer.parseInt(userInput.substring(1)) - 1;
        if(coordinate[0] > board.length - 1 || coordinate[1] > board[0].length - 1){
            return INVALID_MOVE;
        }
        return coordinate;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
        board[row][col] = player;
    }

    public boolean hasWon(int player) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length - 4; j++){
                if(board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player && board[i][j+4] == player){
                    return true;
                }
            }
        }
        for(int i = 0; i < board.length - 4; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player && board[i+4][j] == player){
                    return true;
                }
            }
        }
        for(int i = 4; i < board.length; i++){
            for(int j = 0; j < board[0].length - 4; j++){
                if(board[i][j] == player && board[i-1][j+1] == player && board[i-2][j+2] == player && board[i-3][j+3] == player && board[i-4][j+4] == player){
                    return true;
                }
            }
        }
        for(int i = 0; i < board.length - 4; i++){
            for(int j = 0; j < board[0].length - 4; j++){
                if(board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == player && board[i+3][j+3] == player && board[i+4][j+4] == player){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int[] row: board) {
            for (int i: row) {
                if(i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
    }

    public void printResult(int player) {
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {
    }

    public void changePlayer(int currentPlayer){
        player = currentPlayer == 1 ? 2 : 1;
    }
}
