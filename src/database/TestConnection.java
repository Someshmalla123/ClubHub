package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clubhub",
                    "root",
                    "Someshmalla@90"
            );

            if (conn != null) {
                System.out.println("✅ JDBC Connected Successfully!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Connection Failed!");
            System.out.println(e.getMessage());
        }
    }
}