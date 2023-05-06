package com.tpe.controller;

import com.tpe.domain.Author;
import com.tpe.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable long id, @RequestBody Author author) {
        authorService.update(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.delete(id);
    }
}
