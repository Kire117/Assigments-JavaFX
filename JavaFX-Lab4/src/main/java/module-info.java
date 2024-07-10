module com.example.javafxlab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlab4 to javafx.fxml;
    exports com.example.javafxlab4;
}