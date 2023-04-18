package com.brc.eightqueens.resources;

public class ChessBoard extends Board{
    private Coordinates coordinates;


    public ChessBoard(int boardSize) {
        super(boardSize);
    }

    public ChessBoard(int boardSize, String fillCharacter) {
        super(boardSize, fillCharacter);
    }

    
    public void setElement(ChessPiece piece, int row, int col) {
        String pieceSymbol = piece.toString();
        super.setElement(pieceSymbol, row, col);
    }

}
