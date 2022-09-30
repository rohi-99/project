package com.teamfive.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamfive.project.dto.FoodProduct;
import com.teamfive.project.dto.ResponseStructure;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.FoodProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodProductController {
	@Autowired
	FoodProductService service;
	
	@PostMapping("/savefoodProducts")
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProducts) {
		return service.saveFoodProduct(foodProducts);
	}
	
	@DeleteMapping("/deletefoodProducts/{id}")
	public FoodProduct deleteFoodProduct(@PathVariable int id) {
		return service.deleteFoodProduct(id);
	}
	
	@GetMapping("/findallfoodProducts")
	public List<FoodProduct> findAllFoodProduct(){
		return service.findAllFoodProduct();
	}
	
	@GetMapping("/getFoodProductById/{id}")
	public ResponseStructure<FoodProduct> findbyId(@PathVariable int id) {
		return service.findbyId(id);
	}
	
	@PutMapping("/foodProduct/{id}")
	public FoodProduct foodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int id) {
		return service.updateFoodProduct(foodProduct, id);
		
	}
}
