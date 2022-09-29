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

import com.teamfive.project.dto.Menu;
import com.teamfive.project.dto.User;
import com.teamfive.project.service.MenuService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {
	@Autowired
	MenuService service;
	
	@PostMapping("/savemenu")
	public Menu saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	
	@DeleteMapping("/deleteMenu")
	public String deleteMenu(@RequestParam int id) {
		return service.deleteMenu(id);
	}
	
	
   @GetMapping("/findallmenu")
	public List<Menu> findAllMenu(){
	return service.findAllMenu();
	}
   
   @PutMapping("/menu/{id}")
	public Menu updateMenu(@RequestBody Menu menu,@PathVariable int id) {
		return service.updateMenu(menu, id);
		
	}
   
}
