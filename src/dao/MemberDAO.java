package dao;

import database.DBConnection;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public boolean usernameExists(String username) {

    String sql = "SELECT * FROM members WHERE username = ?";

    try {
        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, username);

        ResultSet rs = pst.executeQuery();

        boolean exists = rs.next();

        conn.close();

        return exists;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;
    }

}
    
    public ArrayList<Member> getAllMembers() {

    ArrayList<Member> memberList = new ArrayList<>();

    String sql = "SELECT * FROM members";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Member member = new Member();

            member.setMemberId(rs.getInt("member_id"));
            member.setFullName(rs.getString("full_name"));
            member.setEmail(rs.getString("email"));
            member.setPhone(rs.getString("phone"));
            member.setPosition(rs.getString("position"));
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));

            memberList.add(member);

        }

        conn.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return memberList;

}
    
    public boolean updateMember(Member member) {

    String sql = "UPDATE members SET full_name=?, email=?, phone=?, position=?, username=?, password=? WHERE member_id=?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, member.getFullName());
        pst.setString(2, member.getEmail());
        pst.setString(3, member.getPhone());
        pst.setString(4, member.getPosition());
        pst.setString(5, member.getUsername());
        pst.setString(6, member.getPassword());
        pst.setInt(7, member.getMemberId());

        int rowsUpdated = pst.executeUpdate();

        conn.close();

        return rowsUpdated > 0;

    } catch (Exception e) {

        System.out.println("Update Error: " + e.getMessage());

        return false;
    }
}
}