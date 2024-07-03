module com.example.lab3javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab3javafx to javafx.fxml;
    exports com.example.lab3javafx;
}