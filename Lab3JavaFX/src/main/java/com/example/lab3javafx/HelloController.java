package com.example.lab3javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    public Label outputLabel;

    @FXML
    public TextField inputUser;
    public TextField inputPhone;
    public TextField inputPc;

    public void onsubmitButtonClicked() {
        String text1 = inputUser.getText();
        String text2 = inputPhone.getText();
        String text3 = inputPc.getText();
        Pattern pattern = Pattern.compile("[A-Za-z0-9._-]+");
        Pattern pattern1 = Pattern.compile("\\(?([2-9]\\d{2})\\)?[-.\\s]?([2-9]\\d{2})[-.\\s]?(\\d{4})");
        Pattern pattern2 = Pattern.compile("\\w{3}\\s?\\w{3}");
        Matcher matcher = pattern.matcher(text1);
        Matcher matcher1 = pattern1.matcher(text2);
        Matcher matcher2 = pattern2.matcher(text3);
        StringBuilder matches = new StringBuilder();
        if (matcher.find()) {
            matches.append("User: ").append(matcher.group()).append('\n');
        } else {
            matches.append("User: No match\n");
        }
        if (matcher1.find()) {
            matches.append("Phone: ").append(matcher1.group()).append('\n');
        } else {
            matches.append("Phone: No match\n");
        }

        if (matcher2.find()) {
            matches.append("PC: ").append(matcher2.group()).append('\n');
        } else {
            matches.append("PC: No match\n");
        }
        outputLabel.setText(matches.toString());
    }



}