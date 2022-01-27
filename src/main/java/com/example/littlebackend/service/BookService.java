package com.example.littlebackend.service;

import com.example.littlebackend.exception.InformationExistsException;
import com.example.littlebackend.model.Book;
import com.example.littlebackend.repository.BookRepository;
//import com.example.littlebackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Service
public class BookService {
    private BookRepository bookRepository;
    private static final Logger LOGGER=Logger.getLogger(BookService.class.getName());
    @Autowired
    public void setBookRepository(BookRepository bookRepository){ this.bookRepository=bookRepository; }
    public Book addBook(@RequestBody Book bookObject){
        LOGGER.info("calling addBook from service");

        Book book = bookRepository.findByBookTitle(bookObject.getBookTitle());
        if (book != null) {
            throw new InformationExistsException("Book with title " + book.getBookTitle() + " already exists");
        } else {
            return bookRepository.save(bookObject);
        }
    }
}
