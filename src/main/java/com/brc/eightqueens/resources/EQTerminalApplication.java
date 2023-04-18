package com.brc.eightqueens.resources;

import java.security.SecureRandom;

public class EQTerminalApplication {

    private final SecureRandom RANDOM = new SecureRandom();
    private final int BOARD_SIZE = 8;
    private final int QUEEN_AMOUNT = 8;
    private final String BOARD_FILL_CHARACTER = " ";

    ChessBoard board = new ChessBoard(BOARD_SIZE, BOARD_FILL_CHARACTER);
    Queen[] queens = new Queen[QUEEN_AMOUNT];

    public EQTerminalApplication() {
        for (int i = 0; i < queens.length; i++) {
            queens[i] = new Queen();
        }
    }

    public void run() {
        Terminal.display(board);
    }

}
