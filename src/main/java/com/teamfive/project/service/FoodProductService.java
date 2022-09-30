package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.FoodProductDao;
import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.ResponseStructure;
import com.teamfive.project.dto.User;



@Service
public class FoodProductService {
	@Autowired
	FoodProductDao dao;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProducts) {
	   return dao.saveFoodProduct(foodProducts);
	}
	public FoodProduct deleteFoodProduct(int id) {
	   return dao.deleteFoodProduct(id);
//	   return "Food product "+id+" Deleted";
	}
	public List<FoodProduct> findAllFoodProduct(){
		return dao.findAllFoodProduct();
		
	}
	
	public ResponseStructure<FoodProduct> findbyId(int id) {
//		return dao.getFoodProductById(id);
		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();
		FoodProduct person = dao.getFoodProductById(id);
		if(person != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("details found");
			responseStructure.setData(person);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("data not found");
			responseStructure.setData(null);
		}
		return responseStructure;
		
		
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
