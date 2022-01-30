package com.example.littlebackend.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookTitle;

    @Column
    private String authorName;
    @Column
    private Date dateAdded;
    @Column
    private boolean IsAvailable;
    @Column
    private String googleBooksId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="googleBook_id", referencedColumnName = "id")
//    private GBBook gBBook;
//    public Book() {
//    }

//    public GBBook getgBBook() {
//        return gBBook;
//    }
//
//    public void setgBBook(GBBook gBBook) {
//        this.gBBook = gBBook;
//    }

    public Book(Long id, String bookTitle, String authorName, String googleBooksId, Date dateAdded) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.dateAdded = dateAdded;
        this.IsAvailable = true;
        this.googleBooksId = googleBooksId;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public  void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(boolean available) {
        IsAvailable = available;
    }

    public String getGoogleBooksId() {
        return googleBooksId;
    }

    public void setGoogleBooksId(String googleBooksId) {
        this.googleBooksId = googleBooksId;
    }


}
