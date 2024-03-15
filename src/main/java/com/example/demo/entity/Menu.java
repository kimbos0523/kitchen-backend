package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import com.example.demo.enums.FoodType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu")
@Data @NoArgsConstructor @AllArgsConstructor
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(unique = true)
	private String name;
	// in JSON we send VEGAN/NON_VEGAN 
	@Enumerated(EnumType.STRING)
	private FoodType type;
	private Integer price;
	
	
	@ManyToOne
    @JoinColumn(name = "kitchen_id", nullable = false)
	@JsonIgnore
    private Kitchen kitchen;

}
