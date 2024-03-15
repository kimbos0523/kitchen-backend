package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CartDTO;
import com.example.demo.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:4200")
@Slf4j
public class CartRestController {
	
	private CartService cartService;
    public CartRestController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<CartDTO> listCarts(){
        return cartService.listCarts();
    }
    
   
    
    @PostMapping("/carts")
    public CartDTO saveCart(@RequestBody CartDTO cartDTO){
        return cartService.saveCart(cartDTO);
    }

}
