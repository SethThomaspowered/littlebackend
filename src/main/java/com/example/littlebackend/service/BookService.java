package com.example.littlebackend.service;

import com.example.littlebackend.exception.InformationExistsException;
import com.example.littlebackend.exception.InformationNotFoundException;
import com.example.littlebackend.model.Book;
import com.example.littlebackend.repository.BookRepository;
//import com.example.littlebackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
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
    public List<Book> getBooks(){
        LOGGER.info("calling getPlaylists method from service");

        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            throw new InformationNotFoundException("No playlists are listed for this user");
        }else{
            return books;
        }
    }
    public Optional<Book> getBook(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + bookId + " not found");
        } else{
            return book;
        }
    }
}
