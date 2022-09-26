package com.teamfive.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfive.project.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
