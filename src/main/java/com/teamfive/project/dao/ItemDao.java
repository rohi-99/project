package com.teamfive.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.Item;
import com.teamfive.project.dto.User;
import com.teamfive.project.repository.ItemRepository;

@Repository
public class ItemDao {
	
	@Autowired
	private ItemRepository repository;
	
	public Item saveItem(Item item) {
		return repository.save(item);
	}
	
//	public Item updateItem(Item item) {
//		return repository.save(item);
//	}
	
	public void deleteItem(int id) {
		Item item = getItemById(id);
		repository.delete(item);
	}
	
	public Item getItemById(int id) {
		return repository.findById(id).get();
	}
	
	public List<Item> findAllItem(){
		return repository.findAll();
	}
	
	public Item updateItem(Item item,int id) {
		item.setId(id);
		return repository.save(item);
		
	}
}
