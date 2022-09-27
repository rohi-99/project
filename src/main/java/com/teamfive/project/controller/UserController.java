package com.teamfive.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamfive.project.dto.User;
import com.teamfive.project.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("saveuser")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@DeleteMapping("deleteuser")
	public String deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("findalluser")
	public List<User> findAllUser(){
		return service.findAllUser();
	}
	@PutMapping("user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id) {
		return service.updateUser(user, id);
		
	}
}
