package com.example.littlebackend.service;

import com.example.littlebackend.exception.InformationExistsException;
import com.example.littlebackend.exception.InformationNotFoundException;
import com.example.littlebackend.model.Book;
import com.example.littlebackend.model.GBBook;
import com.example.littlebackend.repository.BookRepository;
//import com.example.littlebackend.security.MyUserDetails;
import com.example.littlebackend.repository.GBBookRepository;
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
    private static final Logger LOGGER=Logger.getLogger(BookService.class.getName());
    @Autowired
    public void setBookRepository(BookRepository bookRepository){ this.bookRepository=bookRepository; }
    @Autowired
    public void setGBBookRepository(GBBookRepository gBBookRepository){ this.gBBookRepository= gBBookRepository;}
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
    public GBBook addGBBook(Long bookId, GBBook gBBookObject) {
        System.out.println("service calling addGBBook ==>");
        Book book = bookRepository.findBookById(bookId);
        if (book == null) {
            throw new InformationNotFoundException(
                    "Book with id " + bookId + " does not exist");
        }
        GBBook gBBook = gBBookRepository.findGBBookByTitle(gBBookObject.getTitle());
        if (gBBook != null) {
            throw new InformationExistsException("Music with title " + gBBook.getTitle() + " already exists");
        }
        gBBookObject.setBook(book);
        return gBBookRepository.save(gBBookObject);
    }

//    public List<GBBook> getGBBookList(Long bookId){
//        LOGGER.info("calling getGBBBookList method from service");
//        Optional<Book> book = bookRepository.findById(bookId);
//        if (book.isPresent()) {
//            return book.get().getGBBook();
//        } else {
//            throw new InformationNotFoundException("Playlist with id " + playlistId + " not found");
//        }
//    }
    public GBBook getGBBook(Long bookId, Long gBBookId) {
        LOGGER.info("calling getGBBook method from service");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            Optional<GBBook> gBBook = gBBookRepository.findByBookId(bookId).stream().filter(
                    p -> p.getId().equals(gBBookId)).findFirst();
            if (gBBook == null) {
                throw new InformationNotFoundException("Book with " + gBBookId + " not found");
            } else return gBBook.get();
        } else {
            throw new InformationNotFoundException("No book with id " + bookId + " not found");
        }
    }
//
//    public Music updatePlaylistMusic(Long playlistId, Long musicId, Music musicObject) {
//        LOGGER.info("service calling updatePlaylistMusic ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Playlist playlist = playlistRepository.findByIdAndUserId(playlistId, userDetails.getUser().getId());
//        try {
//            Music music = (musicRepository.findByPlaylistId(
//                    playlistId).stream().filter(p -> p.getId().equals(musicId)).findFirst()).get();
//            music.setTitle(musicObject.getTitle());
//            music.setLength(musicObject.getLength());
//            music.setReleaseDate(musicObject.getReleaseDate());
//            music.setArtist(musicObject.getArtist());
//            return musicRepository.save(music);
//        } catch (NoSuchElementException e) {
//            throw new InformationNotFoundException("music track or playlist not found");
//        }
//    }
//
//    public Music deletePlaylistMusic(Long playlistId, Long musicId) {
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Playlist playlist = playlistRepository.findByIdAndUserId(playlistId, userDetails.getUser().getId());
//        try {
//            Music music = (musicRepository.findByPlaylistId(
//                    playlistId).stream().filter(p -> p.getId().equals(musicId)).findFirst()).get();
//            musicRepository.deleteById(music.getId());
//        } catch (NoSuchElementException e) {
//            throw new InformationNotFoundException("music track or playlist not found");
//        }
//        return null;
//    }
}
