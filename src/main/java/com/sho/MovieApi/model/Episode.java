package com.sho.MovieApi.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "air_date")
    private Date airDate;

    @Column(name = "imdb_rating")
    private Double imdbRating;

    @Column(name = "user_rating")
    private Double userRating = 0.0;

    @Column(name = "review_count")
    private Integer reviewCount = 0;

    
    @ManyToMany
    @JoinTable(name = "episode_review",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private Set<Review> reviews = new HashSet<Review>();

    public Episode(Integer episodeNumber, String title, Date airDate, Double imdbRating, Double userRating,
            Integer reviewCount) {
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.airDate = airDate;
        this.imdbRating = imdbRating;
        this.userRating = userRating;
        this.reviewCount = reviewCount;
    }

    public Episode(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    

}
