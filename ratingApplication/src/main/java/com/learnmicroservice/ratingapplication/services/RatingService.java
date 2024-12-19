package com.learnmicroservice.ratingapplication.services;

import com.learnmicroservice.ratingapplication.entities.Rating;

import java.util.List;

public interface  RatingService {
    public Rating createRating(Rating rating);
    public Rating getRating(String id);
    public List<Rating> getAllRatings();
    public List<Rating> getRatingsByHotelId(String hotelId);
    public List<Rating> getRatingsByUserId(String userId);
}
