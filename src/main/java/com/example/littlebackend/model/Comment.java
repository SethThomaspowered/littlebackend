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
    @Column(length=99999)
    private String comment;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
}
