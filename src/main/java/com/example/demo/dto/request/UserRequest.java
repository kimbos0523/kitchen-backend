package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class UserRequest {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String securityQuestion1;
	private String securityAnswer1;
	private String securityQuestion2;
	private String securityAnswer2;

}
