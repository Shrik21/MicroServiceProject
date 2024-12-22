package com.learnmicroservice.userservice.entities;

import lombok.Data;

@Data
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelDescription;
}
