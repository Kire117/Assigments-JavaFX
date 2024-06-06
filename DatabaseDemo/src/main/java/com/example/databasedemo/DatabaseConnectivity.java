package com.example.databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectivity {
    public Connection databaselink;

            public Connection getConnection(){
            String databaseName = "javafx_lab2";
            String databaseUser = "root";
            String databasePassword = "";
            String Url = "jdbc:mysql://localhost:3306/" + databaseName;

            try{
                databaselink = DriverManager.getConnection(Url, databaseUser, databasePassword);
            }catch (Exception e){
                e.printStackTrace();
            }
            return databaselink;
            }
}
