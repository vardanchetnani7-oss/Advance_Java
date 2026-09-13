package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
Optional<User> findByname(String name);
List<User>findByNameIgnoreCase(String name);
List<User>findByPhone(String phone);
}
