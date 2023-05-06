package com.tpe.service;


import com.tpe.domain.Author;
import com.tpe.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component( "authorService")
@Scope("prototype" )
public class AuthorService implements BaseService<Author> {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(@Qualifier("authorRepository") AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(long id) {
        authorRepository.delete(id);

    }

    @Override
    public void update(Author author) {
        authorRepository.update(author);

    }
}
