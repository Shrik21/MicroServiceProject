package com.hotelservice.hotelservice.controllers;

import com.hotelservice.hotelservice.entities.Hotel;
import com.hotelservice.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/saveHotel")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@RequestBody Hotel hotel,@PathVariable String id){
        return hotelService.updateHotel(hotel, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id){
        hotelService.deleteHotel(id);
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable String id){
        System.out.println("Hotel ID ### "+id);
        return hotelService.getHotel(id);
    }

    @GetMapping("/allHotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }
}
