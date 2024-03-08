package com.example.cellularautomata;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
