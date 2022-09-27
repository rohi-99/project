package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.FoodProductDao;
import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.User;


@Service
public class FoodProductService {
	@Autowired
	FoodProductDao dao;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProducts) {
	   return dao.saveFoodProduct(foodProducts);
	}
	public String deleteFoodProduct(int id) {
	   dao.deleteFoodProduct(id);
	   return "Food product "+id+" Deleted";
	}
	public List<FoodProduct> findAllFoodProduct(){
		return dao.findAllFoodProduct();
	}
	
	public FoodProduct updateFoodProduct(FoodProduct updatedFoodProduct, int id) {
		FoodProduct foodProduct = dao.getFoodProductById(id);
		if(foodProduct != null) {
			FoodProduct newFoodProduct= dao.updateFoodProduct(updatedFoodProduct, id);
			return newFoodProduct;
		}
		else {
			return null;
		}
	}
}
