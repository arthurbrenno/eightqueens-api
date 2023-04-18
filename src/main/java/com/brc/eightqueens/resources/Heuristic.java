package com.brc.eightqueens.resources;

public abstract class Heuristic {
    private HeuristicType type;
    private int[][] acessibility;

    public Heuristic(HeuristicType type) {
        this.type = type;
    }

}
