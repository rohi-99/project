package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.UserDao;
import com.teamfive.project.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public User saveUser(User user) {
	   return dao.saveUser(user);
	}
	public String deleteUser(int id) {
	   dao.deleteUser(id);
	   return "User "+id+" Deleted";
	}
	public List<User> findAllUser(){
		return dao.findAllUser();
	}
	
	public User updateUser(User updatedUser, int id) {
		User user = dao.getUserById(id);
		if(user != null) {
			User newUser= dao.updateUser(updatedUser, id);
			return newUser;
		}
		else {
			return null;
		}
	}
		
		
}
