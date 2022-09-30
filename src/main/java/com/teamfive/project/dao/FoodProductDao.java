package com.teamfive.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.User;
import com.teamfive.project.repository.FoodProductRepository;
//import com.ty.springbootperson.dto.Person;

@Repository
public class FoodProductDao {
	
	@Autowired
	private FoodProductRepository repository;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return repository.save(foodProduct);
	}
	
	public FoodProduct deleteFoodProduct(int id) {
		FoodProduct foodProduct = getFoodProductById(id);
		repository.delete(foodProduct);
		return foodProduct;
	}
	
	public FoodProduct getFoodProductById(int id) {
//		return repository.findById(id).get();
		
		
		Optional<FoodProduct> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public List<FoodProduct> findAllFoodProduct(){
		return repository.findAll();
		
	}
	
	public FoodProduct updateFoodProduct(FoodProduct foodProduct,int id) {
		foodProduct.setId(id);
		return repository.save(foodProduct);
	}
	
}
