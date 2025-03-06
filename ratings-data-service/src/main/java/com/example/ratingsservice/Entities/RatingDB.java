package com.example.ratingsservice.Entities;

import com.example.ratingsservice.models.Rating;
import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class RatingDB {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private int userId;

  @Column(name = "movie_id", nullable = false)
  private int movieId;

  @Column(nullable = false)
  private int rating;

  // Constructors
  public RatingDB() {}

  public RatingDB(int userId, int movieId, int rating) {
    this.userId = userId;
    this.movieId = movieId;
    this.rating = rating;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public int getUserId() { return userId; }
  public void setUserId(int userId) { this.userId = userId; }

  public int getMovieId() { return movieId; }
  public void setMovieId(int movieId) { this.movieId = movieId; }

  public int getRating() { return rating; }
  public void setRating(int rating) { this.rating = rating; }

  public Rating toRating() {
    return new Rating(String.valueOf(movieId), rating);
  }
  @Override
  public String toString() {
    return "Rating{" +
            "id=" + id +
            ", userId=" + userId +
            ", movieId=" + movieId +
            ", rating=" + rating +
            '}';
  }
}
