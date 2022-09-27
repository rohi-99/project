package com.teamfive.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.User;
import com.teamfive.project.repository.FoodProductRepository;

@Repository
public class FoodProductDao {
	
	@Autowired
	private FoodProductRepository repository;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return repository.save(foodProduct);
	}
	
	public void deleteFoodProduct(int id) {
		FoodProduct foodProduct = getFoodProductById(id);
		repository.delete(foodProduct);
	}
	
	public FoodProduct getFoodProductById(int id) {
		return repository.findById(id).get();
	}
	
	public List<FoodProduct> findAllFoodProduct(){
		return repository.findAll();
		
	}
	
	public FoodProduct updateFoodProduct(FoodProduct foodProduct,int id) {
		foodProduct.setId(id);
		return repository.save(foodProduct);
	}
	
}
