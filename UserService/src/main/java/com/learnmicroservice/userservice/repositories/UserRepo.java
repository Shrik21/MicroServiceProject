package com.learnmicroservice.userservice.repositories;

import com.learnmicroservice.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
