package com.sho.MovieApi.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private Integer rating;

    public Review(String comment, Integer rating) {
        this.comment = comment;
        this.rating = rating;
    }
    @ManyToMany(mappedBy = "reviews")
    private Set<Movie> movies = new HashSet<Movie>();

    @ManyToMany(mappedBy = "reviews")
    private Set<Series> series = new HashSet<Series>();

    @ManyToMany(mappedBy = "reviews")
    private Set<Season> seasons = new HashSet<Season>();

    @ManyToMany(mappedBy = "reviews")
    private Set<Episode> episodes = new HashSet<Episode>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public Review(){}

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
}
