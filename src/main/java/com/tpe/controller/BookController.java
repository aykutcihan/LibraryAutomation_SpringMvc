package com.tpe.controller;

import com.tpe.domain.Book;
import com.tpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/new")
    public String sendBookForm(@ModelAttribute("book") Book book) {
        return "bookForm";
    }

    @PostMapping("/saveBook")
    public String createBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping
    public ModelAndView getBooks(){
        List<Book> list = bookService.getAllBooks();
        ModelAndView mav = new ModelAndView();
        mav.addObject("books",list);
        mav.setViewName("books");
        return mav;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute(book);
        return "bookForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
