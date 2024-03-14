package com.example.demo.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

@Service
public class UserMapperImpl {
	public User fromUserDTO(UserDTO userDTO){
		User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    public UserDTO fromUser(User user){
    	UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
