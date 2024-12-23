package com.learnmicroservice.userservice.external.services;

import com.learnmicroservice.userservice.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

   @PostMapping("/rating/create")
   Ratings createRating(Ratings value);

   @PutMapping("/rating/{ratingId}")
   Ratings updateRating(@PathVariable("ratingId") String ratingId, Ratings value);

   @DeleteMapping
    void deleteRating(@PathVariable("ratingId") String ratingId);
}
