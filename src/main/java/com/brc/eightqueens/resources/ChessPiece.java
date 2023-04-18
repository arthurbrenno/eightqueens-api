package com.brc.eightqueens.resources;

public class ChessPiece {
    private PieceType type;
    protected Position position = new Position();

    public ChessPiece(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return this.type;
    }

    public String getTypeString() {
        return type.toString();
    }
    
}
