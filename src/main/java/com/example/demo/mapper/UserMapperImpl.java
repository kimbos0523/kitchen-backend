package com.example.demo.mapper;

import com.example.demo.enums.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.entity.User;

@Service
public class UserMapperImpl {
	public User fromUserRequest(UserRequest userRequest){
		User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setRole(Role.USER);
        return user;
    }

    public UserRequest fromUser(User user){
    	UserRequest userRequest = new UserRequest();
        BeanUtils.copyProperties(user, userRequest);
        return userRequest;
    }
}
