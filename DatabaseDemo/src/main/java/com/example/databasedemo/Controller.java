package com.example.databasedemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    @FXML
    public Label student_name;
    public Label student_age;
    public Label student_id;

    public void connectBtn(ActionEvent actionEvent){
        DatabaseConnectivity connect = new DatabaseConnectivity();
        Connection connectDB = connect.getConnection();
        if (connectDB != null){
           String StdTable_Query = "SELECT * FROM student";
           try {
               Statement statement = connectDB.createStatement();
               ResultSet queryOutput = statement.executeQuery(StdTable_Query);
               while(queryOutput.next()){
                   student_name.setText(queryOutput.getString("student_name"));
                   student_age.setText(queryOutput.getString("student_age"));
                   student_id.setText(queryOutput.getString("student_id"));
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        }else {
            System.out.println("Error connecting to the database");
        }
    }
}
