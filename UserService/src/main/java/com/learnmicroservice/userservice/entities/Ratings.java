package com.learnmicroservice.userservice.entities;

import lombok.Data;

@Data
public class Ratings {
    private int rating;
    private String userId;
    private String HotelId;
    private String HotelName;
}
