package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CartDTO;

public interface CartService {
	List<CartDTO> listCarts();

    CartDTO getCartById(Long cartId);

    CartDTO saveCart(CartDTO cartDTO);
}
