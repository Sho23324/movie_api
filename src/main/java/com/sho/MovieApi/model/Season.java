package com.sho.MovieApi.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "summary")
    private String summary;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "imdb_rating")
    private Double imdbRating;

    @Column(name = "user_rating")
    private Double userRating = 0.0;

    @Column(name = "review_count")
    private Integer reviewCount = 0;

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;
    
    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "season_review",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private Set<Review> reviews = new HashSet<Review>();

    public Season(Integer seasonNumber, String summary, Integer releaseYear, Double imdbRating, Double userRating,
            Integer reviewCount) {
        this.seasonNumber = seasonNumber;
        this.summary = summary;
        this.releaseYear = releaseYear;
        this.imdbRating = imdbRating;
        this.userRating = userRating;
        this.reviewCount = reviewCount;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Season(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
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
