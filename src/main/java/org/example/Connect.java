package org.example;

import java.sql.*;

public class Connect {

    Connection connection;
    Statement statement;
    public Connect(){
        try {
           connection = DriverManager.getConnection
                   ("jdbc:mysql://localhost:3306/atmsystem", "root", "root123");
           statement = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
