package com.tpe.repository;

import com.tpe.domain.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Member> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Member> listOfMembers = session.createQuery("FROM Member", Member.class).getResultList();
        tx.commit();
        session.close();
        return listOfMembers;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Member member = session.get(Member.class, id);
        Optional<Member> opt = Optional.ofNullable(member);
        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Member member) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(member);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Member member) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(member);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Member member = session.load(Member.class, id);
        session.delete(member);
        tx.commit();
        session.close();
    }
}
