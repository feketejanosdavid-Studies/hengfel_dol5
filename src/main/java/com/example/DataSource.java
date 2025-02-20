package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String URL = "jdbc:mariadb://localhost:3306/hengfeldb";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public void addCalculation(Calculations calc) {
        String sql = "INSERT INTO calcs (height, radius, surface) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, calc.getHeight());
            pstmt.setDouble(2, calc.getRadius());
            pstmt.setDouble(3, calc.getSurface());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Calculations> getAllCalculations() {
        List<Calculations> calculations = new ArrayList<>();
        String sql = "SELECT height, radius, surface FROM calcs";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                double height = rs.getDouble("height");
                double radius = rs.getDouble("radius");
                double surface = rs.getDouble("surface");

                calculations.add(new Calculations(height, radius, surface));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calculations;
    }
}
