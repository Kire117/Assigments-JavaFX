    package com.example.lab_05_javafx;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("LAB 05 JAVA FX!");

        Button button = new Button("Click me to parse JSON");
        button.setOnAction(e -> parseJSON());

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox, 200, 200);

        stage.setScene(scene);
        stage.show();
    }
    public void parseJSON() {
        String jsonString = "{\"ProductID\":0117,\"ProductName\":\"Protein\",\"OrderDate\":\"2024/03/13\",\"Manufacturer\":\"Elian\"}";
        //create an instance for GSON
        Gson gson = new Gson();
         //parse the json to the java object
        Product product = gson.fromJson(jsonString, Product.class);
        System.out.println("Product ID: "+product.ProductID);
        System.out.println("Product Name: "+product.ProductName);
        System.out.println("Order Date: "+product.OrderDate);
        System.out.println("Manufacturer: "+product.Manufacturer);

        //convert java object to string
        String jsonOutput = gson.toJson(product);
        System.out.println("The output for JSON "+ jsonOutput);
    }
}

