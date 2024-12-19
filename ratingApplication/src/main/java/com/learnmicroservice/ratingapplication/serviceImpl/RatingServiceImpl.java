package com.learnmicroservice.ratingapplication.serviceImpl;

import com.learnmicroservice.ratingapplication.entities.Rating;
import com.learnmicroservice.ratingapplication.exception.ResourceNotFoundException;
import com.learnmicroservice.ratingapplication.repositories.RatingRepo;
import com.learnmicroservice.ratingapplication.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
       return ratingRepo.save(rating);
    }

    @Override
    public Rating getRating(String id) {
        return ratingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating with id " + id + " not found"));
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepo.findAllByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findAllByUserId(userId);
    }
}
