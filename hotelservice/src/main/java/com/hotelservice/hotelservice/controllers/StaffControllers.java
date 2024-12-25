package com.hotelservice.hotelservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffControllers {

    @RequestMapping("/getStaff")
    public List<String> getStaff(){
        return List.of("Staff 1", "Staff 2", "Staff 3");
    }
}
