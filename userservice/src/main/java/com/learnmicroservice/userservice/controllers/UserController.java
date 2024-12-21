package com.learnmicroservice.userservice.controllers;

import com.learnmicroservice.userservice.entities.User;
import com.learnmicroservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.getUser(id));
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
