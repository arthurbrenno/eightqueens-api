package com.brc.eightqueens.resources;

public class Terminal {
    
    public static void display(Board board) {
        for (int row = 0; row < board.getBoardSize(); row++) {
            System.out.printf("%n");
            for (int col = 0; col < board.getBoardSize(); col++) {
                System.out.printf("%s %s", board.getElement(row, col), "|");
            }
            System.out.printf("%n");
        }
    }

    public static void display(ChessBoard board) {
        System.out.printf("%n %4s %s"," ", "--------------------------------------------------");
        for (int row = 0; row < board.getBoardSize(); row++) {
            System.out.printf("%n");
            for (int col = 0; col < board.getBoardSize(); col++) {
                System.out.printf("%5s %s", board.getElement(row, col), "|");
            }
            System.out.printf("%n %4s %s"," ", "--------------------------------------------------");
        }
    }

    public static void clear() {}

}
