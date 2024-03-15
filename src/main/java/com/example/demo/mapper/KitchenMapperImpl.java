package com.example.demo.mapper;

import com.example.demo.dto.response.KitchenResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kitchen;

@Service
public class KitchenMapperImpl {

    public KitchenResponse fromKitchen(Kitchen kitchen){
    	KitchenResponse kitchenResponse = new KitchenResponse();
        BeanUtils.copyProperties(kitchen, kitchenResponse);
        return kitchenResponse;
    }

}
