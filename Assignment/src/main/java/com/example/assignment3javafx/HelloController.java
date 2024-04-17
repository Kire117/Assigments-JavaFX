package com.example.assignment3javafx;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;




public class HelloController {
    @FXML
    private Label results;
    @FXML
    private TextField userValue;
    @FXML
    private RadioButton rb1, rb2, rb3, rb4;

    @FXML
    protected void getConvertion() {
        ToggleGroup radioGroup = new ToggleGroup();
        rb1.setToggleGroup(radioGroup);
        rb2.setToggleGroup(radioGroup);
        rb3.setToggleGroup(radioGroup);
        rb4.setToggleGroup(radioGroup);

        if (rb1.isSelected()) {
            String userInput = userValue.getText();
            //calculate kg
            double kgValue = Convertion.convertLBtoKG(Double.parseDouble(userInput));
            results.setText(kgValue + " kg");
        }
        else if (rb2.isSelected()) {
            String userInput = userValue.getText();
            // calculate lb
            double lbValue = Convertion.convertKGtoLB(Double.parseDouble(userInput));
            results.setText(lbValue + " lb");
        }
        else if (rb3.isSelected()) {
            String userInput = userValue.getText();
            // calculate celsius
            double FahValue = Convertion.convertFAHtoCEL(Double.parseDouble(userInput));
            results.setText(FahValue + " Celsius");
        }
        else if (rb4.isSelected()) {
            String userInput = userValue.getText();
            // calculate fahrenheit
            double CelValue = Convertion.convertCELtoFAH(Double.parseDouble(userInput));
            results.setText(CelValue + " Fahrenheit");
        }
    }
}