package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.KitchenDTO;
import com.example.demo.service.KitchenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:4200")
@Slf4j
public class KitchenRestController {
	
	private KitchenService kitchenService;
    public KitchenRestController(KitchenService kitchenService){
        this.kitchenService = kitchenService;
    }

    @GetMapping("/kitchens")
    public List<KitchenDTO> listKitchens(){
        return kitchenService.listKitchens();
    }
    
    @GetMapping("/kitchens/{id}")
    public KitchenDTO getKitchenById(@PathVariable(name="id") Long kitchenId) {
        return kitchenService.getKitchenById(kitchenId);
    }
    
    @PostMapping("/kitchens")
    public KitchenDTO saveKitchen(@RequestBody KitchenDTO kitchenDTO){
        return kitchenService.saveKitchen(kitchenDTO);
    }

}
