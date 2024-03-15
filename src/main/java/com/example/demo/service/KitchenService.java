package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.response.KitchenResponse;
import com.example.demo.entity.Kitchen;

public interface KitchenService {

	KitchenResponse saveKitchen(Kitchen kitchen);
    List<KitchenResponse> getKitchens();
	KitchenResponse getKitchenById(Long kitchenId);
}
