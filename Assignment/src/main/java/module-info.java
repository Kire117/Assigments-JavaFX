module com.example.assignment3javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.assignment3javafx to javafx.fxml;
    exports com.example.assignment3javafx;
}