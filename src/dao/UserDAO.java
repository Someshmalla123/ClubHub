package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public String validateUser(String username, String password) {

        String role = null;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT role FROM users WHERE username=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");
            }

        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }

        return role;
    }
}