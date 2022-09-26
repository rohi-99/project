package com.teamfive.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.FoodOrder;
import com.teamfive.project.repository.FoodOrderRepository;



@Repository
public class FoodOrderDao {
	
	@Autowired
	private FoodOrderRepository repository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder deleteFoodOrder(int id) {
		FoodOrder FoodOrder= getFoodOrderById(id);
		repository.delete(FoodOrder);
		return FoodOrder;
	}
	
	public FoodOrder getFoodOrderById(int id) {
		return repository.findById(id).get();
	}
	public List<FoodOrder> findAllFoodOrder(){
		return repository.findAll();
	}
}
