package com.example.ratingsservice.services;

import com.example.ratingsservice.Entities.RatingDB;
import com.example.ratingsservice.repos.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

  @Autowired
  private RatingRepository ratingRepository;

  public List<RatingDB> getAllRatings() {
    return ratingRepository.findAll();
  }

  public RatingDB getRatingById(Long id) {
    return ratingRepository.findById(id).orElse(null);
  }

  public List<RatingDB> getRatingsByUserId(int userId) {
    return ratingRepository.findByUserId(userId);
  }

  public RatingDB saveRating(RatingDB rating) {
    return ratingRepository.save(rating);
  }
}

