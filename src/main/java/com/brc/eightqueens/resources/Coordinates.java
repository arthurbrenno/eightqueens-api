package com.brc.eightqueens.resources;

public class Coordinates {
    private final char[] HORIZONTAL_COORDINATES = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private final int[] VERTICAL_COORDINATES = {8, 7, 6, 5, 4, 3, 2, 1};

    public char[] getHorizontal() {
        return this.HORIZONTAL_COORDINATES;
    }
    
    public int[] getVertical(){
        return this.VERTICAL_COORDINATES;
    }
    
}
