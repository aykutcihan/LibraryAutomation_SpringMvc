package com.tpe.repository;

import com.tpe.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public class BookRepository implements BaseRepository<Book> {
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Book entity) {

    }
}
