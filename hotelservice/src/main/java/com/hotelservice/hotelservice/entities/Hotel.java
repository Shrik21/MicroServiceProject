package com.hotelservice.hotelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Hotels")
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelDescription;
}
