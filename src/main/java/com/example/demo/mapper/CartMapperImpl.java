package com.example.demo.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;

@Service
public class CartMapperImpl {
	public Cart fromCartDTO(CartDTO cartDTO){
		Cart cart = new Cart();
        BeanUtils.copyProperties(cartDTO, cart);
        return cart;
    }

    public CartDTO fromCart(Cart cart){
    	CartDTO cartDTO = new CartDTO();
        BeanUtils.copyProperties(cart, cartDTO);
        return cartDTO;
    }
}
