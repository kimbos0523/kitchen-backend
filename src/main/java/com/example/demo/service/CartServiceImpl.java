package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.User;
import com.example.demo.mapper.CartMapperImpl;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.KitchenRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CartServiceImpl implements CartService{
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	KitchenRepository kitchenRepository;
	
	@Autowired 
	CartRepository cartRepository;
	
	@Autowired
	CartMapperImpl dtoMapperCart;

	@Override
	public List<CartDTO> listCarts() {
		List<Cart> listCart = cartRepository.findAll();
		
		System.out.println("listCart: "+listCart);
		
        List<CartDTO> listCartDTO = new ArrayList<>();
        
        for(Cart cart:listCart){
        	CartDTO cartDTO = dtoMapperCart.fromCart(cart);
        	System.out.println("cartDTO: "+cartDTO);
            listCartDTO.add(cartDTO);
        }
        return listCartDTO;
	}

	@Override
	public CartDTO getCartById(Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO saveCart(CartDTO cartDTO) {
		log.info("saving new cart ** !!!");
        Cart cart = dtoMapperCart.fromCartDTO(cartDTO);


        User user = userRepository.findById(cartDTO.getUserId()).orElseThrow(null);
        Kitchen kitchen = kitchenRepository.findById(cartDTO.getKitchenId()).orElseThrow(null);

        System.out.println("user : "+user);
        System.out.println("kitchen : "+kitchen);

        cart.setUser(user);
        cart.setKitchen(kitchen);



        System.out.println("cartDTO: "+cartDTO);
        System.out.println("cart: "+cart);

        Cart savedCart = cartRepository.save(cart);
        return dtoMapperCart.fromCart(savedCart);
	}
	

}
