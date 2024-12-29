package com.learnmicroservice.userservice.controllers;

import com.learnmicroservice.userservice.entities.User;
import com.learnmicroservice.userservice.serviceImpls.UserServiceImpls;
import com.learnmicroservice.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

   // logging the info
   private Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long id){
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    int retryCount = 1;

    @GetMapping("/{id}")
    @CircuitBreaker(name = "rattingHotelBreaker", fallbackMethod = "rattingHotelFallBack")
    @Retry(name = "rattingHotelRetry", fallbackMethod = "rattingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable long id){
        logger.info("Getting user with id "+id);
        logger.info("Retry count "+retryCount);
        retryCount++;
        return ResponseEntity.ok(userService.getUser(id));
    }


    //create a fallback method for the circuit breaker
    public ResponseEntity<User> rattingHotelFallBack(long id, Exception e){
        logger.info("Fallback method executed because of "+e.getMessage());
       //User user = User.builder().id(id).name("User not found").email("User not found").about("User not found").build();
        User user = new User();
        user.setId(id);
        user.setName("User not found");
        user.setEmail("Dummy email");
        user.setAbout("User not found");
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allUser")
    public List<User> getAllUsers(){
        System.out.println("Working");
        System.out.println("Controllers "+userService.getAllUsers());
        return userService.getAllUsers();
    }

    @PostMapping("/savingUsers")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users){
        System.out.println("List of users "+users);
        return ResponseEntity.ok(userService.createUsers(users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }


}
