package com.tpe.repository;

import com.tpe.domain.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Author> listOfAuthors = session.createQuery("FROM Author", Author.class).getResultList();
        tx.commit();
        session.close();
        return listOfAuthors;
    }

    @Override
    public Optional<Author> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Author author = session.get(Author.class, id);
        Optional<Author> opt = Optional.ofNullable(author);
        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(author);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(author);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Author author = session.load(Author.class, id);
        session.delete(author);
        tx.commit();
        session.close();
    }
}
