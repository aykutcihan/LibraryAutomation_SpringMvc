package com.tpe.repository;

import com.tpe.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    List<Member> getAll();

    Optional<Member> findById(Long id);

    void save(Member member);

    void update(Member member);

    void delete(Long id);
}
