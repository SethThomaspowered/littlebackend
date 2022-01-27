package com.example.littlebackend.controller;

import com.example.littlebackend.model.Book;
import com.example.littlebackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    // http://localhost:9092/api/books
    @GetMapping("/books")
    public List<Book> getBooks() {
        LOGGER.info("calling getBooks method from controller");

        return bookService.getBooks();
    }

    //     http://localhost:9092/api/books/1
    @GetMapping(path = "/books/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        LOGGER.info("calling getBook method from controller");
        return bookService.getBook(bookId);
    }
    //      http://localhost:9092/api/books/1
    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody Book bookObject){
        LOGGER.info("calling updateBook method from controller");
        return bookService.updateBook(bookId, bookObject);
    }
    //      http://localhost:9092/api/books/1
    @DeleteMapping(path = "/books/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookId){
        LOGGER.info("calling deleteBook method from controller");
        return bookService.deleteBook(bookId);
    }
}
