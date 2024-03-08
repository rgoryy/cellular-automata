package com.example.cellularautomata;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane p = new GridPane();

        Generation g = new Generation((byte) 110);

        int numOfGenerations = 10;

        Rectangle[][] board = new Rectangle[numOfGenerations][10];

        for (int i = 0; i < numOfGenerations; i++) {
            for (int j = 0; j < 10; j++) {

                board[i][j] = new Rectangle();
                if ()
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = new Cell();
            }
        }

        Scene scene = new Scene(root);
        primaryStage.setTitle("Клеточный 1D автомат");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}