package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.UserDao;
import com.teamfive.project.dto.ResponseStructure;
import com.teamfive.project.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public User saveUser(User user) {
	   return dao.saveUser(user);
	}
	public User deleteUser(int id) {
	   return dao.deleteUser(id);
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
		
	public ResponseEntity<ResponseStructure<User>> login(String email, String password){
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = dao.loginUser(email, password);
		if(user!=null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMsg(password);
			structure.setData(user);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMsg(password);
			structure.setData(user);
		}
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
		
}
