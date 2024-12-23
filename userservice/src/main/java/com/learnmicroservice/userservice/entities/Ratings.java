package com.learnmicroservice.userservice.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ratings {
    private String ratingId;
    private String userId;
    private String HotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
