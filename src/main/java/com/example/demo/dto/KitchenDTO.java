package com.example.demo.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Menu;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class KitchenDTO {
	private Long id;
	private String name;
	private String email;
	private String password;
	private String confirm_password; 
	
    private List<DayOfWeek> workingDays;
	
	// in JSON we should send it like this: "startTime": "12:59:11.332"
	private LocalTime startTime;
	private LocalTime endTime;
	
	private List<Menu> menuItems;
	
	//private byte[] photo;
	
	private Date createdAt;
    private Date updatedAt;

}
