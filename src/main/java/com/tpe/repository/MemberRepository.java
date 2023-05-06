package com.tpe.repository;

import com.tpe.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MemberRepository implements BaseRepository <Member> {

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
