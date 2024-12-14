package com.learnmicroservice.userservice.serviceImpls;

import com.learnmicroservice.userservice.entities.User;
import com.learnmicroservice.userservice.exceptions.ResourceNotFoundException;
import com.learnmicroservice.userservice.repositories.UserRepo;
import com.learnmicroservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
        return userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(long id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
        userRepo.delete(existingUser);
    }

    @Override
    public User getUser(long id) {
        return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("User Details ### "+userRepo.findAll().toString());
        return userRepo.findAll();
    }

    @Override
    public List<User> createUsers(List<User> users) {
        return userRepo.saveAll(users);
    }
}
