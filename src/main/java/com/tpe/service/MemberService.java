package com.tpe.service;

import com.tpe.domain.Member;
import com.tpe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("memberService")
@Scope("prototype")
public class MemberService implements BaseService<Member>{

    private LoanRepository loanRepository;

    @Autowired
    public MemberService(@Qualifier("loanRepository") LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member findById(long id) {
        return null;
    }

    @Override
    public Member save(Member entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Member entity) {

    }
}
