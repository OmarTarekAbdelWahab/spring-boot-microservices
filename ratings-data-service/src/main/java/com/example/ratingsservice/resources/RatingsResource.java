package com.example.ratingsservice.resources;

import com.example.ratingsservice.Entities.RatingDB;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.UserRating;
import com.example.ratingsservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @Autowired
    private RatingService ratingService;

    @RequestMapping("/{userId}")
    public UserRating getRatingsOfUser(@PathVariable String userId) {
//        List<Rating> ratings = Arrays.asList(
//                new Rating("550", 4)
//        );
        List<RatingDB> ratings = ratingService.getRatingsByUserId(Integer.parseInt(userId));
        return new UserRating(
                ratings.stream().map(RatingDB::toRating).collect(Collectors.toList())
        );
    }
}
