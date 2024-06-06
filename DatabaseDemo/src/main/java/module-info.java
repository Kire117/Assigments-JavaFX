module com.example.databasedemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.databasedemo to javafx.fxml;
    requires java.desktop;
    exports com.example.databasedemo;
}