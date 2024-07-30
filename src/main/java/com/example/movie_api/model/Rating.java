package com.example.movie_api.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "user_id" ,nullable = false)
    private User user;

    public Set<Episode> getEpisode() {
        return episode;
    }


    public void setEpisode(Set<Episode> episode) {
        this.episode = episode;
    }


    @ManyToMany(mappedBy = "ratings")
    private Set<Movie> movies = new HashSet<Movie>();

    @ManyToMany(mappedBy = "ratings")
    private Set<Series> series = new HashSet<Series>();

    
    @ManyToMany(mappedBy = "ratings")
    private Set<Season> season = new HashSet<Season>();

    @ManyToMany(mappedBy = "ratings")
    private Set<Episode> episode = new HashSet<Episode>();
    

    public Rating() {
    }


    public Rating(Double value, User user, Set<Movie> movies, Set<Series> series, Set<Season> season,
            Set<Episode> episode) {
        this.value = value;
        this.user = user;
        this.movies = movies;
        this.series = series;
        this.season = season;
        this.episode = episode;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Double getValue() {
        return value;
    }


    public void setValue(Double value) {
        this.value = value;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Set<Movie> getMovies() {
        return movies;
    }


    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    public Set<Series> getSeries() {
        return series;
    }


    public void setSeries(Set<Series> series) {
        this.series = series;
    }


    public Set<Season> getSeason() {
        return season;
    }


    public void setSeason(Set<Season> season) {
        this.season = season;
    }

    

}
