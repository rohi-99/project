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

import com.teamfive.project.dto.FoodOrder;
import com.teamfive.project.dto.Item;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.EmailSenderService;
import com.teamfive.project.service.FoodOrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodOrderController {
	@Autowired
	FoodOrderService service;
	
	@Autowired
	EmailSenderService emailService;
	
	@PostMapping("/savefoodorder")
	public FoodOrder saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@DeleteMapping("deletefoodorder")
	public String deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}
	
	@GetMapping("/getFoodOrderById/{id}") 
	public FoodOrder getFoodOrderById(@PathVariable int id) {
		return service.findById(id);
	}
    @GetMapping("findallfoodorder")
	public List<FoodOrder> findAllFoodOrdr(){
		return service.findAllFoodOrder();
	}
    
    @PutMapping("foodorder/{id}")
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int id) {
		return service.updateFoodOrder(foodOrder, id);
		
	}
    
    @PostMapping("sendMail")
    public void sendEmail(@RequestBody FoodOrder foodOrder) {
    	String email = foodOrder.getEmail();
    	String body =  service.emailBody(foodOrder);
    	System.out.println(body);
    	emailService.sendSimpleEmail(email, "Bill Details", body);
    }
    
}
