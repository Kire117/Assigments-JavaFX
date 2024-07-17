module com.example.lab_05_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.lab_05_javafx to javafx.fxml;
    exports com.example.lab_05_javafx;
}