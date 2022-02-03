package com.example.littlebackend.controller;

import com.example.littlebackend.model.Book;
import com.example.littlebackend.model.Comment;
import com.example.littlebackend.model.GBBook;
import com.example.littlebackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api/")
@CrossOrigin(origins = "https://liddleoxfordlibrary.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
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
    // http://localhost:9092/api/books/1/gbbooks
    @PostMapping(path = "/gbbooks")
    public GBBook addGBBook(@RequestBody GBBook gBBookObject) {
        LOGGER.info("calling addGBBook method from controller");
        return bookService.addGBBook(gBBookObject);
    }

    @GetMapping(path = "/gbbooks")
    public List<GBBook> getGBBooks(){
        LOGGER.info("calling get Google Books from controller");
        return bookService.getGBBookList();
    }
//         http://localhost:9092/api/gbbooks/{gbbookId}
    @GetMapping(path = "/gbbooks/{gBBookId}")
    public GBBook getGBBook(@PathVariable(value = "gBBookId") Long gBBookId) {
        LOGGER.info("calling getGBBBook method from controller");
        return bookService.getGBBook(gBBookId);
    }
    //      http://localhost:9092/api/gbbooks/{gbbookId}
    @PutMapping(path = "/gbbooks/{bookId}")
    public GBBook updateGBBook(@PathVariable(value = "bookId") Long bookId,
                               @RequestBody GBBook bookObject){
        LOGGER.info("calling updateGBBook method from controller");
        return bookService.updateGBBook(bookId, bookObject);
    }
    @DeleteMapping(path = "/gbbooks/{gBBookId}")
    public String deleteGBBook(@PathVariable(value = "gBBookId") Long gBBookId){
        LOGGER.info("calling deleteGBBook method from controller");
        return bookService.deleteGBBook(gBBookId);
    }
    @PostMapping(path="/gbbooks/{gBBookId}/comments")
    public Comment postComment(@PathVariable(value = "gBBookId") Long gBBookId, @RequestBody Comment commentObject){
        LOGGER.info("calling postComment method from controller");
        return bookService.postComment(gBBookId, commentObject);
    }
     @GetMapping(path="/gbbooks/1/comments")
    public List<Comment> getComments(){
        LOGGER.info("calling getComments method from controller");
        return bookService.getComments();
     }

}
