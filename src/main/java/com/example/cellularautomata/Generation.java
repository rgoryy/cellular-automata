package com.example.cellularautomata;

import java.util.Random;

public class Generation {
    private Cell[] cells;
    private Rule rule;

    public Generation(Rule rule, int size) {
        this.rule = rule;
        this.cells = new Cell[size];

        cells[0] = new Cell(false);
        cells[cells.length - 1] = new Cell(false);

        for (int i = 1; i < cells.length - 1; i++) {
            cells[i] = new Cell(new Random().nextBoolean());
        }
    }

    public Generation(Cell[] cells, Rule rule) {
        this.cells = cells;
        this.rule = rule;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public Generation nextGeneration() {
        Cell[] nextCells = new Cell[cells.length];

        nextCells[0] = new Cell(false);
        nextCells[cells.length - 1] = new Cell(false);

        for (int i = 1; i < cells.length - 1; i++) {
            Cell leftNeighbor = cells[i - 1];
            Cell rightNeighbor = cells[i + 1];
            Cell currentCell = cells[i];
            Cell nextCell = rule.getNextCell(currentCell, rightNeighbor, leftNeighbor);
            nextCells[i] = nextCell;
        }

        cells = nextCells;

        return new Generation(nextCells, rule);
    }

    public void printGeneration() {
        for (Cell cell : cells) {
            System.out.print(cell.isAlive() ? "1" : "0");
        }
        System.out.println();
    }
}
