package com.hotelservice.hotelservice.services;



import com.hotelservice.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel createHotel(Hotel hotel);
    public Hotel updateHotel(Hotel hotel, String id);
    public void deleteHotel(String id);
    public Hotel getHotel(String id);
    public List<Hotel> getAllHotels();
}
