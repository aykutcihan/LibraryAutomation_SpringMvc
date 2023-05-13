package com.tpe.service;

import com.tpe.domain.Member;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Override
    public List<Member> getAllMembers() {
        return repository.getAll();
    }

    @Override
    public Member findMemberById(Long id) {
        Member member = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("İstenilen id'li Member objesi bulunamadı : " + id));
        return member;
    }

    @Override
    public void saveMember(Member member) {
        repository.save(member);
    }

    @Override
    public void updateMember(Member member) {
        repository.update(member);
    }

    @Override
    public void deleteMember(Long id) {
        repository.delete(id);
    }
}
