package com.tpe.service;

import com.tpe.domain.Member;
import com.tpe.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("memberService")
@Scope("prototype")
public class MemberService implements BaseService<Member>{

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(@Qualifier("memberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(long id) {
        memberRepository.delete(id);
    }

    @Override
    public void update(Member member) {
        memberRepository.update(member);
    }
}
