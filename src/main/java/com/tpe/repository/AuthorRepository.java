package com.tpe.repository;

import com.tpe.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<Author> getAll();

    Optional<Author> findById(Long id);

    void save(Author author);

    void update(Author author);

    void delete(Long id);
}
