package com.tpe.controller;

import com.tpe.domain.Author;
import com.tpe.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/new")
    public String sendAuthorForm(@ModelAttribute("author") Author author) {
        return "authorForm";
    }

    @PostMapping("/saveAuthor")
    public String createAuthor(@ModelAttribute Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping
    public ModelAndView getAuthors(){
        List<Author> list = authorService.getAllAuthor();
        ModelAndView mav = new ModelAndView();
        mav.addObject("authors",list);
        mav.setViewName("authors");
        return mav;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute(author);
        return "authorForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
