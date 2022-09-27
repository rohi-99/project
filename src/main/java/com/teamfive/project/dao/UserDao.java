package com.teamfive.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.User;
import com.teamfive.project.repository.UserRepository;


@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repository;
	
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int id) {
		User user = getUserById(id);
		repository.delete(user);
	}
	
	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	
	public List<User> findAllUser(){
		return repository.findAll();
	}
	
	public User updateUser(User user,int id) {
		user.setId(id);
		return repository.save(user);
		
	}
	
	
}
