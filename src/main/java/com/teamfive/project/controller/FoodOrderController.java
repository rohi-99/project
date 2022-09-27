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

import com.teamfive.project.dto.FoodOrder;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.FoodOrderService;

@RestController
public class FoodOrderController {
	@Autowired
	FoodOrderService service;
	
	@PostMapping("/savefoodorder")
	public FoodOrder savefoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@DeleteMapping("deletefoodorder")
	public String deleteAdmin(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}
	
//	@GetMapping("/getbyid/{id}") 
//	public FoodOrder getFoodOrderById(@PathVariable int id) {
//		return dao.getFoodOrderById(id);
//	}
    @GetMapping("findallfoodorder")
	public List<FoodOrder> findAllFoodOrdr(){
		return service.findAllFoodOrder();
	}
    
    @PutMapping("foodorder/{id}")
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int id) {
		return service.updateFoodOrder(foodOrder, id);
		
	}
}
