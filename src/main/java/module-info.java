module com.example.cellularautomata {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cellularautomata to javafx.fxml;
    exports com.example.cellularautomata;
}