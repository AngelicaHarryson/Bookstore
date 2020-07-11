package com.example.bookservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
     private BookRepository bookRepository;


    @GetMapping("/book")
    public List<Book> bookList() {
        return (List<Book>)bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book book (@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/book")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public Book put(@PathVariable Long id, @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void delete (@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
