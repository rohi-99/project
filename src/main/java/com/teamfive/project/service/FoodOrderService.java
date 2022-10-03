package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.FoodOrderDao;
import com.teamfive.project.dto.FoodOrder;
import com.teamfive.project.dto.Item;
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
		
		public String emailBody(FoodOrder foodOrder) {
			int id = foodOrder.getId();
			String customerName = foodOrder.getCustomerName();
			String customerNumber = foodOrder.getContactNumber();
			double totalPrice = foodOrder.getTotalPrice();
			String orderCreatedTime = foodOrder.getOrderCreatedTime();
			String orderDeliveryTime = foodOrder.getOrderDeliveryTime();
			String details ="";
			

			for (Item result : foodOrder.getItem()) {
//			    System.out.println(result.getName());
				details = "Food : "+result.getName()+"\n"+"Price : ₹ "+result.getPrice()+"\n"+"Quantity : "+result.getQuantity()+"\n\n-----------------\n"+details;
				
			}
			
			String body = "Food order Id: "+id+"\n"+"Customer Name : "+customerName+"\n"+"Customer Number : "+customerNumber+"\n"+"Order Created Time : "+orderCreatedTime+"\n"+"Order Delivery Time : "+orderDeliveryTime+"\n\n"+"Order Details : \n\n"+details+"\n\n"+"TOTAL PRICE : ₹ "+totalPrice +"\n\nVISIT AGAIN!!!"; 
			return body;
		}
}
