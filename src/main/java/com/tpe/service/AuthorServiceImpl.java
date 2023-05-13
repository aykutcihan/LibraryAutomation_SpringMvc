package com.tpe.service;

import com.tpe.domain.Author;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAllAuthor() {
        return repository.getAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        Author author = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("İstenilen id'li Author objesi bulunamadı : " + id));
        return author;
    }

    @Override
    public void saveAuthor(Author author) {
        repository.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        repository.update(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.delete(id);
    }
}
