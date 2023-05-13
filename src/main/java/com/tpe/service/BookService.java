package com.tpe.service;

import com.tpe.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book findBookById(Long id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}
