package org.example;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class Connect {

    Connection connection;
    Statement statement;
    public Connect(){
        try {
           connection = DriverManager.getConnection
                   ("jdbc:mysql://localhost:3306", "root", "root123");
           statement = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
