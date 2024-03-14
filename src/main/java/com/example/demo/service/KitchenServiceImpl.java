package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.KitchenDTO;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.Menu;
import com.example.demo.mapper.KitchenMapperImpl;
import com.example.demo.repository.KitchenRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class KitchenServiceImpl implements KitchenService{
	
	KitchenRepository kitchenRepository;
	KitchenMapperImpl dtoMapperKitchen;
	
	public KitchenServiceImpl(KitchenRepository kitchenRepository, KitchenMapperImpl dtoMapperKitchen){
        this.kitchenRepository = kitchenRepository;
        this.dtoMapperKitchen = dtoMapperKitchen;
    }

	@Override
	public List<KitchenDTO> listKitchens() {
		List<Kitchen> listKitchens = kitchenRepository.findAll();
		for(Kitchen k: listKitchens) {
			System.out.println("kitche: "+k.getName()+" - "+k.getMenuItems().size());
			for(Menu m: k.getMenuItems()) {
				System.out.println(m.getName());
			}
		}
        List<KitchenDTO> listKitchenDTOS = new ArrayList<>();
        for(Kitchen kitchen:listKitchens){
        	
        	KitchenDTO kitchenDTO = dtoMapperKitchen.fromKitchen(kitchen);
            listKitchenDTOS.add(kitchenDTO);
        }
        return listKitchenDTOS;
	}

	@Override
	public KitchenDTO saveKitchen(KitchenDTO kitchenDTO) {
		Kitchen kitchen = dtoMapperKitchen.fromKitchenDTO(kitchenDTO);
//        employee.setCreatedAt(new Date());
//        employee.setUpdatedAt(new Date());
        Kitchen savedKitchen = kitchenRepository.save(kitchen);
        return dtoMapperKitchen.fromKitchen(savedKitchen);
	}

	@Override
	public KitchenDTO getKitchenById(Long kitchenId) {
		Kitchen kitchen = kitchenRepository.findById(kitchenId).orElseThrow(null);
        return dtoMapperKitchen.fromKitchen(kitchen);
	}

}
