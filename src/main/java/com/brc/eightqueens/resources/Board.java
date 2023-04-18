package com.brc.eightqueens.resources;

public class Board {
    private final int BOARD_SIZE;
    private String[][] board;


    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
        board = new String[BOARD_SIZE][BOARD_SIZE];
    }
    
    public Board(int boardSize, String fillCharacter) {
        BOARD_SIZE = boardSize;
        board = new String[BOARD_SIZE][BOARD_SIZE];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = fillCharacter;
            }
        }
    }

    public String[][] getBoard() {
        return this.board;
    }

    public int getBoardSize() {
        return this.BOARD_SIZE;
    }

    public String getElement(int row, int col) {
        return board[row][col];
    }

    public void setElement(String element, int row, int col) {
        board[row][col] = element;
    }

}
