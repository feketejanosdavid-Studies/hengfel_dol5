package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

private static final String URL = "jdbc:mysql://localhost:3306/hengfeldb";
    private static final String USER = "root";
    private static final String PASSWORD = "jelszo";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveToDatabase(double height, double radius, double surface) {
        String sql = "INSERT INTO henger_szamitasok (height, radius, surface) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, height);
            pstmt.setDouble(2, radius);
            pstmt.setDouble(3, surface);
            pstmt.executeUpdate();
            System.out.println("Saved succesfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
