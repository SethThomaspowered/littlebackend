package com.example.littlebackend.model;

import javax.persistence.*;
import java.sql.Date;

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

    public Book() {
    }

    public Book(Long id, String bookTitle, String authorName, Date dateAdded, boolean isAvailable, String googleBooksId) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.dateAdded = dateAdded;
        IsAvailable = isAvailable;
        this.googleBooksId = googleBooksId;
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
