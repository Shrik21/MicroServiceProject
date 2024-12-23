package com.learnmicroservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ratings {
    private String ratingId;
    private String userId;
    @JsonIgnore
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
