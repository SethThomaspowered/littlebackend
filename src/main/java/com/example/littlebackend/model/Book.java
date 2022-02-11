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
    private Boolean IsAvailable;
    @Column
    private String googleBooksId;
    @Column
    private Long libraryId;
    @Column
    private String address;

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
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

    public Boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(Boolean available) {
        IsAvailable = available;
    }

    public String getGoogleBooksId() {
        return googleBooksId;
    }

    public void setGoogleBooksId(String googleBooksId) {
        this.googleBooksId = googleBooksId;
    }


}
