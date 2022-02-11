package com.example.littlebackend.service;

import com.example.littlebackend.exception.InformationExistsException;
import com.example.littlebackend.exception.InformationNotFoundException;
import com.example.littlebackend.model.*;
import com.example.littlebackend.repository.BookRepository;
//import com.example.littlebackend.security.MyUserDetails;
import com.example.littlebackend.repository.CommentRepository;
import com.example.littlebackend.repository.GBBookRepository;
import com.example.littlebackend.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookService {
    private BookRepository bookRepository;
    private GBBookRepository gBBookRepository;
    private LibraryRepository libraryRepository;
    private static final Logger LOGGER=Logger.getLogger(BookService.class.getName());
    @Autowired
    public void setBookRepository(BookRepository bookRepository){ this.bookRepository=bookRepository; }
    @Autowired
    public void setGBBookRepository(GBBookRepository gBBookRepository){ this.gBBookRepository= gBBookRepository;}
    private CommentRepository commentRepository;
    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }
    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository){ this.libraryRepository=libraryRepository;}
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
    public Book getBook(Long bookId) {

        Book book = bookRepository.findBookById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + bookId + " not found");
        } else{
            return book;
        }
    }
    public Book updateBook(Long bookId, Book bookObject) {
        LOGGER.info("service calling updateBook ==>");
        Book book = bookRepository.findBookById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + bookId + " not found");
        } else {
            if(bookObject.getBookTitle() != null){ book.setBookTitle(bookObject.getBookTitle());}
            if(bookObject.getDateAdded() != null) {
                book.setDateAdded(bookObject.getDateAdded());
            }
            if(bookObject.getGoogleBooksId() != null){
                book.setGoogleBooksId(bookObject.getGoogleBooksId());}
            return bookRepository.save(book);
        }
    }
    public String deleteBook(Long bookId) {
        LOGGER.info("service calling deleteBook ==>");
        Book book = bookRepository.findBookById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + bookId + " not found");
        } else {
            bookRepository.deleteById(bookId);
            return "Book with id " + bookId + " has been successfully deleted";
        }
    }
    public GBBook addGBBook(GBBook gBBookObject) {
        System.out.println("service calling addGBBook ==>");
        GBBook gBBook = gBBookRepository.findGBBookByTitle(gBBookObject.getTitle());
        if (gBBook != null) {
            throw new InformationExistsException("Book with title " + gBBook.getTitle() + " already exists");
        }

        return gBBookRepository.save(gBBookObject);
    }

    public List<GBBook> getGBBookList(){
        LOGGER.info("calling getGBBBookList method from service");
       List<GBBook> gbBooks = gBBookRepository.findAll();
        if(gbBooks.isEmpty()){
            throw new InformationNotFoundException("No books were found");
        } else{
            return gbBooks;
        }
    }
    public GBBook getGBBook(Long gBBookId) {

        GBBook book = gBBookRepository.findGBBookById(gBBookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + gBBookId + " not found");
        } else{
            return book;
        }
    }
    public GBBook updateGBBook(Long bookId, GBBook bookObject) {
        LOGGER.info("service calling updateBook ==>");
        GBBook book = gBBookRepository.findGBBookById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("Book with id " + bookId + " not found");
        } else {
            if(bookObject.getTitle() != null){ book.setTitle(bookObject.getTitle());}
            if(bookObject.isCheckedOut()){book.setCheckedOut(bookObject.isCheckedOut());}
            if (bookObject.getLibraryId() != null){ book.setLibraryId(bookObject.getLibraryId());}
            return gBBookRepository.save(book);
        }
    }
    public String deleteGBBook(Long gBBookId) {
        LOGGER.info("service calling deleteGBBook ==>");
        GBBook gBBook = gBBookRepository.findGBBookById(gBBookId);
        if (gBBook == null) {
            throw new InformationNotFoundException("Book with id " + gBBookId + " not found");
        } else {
            bookRepository.deleteById(gBBookId);
            return "Book with id " + gBBookId + " has been successfully deleted";
        }
    }

    public Comment postComment(Long gBBookId, Comment commentObject){
        LOGGER.info("service calling postComment");
        try {
            Optional book = gBBookRepository.findById(gBBookId);
            commentObject.setGbBook((GBBook) book.get());
            return commentRepository.save(commentObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException(
                    "Book with id " + gBBookId + " does not exist");
        }
    }
    public List<Comment> getComments(){
        LOGGER.info("service calling getComments");
        List<Comment> comment= commentRepository.findAll();
        return comment;

    }
    public Library addLibrary(Library libraryObject) {
        LOGGER.info("service calling addLibrary ==>");
        Library library = libraryRepository.findLibraryByStreet(libraryObject.getStreet());
        if (library != null) {
            throw new InformationExistsException("Library with address " + library.getStreet() + " already exists");
        }

        return libraryRepository.save(libraryObject);
    }

    public List<Library> getLibraries(){
        LOGGER.info("calling getLibraries method from service");
        List<Library> libraries = libraryRepository.findAll();
        if(libraries.isEmpty()){
            throw new InformationNotFoundException("No libraries were found");
        } else{
            return libraries;
        }
    }
}
