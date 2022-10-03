package com.teamfive.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.teamfive.project.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE email =:email AND password =:password")
	  User getByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
