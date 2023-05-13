package com.tpe.service;

import com.tpe.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    Member findMemberById(Long id);

    void saveMember(Member member);

    void updateMember(Member member);

    void deleteMember(Long id);
}
