package com.tpe.repository;

import com.tpe.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAll();

    Optional<Book> findById(Long id);

    void save(Book book);

    void update(Book book);

    void delete(Long id);
}
