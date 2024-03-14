package com.example.demo.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String security_qst;

}
