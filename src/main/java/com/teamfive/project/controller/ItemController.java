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

import com.teamfive.project.dto.Item;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.ItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
@Autowired
	
	ItemService service;
	
	@PostMapping("saveitem")
	public Item saveItem(@RequestBody Item item) {
		return service.saveItem(item);
	}
	
	@DeleteMapping("deleteitem/{id}")
	public String deleteItem(@PathVariable int id) {
		return service.deleteItem(id);
	}
	
	@GetMapping("findallitem")
	public List<Item> findAllItem(){
		return service.findAllItem();
	}
	@PutMapping("item/{id}")
	public Item updateItem(@RequestBody Item item,@PathVariable int id) {
		return service.updateItem(item, id);
		
	}
}
