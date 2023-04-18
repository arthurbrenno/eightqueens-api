package com.brc.eightqueens.resources;

import java.security.SecureRandom;

public class EQTerminalApplication {

    private final SecureRandom RANDOM = new SecureRandom();
    private final int BOARD_SIZE = 8;
    ChessBoard board = new ChessBoard(BOARD_SIZE);
    Queen queenOne = new Queen();
    Queen queenTwo = new Queen();

    public void run() {
        queenOne.position.setCurrentRow(3);
        queenOne.position.setCurrentCol(3);
        queenTwo.position.setCurrentCol(3);
        queenTwo.position.setCurrentCol(5);
        

        board.setElement(queenOne, queenOne.position.getCurrentRow(), queenOne.position.getCurrentCol());
        board.setElement(queenTwo, queenTwo.position.getCurrentRow(), queenTwo.position.getCurrentCol());
        
        
        System.out.println(EightQueensHeuristic.anyAtTheSameRow(queenOne, queenTwo));
    }

}
