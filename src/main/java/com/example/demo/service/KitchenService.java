package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.KitchenDTO;

public interface KitchenService {
	
	public List<KitchenDTO> listKitchens();
	KitchenDTO saveKitchen(KitchenDTO kitchenDTO);
	KitchenDTO getKitchenById(Long kitchenId);

}
