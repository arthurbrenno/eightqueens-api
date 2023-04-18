package com.brc.eightqueens.resources;

public class Board {
    private final int BOARD_SIZE;
    private String[][] board;


    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
        board = new String[BOARD_SIZE][BOARD_SIZE];
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
