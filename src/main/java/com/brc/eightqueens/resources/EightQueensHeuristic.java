package com.brc.eightqueens.resources;

import java.util.Arrays;
import java.util.Comparator;


public final class EightQueensHeuristic extends Heuristic{
    
    public EightQueensHeuristic() {
        super(HeuristicType.EIGHT_QUEENS);
    }
    
    public static boolean anyAtTheSameRow(Queen... queens) {
        int nextQueenRow;
        int currentQueenRow;
        int i = 0;
        while(i < queens.length - 1) {
            currentQueenRow = queens[i].position.getCurrentRow();
            nextQueenRow = queens[i+1].position.getCurrentRow();

            if (currentQueenRow != nextQueenRow) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static boolean anyAtTheSameCol(Queen... queens) {
        boolean areAtTheSameCol = true;
        int i = 0;
        while(areAtTheSameCol && i < queens.length - 1) {
            int currentQueenCol = queens[i].position.getCurrentCol();
            int nextQueenCol = queens[i+1].position.getCurrentCol();

            if(currentQueenCol != nextQueenCol) {
                areAtTheSameCol = false;
            }
            i++;
        }
        return areAtTheSameCol;
    }

    public static boolean anyAtTheSameDiagonal(ChessBoard board, Queen... queens) {
        
        //How it will be done: (MY THOUGHTS)
        //1. Take the first queen. 
        //2. Get all of it's diagonal houses. "\"(main) diagonal and "/"(secondary) diagonal.
        //3. Check if the next queens current row and current col are inserted in any of these pos.
        //4. If any queen is inserted in the diagonal houses, then at least 1 queen can attack another. Will immediatly return true.
        //5. If, after all iterations, no queen was found at the queen[0] diagonal, then will return false. No attacks are possible.

        /*
         * I don't know if that's what you are looking for: 
            Main diagonal, every element that is above the selected index: row-1,column-1 until you hit an edge
            Main diagonal, every element that is below the selected index: row+1,column+1 until you hit an edge
            For the secondary diagonal:
            row-1,column+1 everything above
            row+1,column-1 everything below
         */
        final int FIRST_QUEEN_ROW = queens[0].position.getCurrentRow();
        final int FIRST_QUEEN_COL = queens[0].position.getCurrentCol();
        final int BOARD_SIZE = board.getBoardSize();
        int mainDiagRowStartingPoint;
        int mainDiagColStartingPoint;
        int secondaryDiagFirstRowStartingPoint = queens[0].position.getCurrentRow();
        int secondaryDiagFirstColStartingPoint = queens[0].position.getCurrentCol();
        int[][] firstQueenMainDiagonalIndexes = new int[8][2]; // {x,x} <- house 1 {x,x} <- house 2 
        int[][] firstQueenSecondaryDiagonalAboveIndexes = new int[8][2]; // {x,x} <- house 1 {x,x} <- house 2
        int[][] firstQueenSecondaryDiagonalBelowIndexes = new int[8][2]; // {x,x} <- house 1 {x,x} <- house 2
        int[] currentQueenPos = new int[2];
        

        if (FIRST_QUEEN_ROW < FIRST_QUEEN_COL) {
            // {0, j-i}
            mainDiagRowStartingPoint = 0;
            mainDiagColStartingPoint = FIRST_QUEEN_COL - FIRST_QUEEN_ROW;
        }
        else if (FIRST_QUEEN_ROW > FIRST_QUEEN_COL) {
            // {i-j, 0}
            mainDiagRowStartingPoint = FIRST_QUEEN_ROW - FIRST_QUEEN_COL;
            mainDiagColStartingPoint = 0;
        }
        else {
            mainDiagRowStartingPoint = 0;
            mainDiagColStartingPoint = 0;
        }


        //Generate main diagonal
        for (int i = 0; i < 8 && mainDiagRowStartingPoint < BOARD_SIZE && mainDiagColStartingPoint < BOARD_SIZE; i++) {
            firstQueenMainDiagonalIndexes[i][0] = mainDiagRowStartingPoint++;
            firstQueenMainDiagonalIndexes[i][1] = mainDiagColStartingPoint++;
        }


        //Generate secondary diagonal above
        for (int i = 0; i < 8; i++){
            if (secondaryDiagFirstRowStartingPoint < 0 || secondaryDiagFirstColStartingPoint < 0) {
                break;
            }
            firstQueenSecondaryDiagonalAboveIndexes[i][0] = secondaryDiagFirstRowStartingPoint--;
            firstQueenSecondaryDiagonalAboveIndexes[i][1] = secondaryDiagFirstColStartingPoint++;
        }


        secondaryDiagFirstRowStartingPoint = queens[0].position.getCurrentRow();
        secondaryDiagFirstColStartingPoint = queens[0].position.getCurrentCol();


        //Generate secondary diagonal below
        for (int i = 0; i < 8; i++){
            if (secondaryDiagFirstRowStartingPoint > BOARD_SIZE - 1 || secondaryDiagFirstColStartingPoint > BOARD_SIZE - 1) {
                break;
            }
            firstQueenSecondaryDiagonalBelowIndexes[i][0] = secondaryDiagFirstRowStartingPoint++;
            firstQueenSecondaryDiagonalBelowIndexes[i][1] = secondaryDiagFirstColStartingPoint--;
        }


        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // Compare the first element of the arrays
                return Integer.compare(arr1[0], arr2[0]);
            }
        };



        //Verify if any Queen is in the first's main diagonal        
        for (Queen queen: queens) {
            currentQueenPos[0] = queen.position.getCurrentRow();
            currentQueenPos[1] = queen.position.getCurrentCol();
            for (int i = 0; i < firstQueenMainDiagonalIndexes.length; i++) {
                if (Arrays.binarySearch(firstQueenMainDiagonalIndexes, currentQueenPos, comparator) > -1) {
                    return true;
                }
            }
        }


        //Verify if any Queen is in the first's secondary diagonal ABOVE and BELOW
        for (Queen queen : queens) {
            currentQueenPos[0] = queen.position.getCurrentRow();
            currentQueenPos[1] = queen.position.getCurrentCol();
            for (int i = 0; i < firstQueenSecondaryDiagonalAboveIndexes.length; i++) {
                if (Arrays.binarySearch(firstQueenSecondaryDiagonalAboveIndexes, currentQueenPos, comparator) > -1 || Arrays.binarySearch(firstQueenSecondaryDiagonalBelowIndexes, currentQueenPos, comparator) > -1) {
                    return true;
                }
            }
            
        }


        return false;
        
    }

    public static boolean canAttackAny(ChessBoard board, Queen... queens) {
        return anyAtTheSameRow(queens) || anyAtTheSameCol(queens) || anyAtTheSameDiagonal(board, queens);
    }

}
