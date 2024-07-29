package com.example.movie_api.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.jmx.export.annotation.ManagedNotification;

import jakarta.persistence.*;
@Entity
@Table(name = "casts")
public class Cast {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @ManyToMany(mappedBy = "casts")
    private Set<Movie> movies = new HashSet<>();

    public Cast(){}

    public Cast(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    

    
}
