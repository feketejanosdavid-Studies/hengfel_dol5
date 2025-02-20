package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataSource {
    public ArrayList<Calculations> getCalculations() {
        try {
            return tryGetCalculations();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Calculations> tryGetCalculations() throws SQLException {
        Mariadb mariadb = new Mariadb();
        Connection conn = mariadb.connect();
        if (conn != null) {
            String sql = "SELECT * FROM hengfeldb";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Calculations> calculations = new ArrayList<Calculations>();
            while (rs.next()) {
                Calculations calc = new Calculations();
                calc.id = rs.getInt("id");
                calc.height = rs.getDouble("height");
                calc.radius = rs.getDouble("radius");
                calc.surface = rs.getDouble("surface");
                calculations.add(calc);
            }
            return calculations;
        }
        return null;
    }

    public void addCalculation(Calculations e) {
        try {
            tryAddCalculation(e);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void tryAddCalculation(Calculations calc) throws SQLException {
        Mariadb mariadb = new Mariadb();
        Connection conn = mariadb.connect();
        if (conn != null) {
            String sql = "INSERT INTO hengfeldb (height, radius, surface)"+ "VALUES ('"+ calc.height + "', '" + calc.radius + "', '" + calc.surface + "')";
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
        }
    }
}
