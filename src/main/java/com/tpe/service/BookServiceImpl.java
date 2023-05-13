package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.getAll();
    }

    @Override
    public Book findBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("İstenilen id'li Book objesi bulunamadı : " + id));
        return book;
    }

    @Override
    public void saveBook(Book book) {
        repository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        repository.update(book);
    }

    @Override
    public void deleteBook(Long id) {
        repository.delete(id);
    }
}
