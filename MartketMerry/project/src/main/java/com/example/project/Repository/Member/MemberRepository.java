package com.example.project.Repository.Member;

import com.example.project.Entity.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {

    //아이디 찾기 = 중복, 회원 아이디 찾기에도 사용됨
    @Query(value = "select m from Member m where m.memberId = :memberId")
    Member findMemberById(String memberId);




}
