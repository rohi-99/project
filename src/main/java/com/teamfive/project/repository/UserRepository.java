package com.teamfive.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfive.project.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
