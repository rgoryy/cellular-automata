package com.example.cellularautomata;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellView extends Rectangle {
    private Cell cell;

    public CellView(Cell cell, double width, double height) {
        super(width, height);
        this.cell = cell;
        setColor();
    }

    public void setColor() {
        if (cell.isAlive()) {
            setFill(Color.BLACK);
        } else {
            setFill(Color.WHITE);
        }
    }
}
