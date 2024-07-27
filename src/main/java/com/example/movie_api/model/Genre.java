package com.example.movie_api.model;

import jakarta.persistence.*;


@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "id")
    private Long id;
    
}
