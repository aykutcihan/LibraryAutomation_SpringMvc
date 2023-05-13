package com.tpe.repository;

import com.tpe.domain.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepositoryImpl implements LoanRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Loan> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Loan> listOfLoans = session.createQuery("FROM Loan", Loan.class).getResultList();
        tx.commit();
        session.close();
        return listOfLoans;
    }

    @Override
    public Optional<Loan> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Loan loan = session.get(Loan.class, id);
        Optional<Loan> opt = Optional.ofNullable(loan);
        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Loan loan) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(loan);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Loan loan) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(loan);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Loan loan = session.load(Loan.class, id);
        session.delete(loan);
        tx.commit();
        session.close();
    }
}
