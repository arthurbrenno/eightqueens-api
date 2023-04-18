package com.brc.eightqueens.resources;

public class Position {
    private int currentRow;
    private int currentCol;

    public int getCurrentRow() {
        return this.currentRow;
    }
    public int getCurrentCol() {
        return this.currentCol;
    }
    public void setCurrentRow(int row) {
        this.currentRow = row;
    }
    public void setCurrentCol(int col) {
        this.currentCol = col;
    }
    public void setNewPosition(int row, int col) {
        this.currentRow = row;
        this.currentCol = col;
    }
}
