package service;

import dao.MemberDAO;
import model.Member;
import java.util.ArrayList;

public class MemberService {

    private MemberDAO memberDAO = new MemberDAO();

    public String addMember(Member member) {

        if (memberDAO.usernameExists(member.getUsername())) {
            return "Username already exists.";
        }

        if (memberDAO.addMember(member)) {
            return "SUCCESS";
        }

        return "Database error.";
    }
    
    public ArrayList<Member> getAllMembers() {

    return memberDAO.getAllMembers();

}
}