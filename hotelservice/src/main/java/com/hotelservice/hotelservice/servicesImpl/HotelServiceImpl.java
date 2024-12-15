package com.hotelservice.hotelservice.servicesImpl;

import com.hotelservice.hotelservice.entities.Hotel;
import com.hotelservice.hotelservice.exceptions.ResourceNotFoundException;
import com.hotelservice.hotelservice.repositories.HotelRepo;
import com.hotelservice.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;


    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String id) {
        Hotel existingHotel = hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with id " + id + " not found"));
        return hotelRepo.save(hotel);
    }

    @Override
    public void deleteHotel(String id) {
        Hotel existingHotel = hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with id " + id + " not found"));
        hotelRepo.delete(existingHotel);
    }

    @Override
    public Hotel getHotel(String id) {
        System.out.println("Hotel ID ### "+id);
        System.out.println("hotel details ### "+hotelRepo.findById(id).toString());
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with id " + id + " not found"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }
}
