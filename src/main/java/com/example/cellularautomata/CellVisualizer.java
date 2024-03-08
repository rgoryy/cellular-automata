package com.example.cellularautomata;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellVisualizer extends StackPane {
    public CellVisualizer(char state, double width, double height) {
        Rectangle cellRectangle = new Rectangle(width, height);
        cellRectangle.setFill(state == '1' ? Color.BLACK : Color.WHITE);
        cellRectangle.setStroke(Color.GRAY);
        getChildren().add(cellRectangle);
    }
}
