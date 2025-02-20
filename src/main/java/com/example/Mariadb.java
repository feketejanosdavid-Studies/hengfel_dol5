package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mariadb {
    public Connection connect() {
        try {
            return tryConnect();
        } catch (Exception e) {
            System.err.println("database connection error");
            System.err.println(e.getMessage());
            return null;
        }

        
    }
    private Connection tryConnect() throws SQLException {
        String user = "root";
        String password = "admin";
        String url = "jdbc:mariadb://localhost:3306/hengfeldb";
        return DriverManager.getConnection(url, user, password);
    }
}
