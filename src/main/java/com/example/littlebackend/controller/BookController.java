package com.example.littlebackend.controller;

import com.example.littlebackend.model.Book;
import com.example.littlebackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api/")
public class BookController {
    private BookService bookService;
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    @Autowired
    public void setBookService(BookService bookService){ this.bookService=bookService; }

    // http://localhost:9092/api/books
    @PostMapping(path = "/books")
    public Book addBook(@RequestBody Book bookObject) {
        LOGGER.info("calling createPlaylist method from controller");
        return bookService.addBook(bookObject);
    }
}
