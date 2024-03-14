package com.example.demo.dto;

import com.example.demo.entity.Kitchen;
import com.example.demo.entity.User;

import lombok.Data;

@Data
public class CartDTO {
	private Long id;
	// *********************************************
	private Long userId;
	private Long kitchenId; 
	// *********************************************
	private User user;
	private Kitchen kitchen;
}
