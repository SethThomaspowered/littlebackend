package com.example.littlebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String comment;
    @Column
    private String name;


    @ManyToOne
    @JoinColumn(name= "book_id")
    private GBBook gbBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public GBBook getGbBook() {
        return gbBook;
    }

    public void setGbBook(GBBook gbBook) {
        this.gbBook = gbBook;
    }

    public Comment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment(Long id, String comment, GBBook gbBook) {
        this.id = id;
        this.comment = comment;

        this.gbBook = gbBook;
    }
}
