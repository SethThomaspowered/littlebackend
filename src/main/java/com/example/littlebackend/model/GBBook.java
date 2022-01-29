package com.example.littlebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gbbooks")
public class GBBook {
    @Id
    @Column
    private String googleId;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column
    private String image;
}
