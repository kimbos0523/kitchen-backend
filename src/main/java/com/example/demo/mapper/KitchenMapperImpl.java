package com.example.demo.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KitchenDTO;
import com.example.demo.entity.Kitchen;

@Service
public class KitchenMapperImpl {
	
	public Kitchen fromKitchenDTO(KitchenDTO kitchenDTO){
		Kitchen kitchen = new Kitchen();
        BeanUtils.copyProperties(kitchenDTO, kitchen);
        return kitchen;
    }

    public KitchenDTO fromKitchen(Kitchen kitchen){
    	KitchenDTO kitchenDTO = new KitchenDTO();
        BeanUtils.copyProperties(kitchen, kitchenDTO);
        return kitchenDTO;
    }

}
