package com.teamfive.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamfive.project.dto.Menu;
import com.teamfive.project.repository.MenuRepository;


@Repository
public class MenuDao {

	@Autowired
	private MenuRepository repository;
	
	public Menu saveMenu(Menu menu) {
		return repository.save(menu);
	}
	
	public Menu updateManu(Menu menu) {
		return repository.save(menu);
	}
	
	public Menu deleteMenu(int id) {
		Menu menu = getMenuById(id);
		repository.delete(menu);
		return menu;
	}
	
	public Menu getMenuById(int id) {
		return repository.findById(id).get();
	}
	public List<Menu> findAllMenu(){
		return repository.findAll();
	}
}
