package dao;

import database.DBConnection;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    public boolean addMember(Member member) {

        String sql = "INSERT INTO members(full_name, email, phone, position, username, password) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, member.getFullName());
            pst.setString(2, member.getEmail());
            pst.setString(3, member.getPhone());
            pst.setString(4, member.getPosition());
            pst.setString(5, member.getUsername());
            pst.setString(6, member.getPassword());

            int rowsInserted = pst.executeUpdate();

            conn.close();

            return rowsInserted > 0;

        } catch (SQLException e) {

            System.out.println("Add Member Error: " + e.getMessage());

            return false;
        }
    }
}