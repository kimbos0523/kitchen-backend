package com.example.demo.dto;

import com.example.demo.enums.FoodType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MenuDTO {
	
	private String name;
	private FoodType type;
	private Integer price;
	private Long kitchen_id;

}
