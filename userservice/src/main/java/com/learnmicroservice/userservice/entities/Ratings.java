package com.learnmicroservice.userservice.entities;

import lombok.Data;

@Data
public class Ratings {
    private String ratingId;
    private String userId;
    private String HotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
