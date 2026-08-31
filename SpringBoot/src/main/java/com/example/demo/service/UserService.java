package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Component
public class UserService {

@Autowired
private UserRepo userRepo;

public User createUser(User user) {
	// TODO Auto-generated method stub
	return userRepo.save(user);
}

public List<User> getAllUsers() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}

public User updateUser(User user) {
	// TODO Auto-generated method stub
	return userRepo.save(user);
}

public void deleteUser(Integer id) {
	// TODO Auto-generated method stub
	userRepo.deleteById(id);
}


}
