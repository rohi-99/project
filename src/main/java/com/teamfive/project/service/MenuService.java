package com.teamfive.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfive.project.dao.MenuDao;
import com.teamfive.project.dto.Menu;
import com.teamfive.project.dto.User;


@Service
public class MenuService {
	@Autowired
	MenuDao dao;
	
	public Menu saveMenu(Menu menu) {
	   return dao.saveMenu(menu);
	}
	public String deleteMenu(int id) {
	   dao.deleteMenu(id);
	   return "Menu "+id+" Deleted";
	}
	public List<Menu> findAllMenu(){
		return dao.findAllMenu();
	}
	
	public Menu updateMenu(Menu updatedMenu, int id) {
		Menu menu = dao.getMenuById(id);
		if(menu != null) {
			Menu newMenu= dao.updateMenu(updatedMenu, id);
			return newMenu;
		}
		else {
			return null;
		}
	}
}
