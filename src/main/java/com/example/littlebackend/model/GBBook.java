package com.example.littlebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="gbbooks")
public class GBBook {
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column
    private String image;
    @JsonIgnore
    @OneToOne(mappedBy = "gBBook")
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public GBBook() {
    }

    public GBBook(Long id, String title, String description, String image, Book book) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.book = book;
    }


}
