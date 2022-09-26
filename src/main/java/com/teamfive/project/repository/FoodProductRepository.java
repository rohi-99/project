package com.teamfive.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfive.project.dto.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer>{

}
