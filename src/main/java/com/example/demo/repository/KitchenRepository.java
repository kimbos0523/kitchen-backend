package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Kitchen;


public interface KitchenRepository extends JpaRepository<Kitchen, Long>{
	Kitchen findById(long id);
}
