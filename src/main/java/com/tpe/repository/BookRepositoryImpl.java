package com.tpe.repository;

import com.tpe.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Book> listOfBooks = session.createQuery("FROM Book", Book.class).getResultList();
        tx.commit();
        session.close();
        return listOfBooks;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, id);
        Optional<Book> opt = Optional.ofNullable(book);
        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(book);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Book book = session.load(Book.class, id);
        session.delete(book);
        tx.commit();
        session.close();
    }
}
