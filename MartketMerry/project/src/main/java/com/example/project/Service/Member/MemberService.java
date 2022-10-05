package com.example.project.Service.Member;

import com.example.project.Entity.Member.Member;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {


    void insertMember(Member member);

    void updateMember(Member member);

    public Map<String, String> member_Availability(Errors errors);

    void deleteMember(Member member);

    public Member getMember(Member member);

    Member getMemberWhereId(String memberId);

}
