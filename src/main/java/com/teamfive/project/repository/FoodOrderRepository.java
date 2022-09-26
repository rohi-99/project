package com.teamfive.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfive.project.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
