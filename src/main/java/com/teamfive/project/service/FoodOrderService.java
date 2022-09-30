package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.FoodOrderDao;
import com.teamfive.project.dto.FoodOrder;
import com.teamfive.project.dto.User;

@Service
public class FoodOrderService {
	
	@Autowired
	 FoodOrderDao dao;
	 
	 public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		   return dao.saveFoodOrder(foodOrder);
		}
		public String deleteFoodOrder(int id) {
		   dao.deleteFoodOrder(id);
		   return "FoodOrder "+id+" Deleted";
		}
		public List<FoodOrder> findAllFoodOrder(){
			return dao.findAllFoodOrder();
		}
		
		public FoodOrder findById(int id) {
			return dao.getFoodOrderById(id);
		}
		
		public FoodOrder updateFoodOrder(FoodOrder updatedFoodOrder, int id) {
			FoodOrder foodOrder = dao.getFoodOrderById(id);
			if(foodOrder != null) {
				FoodOrder newFoodOrder= dao.updateFoodOrder(updatedFoodOrder, id);
				return newFoodOrder;
			}
			else {
				return null;
			}
		}
}
