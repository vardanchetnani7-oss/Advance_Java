package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;



@RestController
public class UserController {

@Autowired
private UserService userService;

@GetMapping("/users")
public String hello() {
	return "Hello, World!";}

@PostMapping("/users")
public User createUser(@RequestBody User user) {
	
	System.out.println(user);
	User u1 = this. userService.createUser(user);
	return u1;
}
@GetMapping("/allusers/get")
public java.util.List<User> getAllUsers() {
	return this.userService.getAllUsers();

}

@PutMapping("/users/update")
public User updateUser(@RequestBody User user) {
	return this.userService.updateUser(user);
}

@DeleteMapping("/users/delete/{id}")
public String deleteUser(@PathVariable Integer id) {
	this.userService.deleteUser(id);
	return "User deleted successfully";	
}
}