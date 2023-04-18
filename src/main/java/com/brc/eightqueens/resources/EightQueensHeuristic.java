package com.brc.eightqueens.resources;



public final class EightQueensHeuristic extends Heuristic{
    
    public EightQueensHeuristic() {
        super(HeuristicType.EIGHT_QUEENS);
    }
    
    public static boolean areAtTheSameRow(Queen queenOne, Queen queenTwo) {
        return queenOne.position.getCurrentRow() == queenTwo.position.getCurrentRow();
    }

    public static boolean areAtTheSameCol(Queen queenOne, Queen queenTwo) {
        return queenOne.position.getCurrentCol() == queenTwo.position.getCurrentCol();
    }

    public static boolean areAtTheSameDiagonal(Queen queenOne, Queen queenTwo) {
        final int QUEEN_ONE_ROW = queenOne.position.getCurrentRow();
        final int QUEEN_ONE_COL = queenOne.position.getCurrentCol();
        final int QUEEN_TWO_ROW = queenTwo.position.getCurrentRow();
        final int QUEEN_TWO_COL = queenTwo.position.getCurrentCol();
        int deltaRow = Math.abs(QUEEN_ONE_ROW - QUEEN_TWO_ROW);
        int deltaCol = Math.abs(QUEEN_ONE_COL - QUEEN_TWO_COL); 
        return deltaRow == deltaCol;
    }

}
