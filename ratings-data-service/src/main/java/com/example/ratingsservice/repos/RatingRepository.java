package com.example.ratingsservice.repos;

import com.example.ratingsservice.Entities.RatingDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingDB, Long> {
  List<RatingDB> findByUserId(int userId);
  List<RatingDB> findByMovieId(int movieId);
}
