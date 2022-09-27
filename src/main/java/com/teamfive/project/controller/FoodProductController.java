package com.teamfive.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.FoodProductService;

@RestController
public class FoodProductController {
	@Autowired
	FoodProductService service;
	
	@PostMapping("/savefoodProducts")
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProducts) {
		return service.saveFoodProduct(foodProducts);
	}
	
	@DeleteMapping("/deletefoodProducts")
	public String deleteFoodProduct(@RequestParam int id) {
		return service.deleteFoodProduct(id);
	}
	
	@GetMapping("/findallfoodProducts")
	public List<FoodProduct> findAllFoodProduct(){
		return service.findAllFoodProduct();
	}
	
	@PutMapping("/foodProduct/{id}")
	public FoodProduct foodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int id) {
		return service.updateFoodProduct(foodProduct, id);
		
	}
}
