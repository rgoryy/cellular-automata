package com.example.cellularautomata;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField rule;
    private Generation currentGeneration;
    private SequentialTransition sequentialTransition;

    @FXML
    void onStartStopButtonClick(MouseEvent event) {
        gridPane.getChildren().clear();

        if (sequentialTransition != null) {
            sequentialTransition.stop();
        }

        sequentialTransition = new SequentialTransition();

        try {
            int size = gridPane.getColumnCount();
            Rule r = new Rule(Byte.parseByte(rule.getText()));

            currentGeneration = new Generation(r, size);
            drawGeneration(currentGeneration, 0);

            for (int i = 1; i < gridPane.getRowCount(); i++) {
                PauseTransition pause = new PauseTransition(Duration.millis(100));
                int finalI = i;
                pause.setOnFinished(event1 -> {
                    currentGeneration = currentGeneration.nextGeneration();
                    drawGeneration(currentGeneration, finalI);
                });
                sequentialTransition.getChildren().add(pause);
            }
            sequentialTransition.play();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid rule format: " + rule.toString());
        }
    }

    private void drawGeneration(Generation generation, int rowIndex) {
        Cell[] cells = generation.getCells();
        for (int i = 0; i < cells.length; i++) {
            drawCell(cells[i], i, rowIndex);
        }
    }

    private void drawCell(Cell cell, int i, int rowIndex) {
        char cellState = cell.isAlive() ? '1' : '0';
        gridPane.add(new CellVisualizer(cellState, 10, 10), i, rowIndex);
    }
}