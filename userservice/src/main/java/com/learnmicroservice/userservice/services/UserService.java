package com.learnmicroservice.userservice.services;

import com.learnmicroservice.userservice.entities.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user,long id);
    public String  deleteUser(long id);
    public User getUser(long id);
    public List<User> getAllUsers();
    public List<User> createUsers(List<User> users);
}
