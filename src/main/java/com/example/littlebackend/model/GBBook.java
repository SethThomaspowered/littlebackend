package com.example.littlebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="gbbooks")
public class GBBook {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column
    private String image;
    @Column
    private String isbn;
    @Column
    private String author;
    @Column
    private String googleId;

    public Boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Column
    private Boolean checkedOut;
    @Column
    private Long libraryId;

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public GBBook(Long id, String title, String description, String image, String author, String googleId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
//        this.isbn = isbn;
        this.author = author;
        this.googleId = googleId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
    //    @JsonIgnore
//    @OneToOne(mappedBy = "gBBook")
//    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public GBBook() {
    }

    public GBBook(Long id, String title, String description, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
//        this.book = book;
    }


}
