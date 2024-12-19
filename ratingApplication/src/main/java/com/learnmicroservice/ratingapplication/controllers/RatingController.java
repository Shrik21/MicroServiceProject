package com.learnmicroservice.ratingapplication.controllers;

import com.learnmicroservice.ratingapplication.entities.Rating;
import com.learnmicroservice.ratingapplication.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public Rating createRating(@RequestBody Rating rating){
        return ratingService.createRating(rating);
    }

    @GetMapping("/get/{id}")
    public Rating getRating(@PathVariable String id){
        return ratingService.getRating(id);
    }

    @GetMapping("/getByHotelId/{hotelId}")
    public List<Rating> getRatingsByHotelId(@PathVariable String hotelId){
        return ratingService.getRatingsByHotelId(hotelId);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId){
        return ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/getAll")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

}
