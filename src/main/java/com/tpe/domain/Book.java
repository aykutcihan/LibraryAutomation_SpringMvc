package com.tpe.domain;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String title;
    private Author author;
    private String publisher;
    private LocalDate publicationDate;

    public Book() {
        this.publicationDate = LocalDate.now();
    }

    public Book(Long id, String title, Author author, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = LocalDate.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
