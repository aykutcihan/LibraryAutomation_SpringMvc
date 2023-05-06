package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookService")
@Scope("prototype")
public class BookService implements BaseService<Book>{

    private BookRepository bookRepository;

    @Autowired
    public BookService(@Qualifier("bookRepository") BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);

    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);

    }
}
