package com.tpe.service;

import com.tpe.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    Author findAuthorById(Long id);

    void saveAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Long id);
}
