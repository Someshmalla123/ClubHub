package service;

import dao.MemberDAO;
import model.Member;

public class MemberService {

    private MemberDAO memberDAO = new MemberDAO();

    public boolean addMember(Member member) {

        return memberDAO.addMember(member);

    }

}