package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.ItemDao;
import com.teamfive.project.dto.Item;
import com.teamfive.project.dto.User;

@Service
public class ItemService {
	
	@Autowired
	ItemDao dao;
	
	public Item saveItem(Item item) {
	   return dao.saveItem(item);
	}
	public String deleteItem(int id) {
	   dao.deleteItem(id);
	   return "Item "+id+" Deleted";
	}
	public List<Item> findAllItem(){
		return dao.findAllItem();
	}
	
	public Item updateItem(Item updatedItem, int id) {
		Item item = dao.getItemById(id);
		if(item != null) {
			Item newItem= dao.updateItem(updatedItem, id);
			return newItem;
		}
		else {
			return null;
		}
	}
}

