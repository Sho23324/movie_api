package com.sho.MovieApi.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "casts")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "movie_cast",
        joinColumns = @JoinColumn(name = "cast_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<Movie>();

    
    @ManyToMany
    @JoinTable(
        name = "series_cast",
        joinColumns = @JoinColumn(name = "cast_id"),
        inverseJoinColumns = @JoinColumn(name = "series_id")
    )
    private Set<Series> series = new HashSet<Series>();

    public Cast(String name) {
        this.name = name;
    }

    public Cast(){}

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
}
