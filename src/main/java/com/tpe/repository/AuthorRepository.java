package com.tpe.repository;

import com.tpe.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class AuthorRepository implements BaseRepository<Author> {

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Author findById(long id) {
        return null;
    }

    @Override
    public Author save(Author entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Author entity) {

    }
}
