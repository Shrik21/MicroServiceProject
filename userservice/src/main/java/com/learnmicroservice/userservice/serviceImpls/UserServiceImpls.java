package com.learnmicroservice.userservice.serviceImpls;

import com.learnmicroservice.userservice.entities.Hotel;
import com.learnmicroservice.userservice.entities.Ratings;
import com.learnmicroservice.userservice.entities.User;
import com.learnmicroservice.userservice.exception.ResourceNotFoundException;
import com.learnmicroservice.userservice.external.services.HotelService;
import com.learnmicroservice.userservice.repositories.UserRepo;
import com.learnmicroservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpls implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;


    private Logger logger = Logger.getLogger(UserServiceImpls.class.getName());

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());
        return userRepo.save(existingUser);
    }

    @Override
    public String deleteUser(long id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
        userRepo.delete(existingUser);
        return "User with id " + id + " deleted successfully";
    }

    @Override
    public User getUser(long id) {
        User user= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));

        //fetching rating of the above user from Rating service
        Ratings[] ratingOfUser =   restTemplate.getForObject("http://RATING-SERVICE/rating/getByUserId/"+user.getId(), Ratings[].class);
        logger.info("User Details ### "+user.toString());
        logger.info(" "+ratingOfUser);

        List<Ratings> ratings= Arrays.stream(ratingOfUser).toList();

        ratings.stream().map(rating -> {
            // api call to hotelService to get the hotel
            // details based on the hotelId
            logger.info("Getting Hotel details for hotelId {} "+rating.getHotelId());
          // ResponseEntity<Hotel> hotelDetails = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

           //Hotel hotel = hotelDetails.getBody();

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return new Ratings();
        }).toList(); // toList() is used to collect the stream of ratings into a list
        user.setRatings(ratings);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> createUsers(List<User> users) {
        System.out.println("List of users in service ## "+users);
        return userRepo.saveAll(users);
    }
}
